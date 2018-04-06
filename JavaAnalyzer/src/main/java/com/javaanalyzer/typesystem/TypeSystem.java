package com.javaanalyzer.typesystem;

import com.javaanalyzer.smartgraph.*;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

public class TypeSystem {

    private SmartGraph<Type> graph;

    private EdgeType<Type, Type> EXTENDS;
    private EdgeType<Type, Type> IMPLEMENTS;
    private EdgeType<Type, Type> CONTAINS;
    private EdgeType<Type, Type> CALLS;

    public TypeSystem() {
        graph = new SmartGraph<>();

        EXTENDS = graph.createEdgeType("extends");
        IMPLEMENTS = graph.createEdgeType("implements");
        CONTAINS = graph.createEdgeType("CONTAINS");
        CALLS = graph.createEdgeType("CALLS");

        //graph.addSmartListener(SmartListener.INFERS(CONTAINS, EXTENDS, CONTAINS));
        //graph.addSmartListener(SmartListener.INFERS(EXTENDS, CONTAINS, CONTAINS));
    }

    public void addType(Type type) {
        graph.addNode(type);
    }

    public void declareExtends(ClassType subType, ClassType superType) {
        graph.createEdge(EXTENDS, subType, superType);
        superType.addSubType(subType);
    }

    public void declareExtends(InterfaceType subType, InterfaceType superType) {
        graph.createEdge(EXTENDS, subType, superType);
        superType.addSubType(subType);
    }

    public void declareImplements(ClassType subType, InterfaceType superType) {
        graph.createEdge(IMPLEMENTS, subType, superType);
        subType.addImplementedType(superType);
    }

    public void declareContains(Type container, Type contained) {
        graph.createEdge(CONTAINS, container, contained);
        container.addContains(contained);
    }

    public void declareCalls(Type caller, Type called) {
        graph.createEdge(CALLS, caller, called);
        caller.addCalls(called);
    }

    public Set<Type> getTypes() {
        return graph.getNodes();
    }

    public Set<Type> getSubTypes(Type type) {
        return graph.getIncomingEdges(EXTENDS, type).stream().map(Edge::getSource).collect(Collectors.toSet());
    }

    public Set<Type> getSuperTypes(Type type) {
        return graph.getOutgoingEdges(EXTENDS, type).stream().map(Edge::getTarget).collect(Collectors.toSet());
    }

    public Set<Type> getImplementingTypes(InterfaceType type) {
        return graph.getIncomingEdges(IMPLEMENTS, type).stream().map(Edge::getSource).collect(Collectors.toSet());
    }

    public Set<Type> getImplementedTypes(ClassType type) {
        return graph.getOutgoingEdges(IMPLEMENTS, type).stream().map(Edge::getTarget).collect(Collectors.toSet());
    }

    public Set<Type> getAllSubTypes(Type type) {
        Set<Type> set = getSubTypes(type);
        set.addAll(set.stream().map(this::getAllSubTypes).flatMap(Collection::stream).collect(Collectors.toSet()));
        return set;
    }

    public Set<Type> getAllSuperTypes(Type type) {
        Set<Type> set = getSuperTypes(type);
        set.addAll(set.stream().map(this::getAllSuperTypes).flatMap(Collection::stream).collect(Collectors.toSet()));
        return set;
    }

    public Set<Type> getAllImplementedTypes(ClassType type) {
        Set<Type> set = getImplementedTypes(type);
        set.addAll(set.stream().map(this::getAllSuperTypes).flatMap(Collection::stream).collect(Collectors.toSet()));
        return set;
    }

    public Set<Type> getAllImplementingTypes(InterfaceType type) {
        Set<Type> set = getImplementingTypes(type);
        set.addAll(set.stream().map(this::getAllSubTypes).flatMap(Collection::stream).collect(Collectors.toSet()));
        return set;
    }

    public Set<Type> getCalledTypes(Type type) {
        return graph.getOutgoingEdges(CALLS, type).stream().map(Edge::getTarget).collect(Collectors.toSet());
    }

    public Set<Type> getCallingTypes(Type type) {
        return graph.getIncomingEdges(CALLS, type).stream().map(Edge::getSource).collect(Collectors.toSet());
    }

    public Set<Type> getContainedTypes(Type type) {
        return graph.getOutgoingEdges(CONTAINS, type).stream().map(Edge::getTarget).collect(Collectors.toSet());
    }

    public Set<Type> getContainingTypes(Type type) {
        return graph.getIncomingEdges(CONTAINS, type).stream().map(Edge::getSource).collect(Collectors.toSet());
    }

    public EdgeType<Type, Type> getCalls() {
        return CALLS;
    }

    public EdgeType<Type, Type> getContains() {
        return CONTAINS;
    }

    public EdgeType<Type, Type> getExtends() {
        return EXTENDS;
    }

    public EdgeType<Type, Type> getImplements() {
        return IMPLEMENTS;
    }

}
