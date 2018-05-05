package com.javaanalyzer.typecollector;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ParseResult;
import com.github.javaparser.ParserConfiguration;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.utils.Log;
import com.github.javaparser.utils.SourceRoot;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.List;

import static com.github.javaparser.ParseStart.COMPILATION_UNIT;
import static com.github.javaparser.Providers.provider;
import static com.github.javaparser.utils.CodeGenerationUtils.fileInPackageRelativePath;
import static com.github.javaparser.utils.CodeGenerationUtils.packageAbsolutePath;
import static com.github.javaparser.utils.Utils.assertNotNull;
import static java.nio.file.FileVisitResult.CONTINUE;
import static java.nio.file.FileVisitResult.SKIP_SUBTREE;

public class OurSourceRoot extends SourceRoot {


    public OurSourceRoot(Path root) {
        super(root);
    }

    public OurSourceRoot(Path root, ParserConfiguration parserConfiguration) {
        super(root, parserConfiguration);
    }

    public List<ParseResult<CompilationUnit>> tryToParse(String startPackage) throws IOException {
        assertNotNull(startPackage);
        final Path path = packageAbsolutePath(getRoot(), startPackage);
        Files.walkFileTree(path, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                if (!attrs.isDirectory() && file.toString().endsWith(".java")) {
                    try {
                        Path relative = getRoot().relativize(file.getParent());
                        tryToParse(relative.toString(), file.getFileName().toString());
                    }
                    catch (IOException ignored) {
                        ignored.printStackTrace();
                    }
                }
                return CONTINUE;
            }

            @Override
            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                return isSensibleDirectoryToEnter(dir) ? CONTINUE : SKIP_SUBTREE;
            }
        });
        return getCache();
    }

    public ParseResult<CompilationUnit> tryToParse(String startPackage, String filename, ParserConfiguration configuration) throws IOException {
        try {
            return super.tryToParse(startPackage, filename, configuration);
        }
        catch (IOException ex) {
            assertNotNull(startPackage);
            assertNotNull(filename);
            final Path relativePath = Paths.get(startPackage, filename).normalize();
            final Path path = getRoot().resolve(relativePath);
            Log.trace("Parsing %s", path);
            final ParseResult<CompilationUnit> result = new JavaParser(configuration)
                    .parse(COMPILATION_UNIT, provider(path));
            result.getResult().ifPresent(cu -> cu.setStorage(path));
            result.getResult().ifPresent(this::add);
            return result;
        }

    }

    private static boolean isSensibleDirectoryToEnter(Path dir) throws IOException {
        final String dirToEnter = dir.getFileName().toString();

        // Don't enter directories that are hidden, assuming that people don't store source files in hidden directories.
        if (Files.isHidden(dir) || (boolean) Files.getAttribute(dir, "dos:hidden")) {
            Log.trace("Not processing directory \"%s\"", dirToEnter);
            return false;
        }
        return true;
    }

}
