package com.javaanalyzer.typesystem;

import com.javaanalyzer.smartgraph.*;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

public class TypeSystem {

    private SmartGraph<Entity> graph;

    private EdgeType<Entity, Entity> EXTENDS;
    private EdgeType<Entity, Entity> IMPLEMENTS;
    private EdgeType<Entity, Entity> CONTAINS;
    private EdgeType<Entity, Entity> CALLS;
    private EdgeType<Entity, Entity> ABSTRACT;
    private EdgeType<Entity, Entity> CONSTRUCTORS;
    private EdgeType<Entity, Entity> METHODS;
    private EdgeType<Entity, Entity> FIELDS;
    private EdgeType<Entity, Entity> ACCESS_SPECIFIER;
    private EdgeType<Entity, Entity> STATIC;
    private EdgeType<Entity, Entity> RETURNS;

    public TypeSystem() {
        graph = new SmartGraph<>();

        EXTENDS = graph.createEdgeType("EXTENDS");
        IMPLEMENTS = graph.createEdgeType("IMPLEMENTS");
        CONTAINS = graph.createEdgeType("CONTAINS");
        CALLS = graph.createEdgeType("CALLS");
        ABSTRACT = graph.createEdgeType("ABSTRACT");
        CONSTRUCTORS = graph.createEdgeType("CONSTRUCTORS");
        METHODS = graph.createEdgeType("METHODS");
        FIELDS = graph.createEdgeType("FIELDS");
        ACCESS_SPECIFIER = graph.createEdgeType("ACCESS_SPECIFIER");
        STATIC = graph.createEdgeType("STATIC");
        RETURNS = graph.createEdgeType("RETURNS");

        addEntity(AccessSpecifierEntity.DEFAULT);
        addEntity(AccessSpecifierEntity.PRIVATE);
        addEntity(AccessSpecifierEntity.PUBLIC);
        addEntity(AccessSpecifierEntity.PROTECTED);

        addEntity(BooleanEntity.TRUE);
        addEntity(BooleanEntity.FALSE);
    }

    public void addEntity(Entity type) {
        graph.addNode(type);
    }

    public void declareExtends(ClassType subType, ClassType superType) {
        graph.createEdge(EXTENDS, subType, superType);
    }

    public void declareExtends(InterfaceType subType, InterfaceType superType) {
        graph.createEdge(EXTENDS, subType, superType);
    }

    public void declareImplements(ClassType subType, InterfaceType superType) {
        graph.createEdge(IMPLEMENTS, subType, superType);
    }

    public void declareContains(Type container, Type contained) {
        graph.createEdge(CONTAINS, container, contained);
    }

    public void declareCalls(Entity caller, Entity called) {
        graph.createEdge(CALLS, caller, called);
    }

    public void declareAbstract(Entity entity, BooleanEntity booleanEntity) {
        graph.createEdge(ABSTRACT, entity, booleanEntity);
    }

    public void declareConstructors(ClassType type, Constructor constructor) {
        graph.createEdge(CONSTRUCTORS, type, constructor);
    }

    public void declareMethods(Type type, Method method) {
        graph.createEdge(METHODS, type, method);
    }

    public void declareFields(Type type, Field field) {
        graph.createEdge(FIELDS, type, field);
    }

    public void declareAccessSpecifier(Entity entity, AccessSpecifierEntity accessSpecifierEntity) {
        graph.createEdge(ACCESS_SPECIFIER, entity, accessSpecifierEntity);
    }

    public void declareStatic(Entity entity, BooleanEntity booleanEntity) {
        graph.createEdge(STATIC, entity, booleanEntity);
    }

    public void declareReturns(Entity entity, Type type) {
        graph.createEdge(RETURNS, entity, type);
    }

    public Set<Entity> getEntities() {
        return graph.getNodes();
    }

    public EdgeType<Entity, Entity> getCalls() {
        return CALLS;
    }

    public EdgeType<Entity, Entity> getContains() {
        return CONTAINS;
    }

    public EdgeType<Entity, Entity> getExtends() {
        return EXTENDS;
    }

    public EdgeType<Entity, Entity> getImplements() {
        return IMPLEMENTS;
    }

    public EdgeType<Entity, Entity> getAbstract() {
        return ABSTRACT;
    }

    public EdgeType<Entity, Entity> getConstructors() {
        return CONSTRUCTORS;
    }

    public EdgeType<Entity, Entity> getMethods() {
        return METHODS;
    }

    public EdgeType<Entity, Entity> getFields() {
        return FIELDS;
    }

    public EdgeType<Entity, Entity> getAccessSpecifier() {
        return ACCESS_SPECIFIER;
    }

    public EdgeType<Entity, Entity> getStatic() {
        return STATIC;
    }

    public EdgeType<Entity, Entity> getReturns() {
        return RETURNS;
    }

}
