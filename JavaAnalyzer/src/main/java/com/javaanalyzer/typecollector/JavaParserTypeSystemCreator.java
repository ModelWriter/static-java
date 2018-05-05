package com.javaanalyzer.typecollector;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ParseResult;
import com.github.javaparser.ParserConfiguration;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.ConstructorDeclaration;
import com.github.javaparser.ast.body.FieldDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.expr.MethodCallExpr;
import com.github.javaparser.ast.expr.ObjectCreationExpr;
import com.github.javaparser.resolution.declarations.ResolvedConstructorDeclaration;
import com.github.javaparser.resolution.declarations.ResolvedMethodDeclaration;
import com.github.javaparser.resolution.declarations.ResolvedReferenceTypeDeclaration;
import com.github.javaparser.resolution.types.ResolvedType;
import com.github.javaparser.symbolsolver.JavaSymbolSolver;
import com.github.javaparser.symbolsolver.javaparsermodel.declarations.JavaParserClassDeclaration;
import com.github.javaparser.symbolsolver.resolution.typesolvers.CombinedTypeSolver;
import com.github.javaparser.symbolsolver.resolution.typesolvers.JarTypeSolver;
import com.github.javaparser.symbolsolver.resolution.typesolvers.JavaParserTypeSolver;
import com.github.javaparser.symbolsolver.resolution.typesolvers.ReflectionTypeSolver;
import com.github.javaparser.utils.SourceRoot;
import com.javaanalyzer.gui.ProgressInformer;
import com.javaanalyzer.typesystem.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.*;
import java.util.function.Consumer;
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
        return createTypeSystem(null);
    }

    public TypeSystem createTypeSystem(Consumer<Double> consumer) {

        ProgressInformer progressInformer = new ProgressInformer(consumer == null ? (d) -> {} : consumer);

        TypeSystem typeSystem = new TypeSystem();

        Map<ClassOrInterfaceDeclaration, ResolvedReferenceTypeDeclaration> classToResolvedType = new HashMap<>();
        Map<String, Entity> entityMap = new HashMap<>();

        JavaSymbolSolver symbolSolver = new JavaSymbolSolver(combinedTypeSolver);
        JavaParser.getStaticConfiguration().setSymbolResolver(symbolSolver);

        SourceRoot sourceRoot = new OurSourceRoot(new File(path).toPath(), JavaParser.getStaticConfiguration());
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

        progressInformer.init((int) compilationUnits.stream()
                .mapToLong(e -> e.findAll(ClassOrInterfaceDeclaration.class).size()).sum() * 2);

        compilationUnits.forEach(cu -> cu.findAll(ClassOrInterfaceDeclaration.class).forEach(declaration -> {
            try {
                ResolvedReferenceTypeDeclaration resolved = declaration.resolve();
                Type type = declaration.isInterface()
                        ? new InterfaceType(resolved.getQualifiedName(), resolved.getClassName())
                        : new ClassType(resolved.getQualifiedName(), resolved.getClassName(), declaration.isAbstract());

                String path = cu.getStorage().map(e -> e.getPath().toString()).orElse("");

                type.setLocation(path);

                classToResolvedType.put(declaration, resolved);
                entityMap.put(resolved.getQualifiedName(), type);
                typeSystem.addEntity(type);

                resolved.getDeclaredMethods().forEach(m -> {
                    try {
                        Method method = new Method(m.getQualifiedSignature(), type.getShortName() + "::" + m.getSignature());
                        method.setLocation(path);
                        entityMap.put(m.getQualifiedSignature(), method);
                        typeSystem.addEntity(method);
                    }
                    catch (Exception ignored) { }
                });

                if (resolved instanceof JavaParserClassDeclaration) {
                    ((JavaParserClassDeclaration) resolved).getConstructors().forEach(constructorDeclaration -> {

                        Constructor constructor = new Constructor(constructorDeclaration.getQualifiedSignature()
                                , type.getShortName() + "::" + constructorDeclaration.getSignature());

                        entityMap.put(constructorDeclaration.getQualifiedSignature(), constructor);

                        constructor.setLocation(type.getLocation());

                        switch (constructorDeclaration.accessSpecifier()) {
                            case PUBLIC:
                                typeSystem.declareAccessSpecifier(constructor, AccessSpecifierEntity.PUBLIC);
                                break;
                            case PRIVATE:
                                typeSystem.declareAccessSpecifier(constructor, AccessSpecifierEntity.PRIVATE);
                                break;
                            case PROTECTED:
                                typeSystem.declareAccessSpecifier(constructor, AccessSpecifierEntity.PROTECTED);
                                break;
                            case DEFAULT:
                                typeSystem.declareAccessSpecifier(constructor, AccessSpecifierEntity.DEFAULT);
                                break;
                        }

                        if (type instanceof ClassType) {
                            typeSystem.declareConstructors((ClassType) type, constructor);
                        }
                    });
                }
            }
            catch (Exception ignored) { }
            finally {
                progressInformer.add();
            }
        }));

        compilationUnits.forEach(cu -> cu.findAll(ClassOrInterfaceDeclaration.class).forEach(declaration -> {
            try {
                ResolvedReferenceTypeDeclaration resolved = classToResolvedType.get(declaration);
                Type type = (Type) entityMap.get(resolved.getQualifiedName());

                if (type == null)
                    return;

                // Get inheritances
                if (type instanceof InterfaceType) {
                    resolved.getAncestors().stream()
                            .map(e -> entityMap.get(e.getQualifiedName()))
                            .forEach(superType -> {
                                if (superType instanceof InterfaceType)
                                    typeSystem.declareExtends((InterfaceType) type, (InterfaceType) superType);
                            });
                }
                else if (type instanceof ClassType) {
                    resolved.getAncestors().stream()
                            .map(e -> entityMap.get(e.getQualifiedName()))
                            .forEach(superType -> {
                                if (superType instanceof ClassType)
                                    typeSystem.declareExtends((ClassType) type, (ClassType) superType);
                                else if (superType instanceof InterfaceType)
                                    typeSystem.declareImplements((ClassType) type, (InterfaceType) superType);
                            });
                }

                if (declaration.isPrivate()) {
                    typeSystem.declareAccessSpecifier(type, AccessSpecifierEntity.PRIVATE);
                }
                else if (declaration.isPublic()) {
                    typeSystem.declareAccessSpecifier(type, AccessSpecifierEntity.PUBLIC);
                }
                else if (declaration.isProtected()) {
                    typeSystem.declareAccessSpecifier(type, AccessSpecifierEntity.PROTECTED);
                }
                else {
                    typeSystem.declareAccessSpecifier(type, AccessSpecifierEntity.DEFAULT);
                }

                if (declaration.isAbstract()) {
                    typeSystem.declareAbstract(type, BooleanEntity.TRUE);
                }

                try {
                    resolved.getDeclaredFields().forEach(fieldDeclaration -> {
                        try {
                            ResolvedReferenceTypeDeclaration fieldType = fieldDeclaration.getType().asReferenceType().getTypeDeclaration();

                            Field field = new Field(type.getFullName() + "." + fieldDeclaration.getName(), type.getShortName() + "." + fieldDeclaration.getName());

                            field.setLocation(type.getLocation());

                            typeSystem.declareFields(type, field);

                            switch (fieldDeclaration.accessSpecifier()) {
                                case PUBLIC:
                                    typeSystem.declareAccessSpecifier(field, AccessSpecifierEntity.PUBLIC);
                                    break;
                                case PRIVATE:
                                    typeSystem.declareAccessSpecifier(field, AccessSpecifierEntity.PRIVATE);
                                    break;
                                case PROTECTED:
                                    typeSystem.declareAccessSpecifier(field, AccessSpecifierEntity.PROTECTED);
                                    break;
                                case DEFAULT:
                                    typeSystem.declareAccessSpecifier(field, AccessSpecifierEntity.DEFAULT);
                                    break;
                            }

                            typeSystem.declareStatic(field, fieldDeclaration.isStatic() ? BooleanEntity.TRUE : BooleanEntity.FALSE);

                            Type contained = (Type) entityMap.get(fieldType.getQualifiedName());
                            if (contained != null)
                                typeSystem.declareContains(type, contained);
                            typeSystem.declareReturns(field, contained);
                        } catch (Exception ignored) {
                        }
                    });
                }
                catch (Exception ignored) {}

                // Get methods
                resolved.getDeclaredMethods().forEach(m -> {
                    Method method = (Method) entityMap.get(m.getQualifiedSignature());

                    if (method == null)
                        return;

                    typeSystem.declareMethods(type, method);

                    switch (m.accessSpecifier()) {
                        case PUBLIC:
                            typeSystem.declareAccessSpecifier(method, AccessSpecifierEntity.PUBLIC);
                            break;
                        case PRIVATE:
                            typeSystem.declareAccessSpecifier(method, AccessSpecifierEntity.PRIVATE);
                            break;
                        case PROTECTED:
                            typeSystem.declareAccessSpecifier(method, AccessSpecifierEntity.PROTECTED);
                            break;
                        case DEFAULT:
                            typeSystem.declareAccessSpecifier(method, AccessSpecifierEntity.DEFAULT);
                            break;
                    }

                    typeSystem.declareStatic(method, m.isStatic() ? BooleanEntity.TRUE : BooleanEntity.FALSE);
                    typeSystem.declareAbstract(method, m.isAbstract() ? BooleanEntity.TRUE : BooleanEntity.FALSE);

                    try {
                        Type returnType = (Type) entityMap.get(m.getReturnType().asReferenceType().getTypeDeclaration().getQualifiedName());

                        if (returnType == null)
                            return;

                        typeSystem.declareReturns(method, returnType);
                    }
                    catch (Exception ignored) { }
                });

                // Get calls
                declaration.findAll(MethodDeclaration.class).forEach(methodDeclaration -> {
                    try {
                        ResolvedMethodDeclaration resolvedMethodDeclaration = methodDeclaration.resolve();
                        Method method = (Method) entityMap.get(resolvedMethodDeclaration.getQualifiedSignature());

                        if (method == null) {
                            method = (Method) entityMap.get(type.getFullName() + "." + resolvedMethodDeclaration.getName());
                            if (method == null)
                                return;
                        }

                        final Method finalMethod = method;
                        methodDeclaration.findAll(ObjectCreationExpr.class).forEach(c -> {
                            try {
                                ResolvedConstructorDeclaration rcd = c.resolveInvokedConstructor();
                                ResolvedReferenceTypeDeclaration rrtd = rcd.declaringType();

                                Entity cons = entityMap.get(rcd.getQualifiedSignature());
                                Entity owner = entityMap.get(rrtd.getQualifiedName());

                                if (cons != null) {
                                    typeSystem.declareCalls(finalMethod, cons);
                                }
                                if (owner != null) {
                                    typeSystem.declareCalls(type, owner);
                                }
                            }
                            catch (Exception ignored) {}
                        });
                        methodDeclaration.findAll(MethodCallExpr.class).forEach(m -> {
                            try {
                                ResolvedMethodDeclaration rmd = m.resolveInvokedMethod();
                                ResolvedReferenceTypeDeclaration rrtd = rmd.declaringType();

                                Entity owner = entityMap.get(rrtd.getQualifiedName());
                                Method called = (Method) entityMap.get(rmd.getQualifiedSignature());

                                if (called != null) {
                                    typeSystem.declareCalls(finalMethod, called);
                                }
                                if (owner != null) {
                                    typeSystem.declareCalls(type, owner);
                                }
                            }
                            catch (Exception ignored) {}
                        });
                    }
                    catch (Exception ignored) {}
                });

            }
            catch (Exception ignored) {
            }
            finally {
                progressInformer.add();
            }
        }));

        return typeSystem;
    }

}
