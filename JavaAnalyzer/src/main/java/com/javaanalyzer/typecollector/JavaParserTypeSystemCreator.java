package com.javaanalyzer.typecollector;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ParseResult;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.FieldDeclaration;
import com.github.javaparser.ast.expr.MethodCallExpr;
import com.github.javaparser.resolution.declarations.ResolvedReferenceTypeDeclaration;
import com.github.javaparser.symbolsolver.JavaSymbolSolver;
import com.github.javaparser.symbolsolver.resolution.typesolvers.CombinedTypeSolver;
import com.github.javaparser.symbolsolver.resolution.typesolvers.JarTypeSolver;
import com.github.javaparser.symbolsolver.resolution.typesolvers.JavaParserTypeSolver;
import com.github.javaparser.symbolsolver.resolution.typesolvers.ReflectionTypeSolver;
import com.github.javaparser.utils.SourceRoot;
import com.javaanalyzer.typesystem.ClassType;
import com.javaanalyzer.typesystem.InterfaceType;
import com.javaanalyzer.typesystem.Type;
import com.javaanalyzer.typesystem.TypeSystem;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class JavaParserTypeSystemCreator {

    private String path;
    private CombinedTypeSolver combinedTypeSolver;

    public JavaParserTypeSystemCreator(String path, boolean findAllRoots) {
        this.path = path;
        combinedTypeSolver = new CombinedTypeSolver();
        combinedTypeSolver.add(new ReflectionTypeSolver());

        if (findAllRoots)
            PackageRootFinder.getDirectories(path).forEach(this::addPackagePath);
        else
            addPackagePath(path);
    }

    public void addPackagePath(String dir) {
        combinedTypeSolver.add(new JavaParserTypeSolver(new File(dir)));
    }

    public void addJarPath(String dir) throws IOException {
        combinedTypeSolver.add(new JarTypeSolver(dir));
    }

    public TypeSystem createTypeSystem() {

        TypeSystem typeSystem = new TypeSystem();
        Map<String, Type> typeMap = new HashMap<>();

        JavaSymbolSolver symbolSolver = new JavaSymbolSolver(combinedTypeSolver);
        JavaParser.getStaticConfiguration().setSymbolResolver(symbolSolver);

        SourceRoot sourceRoot = new SourceRoot(new File(path).toPath(), JavaParser.getStaticConfiguration());
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
            e.printStackTrace();
            return typeSystem;
        }

        // First, get all types
        compilationUnits.forEach(cu -> {
            cu.findAll(ClassOrInterfaceDeclaration.class).forEach(declaration -> {
                try {
                    ResolvedReferenceTypeDeclaration resolved = declaration.resolve();
                    Type type = declaration.isInterface()
                            ? new InterfaceType(resolved.getQualifiedName(), resolved.getClassName())
                            : new ClassType(resolved.getQualifiedName(), resolved.getClassName(), declaration.isAbstract());

                    cu.getStorage().ifPresent(storage -> type.setLocation(storage.getPath().toString()));

                    typeMap.put(resolved.getQualifiedName(), type);
                    typeSystem.addType(type);
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            });
        });

        // Second, get the relations
        compilationUnits.forEach(cu -> {
            cu.findAll(ClassOrInterfaceDeclaration.class).forEach(declaration -> {
                try {
                    ResolvedReferenceTypeDeclaration resolved = declaration.resolve();
                    Type type = typeMap.getOrDefault(resolved.getQualifiedName(), null);

                    if (type == null)
                        return;

                    // Get inheritances
                    if (type instanceof InterfaceType) {
                        resolved.getAncestors().stream()
                                .map(t -> typeMap.getOrDefault(t.getQualifiedName(), null))
                                .forEach(superType -> {
                                    if (superType instanceof InterfaceType)
                                        typeSystem.declareExtends((InterfaceType) type, (InterfaceType) superType);
                                });
                    }
                    else if (type instanceof ClassType) {
                        resolved.getAncestors().stream()
                                .map(t -> typeMap.getOrDefault(t.getQualifiedName(), null))
                                .forEach(superType -> {
                                    if (superType instanceof ClassType)
                                        typeSystem.declareExtends((ClassType) type, (ClassType) superType);
                                    else if (superType instanceof InterfaceType)
                                        typeSystem.declareImplements((ClassType) type, (InterfaceType) superType);
                                });
                    }

                    // Get contains
                    declaration.findAll(FieldDeclaration.class).stream().map(e -> {
                        try {
                            return e.getElementType().resolve().asReferenceType().getQualifiedName();
                        }
                        catch (Exception ignored) {
                            return null;
                        }
                    }).filter(Objects::nonNull).distinct().forEach(name -> {
                        Type contained = typeMap.getOrDefault(name, null);
                        if (contained != null)
                            typeSystem.declareContains(type, contained);
                    });

                    // Get calls
                    declaration.findAll(MethodCallExpr.class).stream().map(m -> {
                        try {
                            return m.resolveInvokedMethod().declaringType().getQualifiedName();
                        }
                        catch (Exception ignored) {
                            return null;
                        }
                    }).filter(Objects::nonNull).distinct().forEach(name -> {
                        Type called = typeMap.getOrDefault(name, null);
                        if (called != null)
                            typeSystem.declareCalls(type, called);
                    });
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            });
        });

        return typeSystem;
    }
}
