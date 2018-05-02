package com.javaanalyzer.typecollector;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ParseResult;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.PackageDeclaration;
import com.github.javaparser.utils.SourceRoot;
import com.javaanalyzer.gui.ProgressInformer;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class PackageRootFinder {
    private ProgressInformer progressInformer;
    private List<File> allJavaFiles;
    private File file;

    private PackageRootFinder(String path, Consumer<Double> consumer) {
        this.progressInformer = new ProgressInformer(consumer);
        file = new File(path);
        allJavaFiles = new ArrayList<>();
    }

    public static Set<String> getDirectories(String path) {
        PackageRootFinder rootFinder = new PackageRootFinder(path, (e) -> {});
        return rootFinder.getAllRootDirectories();
    }

    public static Set<String> getDirectories(String path, Consumer<Double> consumer) {
        PackageRootFinder rootFinder = new PackageRootFinder(path, consumer);
        return rootFinder.getAllRootDirectories();
    }

    private void getAllJavaFiles(File file) {
        File[] files;
        try {
            files = file.listFiles();
        }
        catch (NullPointerException e) {
            e.printStackTrace();
            return;
        }

        assert files != null;
        for (File f : files) {
            if (f.isDirectory()) {
                getAllJavaFiles(f);
            } else if (f.getName().endsWith(".java")) {
                f = f.getAbsoluteFile();
                allJavaFiles.add(f);
            }
        }

        progressInformer.init(allJavaFiles.size());
    }

    private Set<String> getAllRootDirectories(){
        Set<String> allRootDirectoriesPath = new HashSet<>();

        getAllJavaFiles(file);

        for (File f : allJavaFiles) {
            SourceRoot sourceRoot = new SourceRoot(f.getParentFile().toPath(), JavaParser.getStaticConfiguration());

            List<CompilationUnit> compilationUnits;

            try {
                compilationUnits = sourceRoot.tryToParse().stream()
                        .filter(ParseResult::isSuccessful)
                        .map(ParseResult::getResult)
                        .filter(Optional::isPresent)
                        .map(Optional::get)
                        .collect(Collectors.toList());
            }
            catch (IOException e) {
                compilationUnits = Collections.emptyList();
            }

            compilationUnits.forEach(compilationUnit -> {
                if (compilationUnit.getPackageDeclaration().isPresent()) {

                    String[] s = compilationUnit.getPackageDeclaration().get().getNameAsString().split("\\.");
                    String packageHierarchy = Arrays.stream(s).collect(Collectors.joining(System.getProperty("file.separator")));
                    int index = f.getPath().indexOf(packageHierarchy);
                    if (index > 1) {
                        String str = f.getPath().substring(0, index - 1);
                        allRootDirectoriesPath.add(str);
                    }
                }
                else {
                    allRootDirectoriesPath.add(f.getParent());
                }

                progressInformer.add();
            });
        }

        return allRootDirectoriesPath;
    }

}
