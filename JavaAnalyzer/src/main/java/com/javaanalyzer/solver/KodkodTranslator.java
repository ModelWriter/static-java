package com.javaanalyzer.solver;

import com.javaanalyzer.typesystem.*;
import kodkod.ast.Formula;
import kodkod.ast.Relation;
import kodkod.engine.Solution;
import kodkod.engine.Solver;
import kodkod.engine.satlab.SATFactory;
import kodkod.instance.*;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by harun on 2/24/18.
 */
public class KodkodTranslator implements Iterator<Map<String, Entity>> {

    private Universe universe;
    private TupleFactory tupleFactory;
    private Bounds bounds;
    private Set<Formula> formulas;

    private Solver solver;

    public final Relation CLASS;
    public final Relation INTERFACE;
    public final Relation METHOD;
    public final Relation CONSTRUCTOR;
    public final Relation FIELD;

    public final Relation BOOLEAN_TRUE;
    public final Relation BOOLEAN_FALSE;
    public final Relation ACCESS_PUBLIC;
    public final Relation ACCESS_PRIVATE;
    public final Relation ACCESS_PROTECTED;
    public final Relation ACCESS_DEFAULT;

    public final Relation EXTENDS;
    public final Relation IMPLEMENTS;
    public final Relation CONTAINS;
    public final Relation CALLS;
    public final Relation ABSTRACT;
    public final Relation STATIC;
    public final Relation ACCESS_SPECIFIER;
    public final Relation CONSTRUCTORS;
    public final Relation METHODS;
    public final Relation FIELDS;
    public final Relation RETURNS;

    private Map<String, Relation> relationMap;
    private Set<Relation> variables;

    private Iterator<Solution> solutionIterator;
    private Solution currentSolution;

    private TupleSet possibleBound;

    public KodkodTranslator(TypeSystem typeSystem) {
        formulas = new HashSet<>();
        relationMap = new HashMap<>();
        variables = new HashSet<>();
        solutionIterator = null;
        currentSolution = null;

        universe = new Universe(typeSystem.getEntities());

        CLASS = Relation.unary("Class");
        INTERFACE = Relation.unary("Interface");
        METHOD = Relation.unary("Method");
        CONSTRUCTOR = Relation.unary("Constructor");
        FIELD = Relation.unary("Field");

        BOOLEAN_TRUE = Relation.unary("True");
        BOOLEAN_FALSE = Relation.unary("False");

        ACCESS_PUBLIC = Relation.unary("Public");
        ACCESS_PRIVATE = Relation.unary("Private");
        ACCESS_PROTECTED = Relation.unary("Protected");
        ACCESS_DEFAULT = Relation.unary("Default");

        EXTENDS = Relation.binary("extends");
        IMPLEMENTS = Relation.binary("implements");
        CONTAINS = Relation.binary("contains");
        CALLS = Relation.binary("calls");
        ABSTRACT = Relation.binary("abstract");
        STATIC = Relation.binary("static");
        ACCESS_SPECIFIER = Relation.binary("access");
        CONSTRUCTORS = Relation.binary("constructors");
        METHODS = Relation.binary("methods");
        FIELDS = Relation.binary("fields");
        RETURNS = Relation.binary("returns");

        relationMap.put(CLASS.name(), CLASS);
        relationMap.put(INTERFACE.name(), INTERFACE);
        relationMap.put(METHOD.name(), METHOD);
        relationMap.put(CONSTRUCTOR.name(), CONSTRUCTOR);
        relationMap.put(FIELD.name(), FIELD);
        relationMap.put(BOOLEAN_TRUE.name(), BOOLEAN_TRUE);
        relationMap.put(BOOLEAN_FALSE.name(), BOOLEAN_FALSE);
        relationMap.put(ACCESS_PUBLIC.name(), ACCESS_PUBLIC);
        relationMap.put(ACCESS_PRIVATE.name(), ACCESS_PRIVATE);
        relationMap.put(ACCESS_PROTECTED.name(), ACCESS_PROTECTED);
        relationMap.put(ACCESS_DEFAULT.name(), ACCESS_DEFAULT);
        relationMap.put(EXTENDS.name(), EXTENDS);
        relationMap.put(IMPLEMENTS.name(), IMPLEMENTS);
        relationMap.put(CONTAINS.name(), CONTAINS);
        relationMap.put(CALLS.name(), CALLS);
        relationMap.put(ABSTRACT.name(), ABSTRACT);
        relationMap.put(STATIC.name(), STATIC);
        relationMap.put(ACCESS_SPECIFIER.name(), ACCESS_SPECIFIER);
        relationMap.put(CONSTRUCTORS.name(), CONSTRUCTORS);
        relationMap.put(METHODS.name(), METHODS);
        relationMap.put(FIELDS.name(), FIELDS);
        relationMap.put(RETURNS.name(), RETURNS);
        relationMap.put("type", RETURNS);

        tupleFactory = universe.factory();
        bounds = new Bounds(universe);

        Set<?> classTuples = typeSystem.getEntities().stream()
                .filter(e -> e instanceof ClassType)
                .collect(Collectors.toSet());
        bounds.boundExactly(CLASS, classTuples.isEmpty() ? tupleFactory.noneOf(1) : tupleFactory.setOf(classTuples.toArray()));

        Set<?> interfaceTuples = typeSystem.getEntities().stream()
                .filter(e -> e instanceof InterfaceType)
                .collect(Collectors.toSet());
        bounds.boundExactly(INTERFACE, interfaceTuples.isEmpty() ? tupleFactory.noneOf(1) : tupleFactory.setOf(interfaceTuples.toArray()));

        Set<?> methodTuples = typeSystem.getEntities().stream()
                .filter(e -> e instanceof Method)
                .collect(Collectors.toSet());
        bounds.boundExactly(METHOD, methodTuples.isEmpty() ? tupleFactory.noneOf(1) : tupleFactory.setOf(methodTuples.toArray()));

        Set<?> constructorTuples = typeSystem.getEntities().stream()
                .filter(e -> e instanceof Constructor)
                .collect(Collectors.toSet());
        bounds.boundExactly(CONSTRUCTOR, constructorTuples.isEmpty() ? tupleFactory.noneOf(1) : tupleFactory.setOf(constructorTuples.toArray()));

        Set<?> fieldTuples = typeSystem.getEntities().stream()
                .filter(e -> e instanceof Field)
                .collect(Collectors.toSet());
        bounds.boundExactly(FIELD, fieldTuples.isEmpty() ? tupleFactory.noneOf(1) : tupleFactory.setOf(fieldTuples.toArray()));


        Set<Object> possibleSet = new HashSet<>();
        possibleSet.addAll(classTuples);
        possibleSet.addAll(interfaceTuples);
        possibleSet.addAll(methodTuples);
        possibleSet.addAll(constructorTuples);
        possibleSet.addAll(fieldTuples);

        possibleBound = possibleSet.isEmpty() ? tupleFactory.noneOf(1) : tupleFactory.setOf(possibleSet.toArray());

        bounds.boundExactly(BOOLEAN_TRUE, tupleFactory.setOf(BooleanEntity.TRUE));
        bounds.boundExactly(BOOLEAN_FALSE, tupleFactory.setOf(BooleanEntity.FALSE));

        bounds.boundExactly(ACCESS_PUBLIC, tupleFactory.setOf(AccessSpecifierEntity.PUBLIC));
        bounds.boundExactly(ACCESS_PRIVATE, tupleFactory.setOf(AccessSpecifierEntity.PRIVATE));
        bounds.boundExactly(ACCESS_PROTECTED, tupleFactory.setOf(AccessSpecifierEntity.PROTECTED));
        bounds.boundExactly(ACCESS_DEFAULT, tupleFactory.setOf(AccessSpecifierEntity.DEFAULT));


        Set<Tuple> extendsTuples = typeSystem.getExtends().getEdges().stream()
                .map(e -> tupleFactory.tuple(e.getSource(), e.getTarget()))
                .collect(Collectors.toSet());
        bounds.boundExactly(EXTENDS, extendsTuples.isEmpty() ? tupleFactory.noneOf(2) : tupleFactory.setOf(extendsTuples));

        Set<Tuple> implementsTuples = typeSystem.getImplements().getEdges().stream()
                .map(e -> tupleFactory.tuple(e.getSource(), e.getTarget()))
                .collect(Collectors.toSet());
        bounds.boundExactly(IMPLEMENTS, implementsTuples.isEmpty() ? tupleFactory.noneOf(2) : tupleFactory.setOf(implementsTuples));

        Set<Tuple> containsTuples = typeSystem.getContains().getEdges().stream()
                .map(e -> tupleFactory.tuple(e.getSource(), e.getTarget()))
                .collect(Collectors.toSet());
        bounds.boundExactly(CONTAINS, containsTuples.isEmpty() ? tupleFactory.noneOf(2) : tupleFactory.setOf(containsTuples));

        Set<Tuple> callsTuples = typeSystem.getCalls().getEdges().stream()
                .map(e -> tupleFactory.tuple(e.getSource(), e.getTarget()))
                .collect(Collectors.toSet());
        bounds.boundExactly(CALLS, callsTuples.isEmpty() ? tupleFactory.noneOf(2) : tupleFactory.setOf(callsTuples));

        Set<Tuple> abstractTuples = typeSystem.getAbstract().getEdges().stream()
                .map(e -> tupleFactory.tuple(e.getSource(), e.getTarget()))
                .collect(Collectors.toSet());
        bounds.boundExactly(ABSTRACT, abstractTuples.isEmpty() ? tupleFactory.noneOf(2) : tupleFactory.setOf(abstractTuples));

        Set<Tuple> staticTuples = typeSystem.getStatic().getEdges().stream()
                .map(e -> tupleFactory.tuple(e.getSource(), e.getTarget()))
                .collect(Collectors.toSet());
        bounds.boundExactly(STATIC, staticTuples.isEmpty() ? tupleFactory.noneOf(2) : tupleFactory.setOf(staticTuples));

        Set<Tuple> accessSpecifierTuples = typeSystem.getAccessSpecifier().getEdges().stream()
                .map(e -> tupleFactory.tuple(e.getSource(), e.getTarget()))
                .collect(Collectors.toSet());
        bounds.boundExactly(ACCESS_SPECIFIER, accessSpecifierTuples.isEmpty() ? tupleFactory.noneOf(2) : tupleFactory.setOf(accessSpecifierTuples));

        Set<Tuple> constructorsTuples = typeSystem.getConstructors().getEdges().stream()
                .map(e -> tupleFactory.tuple(e.getSource(), e.getTarget()))
                .collect(Collectors.toSet());
        bounds.boundExactly(CONSTRUCTORS, constructorsTuples.isEmpty() ? tupleFactory.noneOf(2) : tupleFactory.setOf(constructorsTuples));

        Set<Tuple> methodsTuples = typeSystem.getMethods().getEdges().stream()
                .map(e -> tupleFactory.tuple(e.getSource(), e.getTarget()))
                .collect(Collectors.toSet());
        bounds.boundExactly(METHODS, methodsTuples.isEmpty() ? tupleFactory.noneOf(2) : tupleFactory.setOf(methodsTuples));

        Set<Tuple> fieldsTuples = typeSystem.getFields().getEdges().stream()
                .map(e -> tupleFactory.tuple(e.getSource(), e.getTarget()))
                .collect(Collectors.toSet());
        bounds.boundExactly(FIELDS, fieldsTuples.isEmpty() ? tupleFactory.noneOf(2) : tupleFactory.setOf(fieldsTuples));

        Set<Tuple> returnsTuples = typeSystem.getReturns().getEdges().stream()
                .map(e -> tupleFactory.tuple(e.getSource(), e.getTarget()))
                .collect(Collectors.toSet());
        bounds.boundExactly(RETURNS, returnsTuples.isEmpty() ? tupleFactory.noneOf(2) : tupleFactory.setOf(returnsTuples));

        solver = new Solver();
        solver.options().setSolver(SATFactory.MiniSat);
        solver.options().setSymmetryBreaking(0);
    }

    public Relation addRelation(String name) {
        if (relationMap.containsKey(name)) {
            return null;
        }

        Relation relation = Relation.unary(name);

        relationMap.put(name, relation);
        variables.add(relation);

        bounds.bound(relation, possibleBound);
        formulas.add(relation.one());
        return relation;
    }

    public Relation getRelation(String name) {
        return relationMap.get(name);
    }

    public void addFormula(Formula formula) {
        formulas.add(formula);
    }

    public Set<Formula> getFormulas() {
        return formulas;
    }

    public void solve() {
        solutionIterator = solver.solveAll(Formula.and(formulas), bounds);
        currentSolution = solutionIterator.next();
    }

    @Override
    public boolean hasNext() {
        if (solutionIterator == null)
            return false;
        return currentSolution.sat();
    }

    public Set<String> getVariableNames() {
        return variables.stream().map(Relation::name).collect(Collectors.toSet());
    }

    @Override
    public Map<String, Entity> next() {
        if (!hasNext())
            return null;

        Solution solution = currentSolution;
        currentSolution = solutionIterator.next();

        return solution.instance().relationTuples().entrySet().stream()
                .filter(e -> variables.contains(e.getKey()))
                .collect(Collectors.toMap(e -> e.getKey().name(), e -> e.getValue().stream()
                        .filter(f -> f.atom(0) instanceof Entity)
                        .map(f -> (Entity) f.atom(0)).findFirst().orElse(null)));
    }
}
