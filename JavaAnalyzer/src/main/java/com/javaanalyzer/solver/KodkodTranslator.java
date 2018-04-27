package com.javaanalyzer.solver;

import com.javaanalyzer.typesystem.*;
import kodkod.ast.Formula;
import kodkod.ast.Relation;
import kodkod.engine.Solution;
import kodkod.engine.Solver;
import kodkod.engine.satlab.SATFactory;
import kodkod.instance.Bounds;
import kodkod.instance.Tuple;
import kodkod.instance.TupleFactory;
import kodkod.instance.Universe;

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

    private Iterator<Solution> solutionIterator;
    private Solution currentSolution;

    public KodkodTranslator(TypeSystem typeSystem) {
        formulas = new HashSet<>();
        relationMap = new HashMap<>();
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

        tupleFactory = universe.factory();
        bounds = new Bounds(universe);

        Set<Type> classTuples = typeSystem.getEntities().stream()
                .filter(e -> e instanceof ClassType)
                .map(e -> (Type) e)
                .collect(Collectors.toSet());
        bounds.boundExactly(CLASS, classTuples.isEmpty() ? tupleFactory.noneOf(1) : tupleFactory.setOf(classTuples.toArray()));

        Set<Type> interfaceTuples = typeSystem.getEntities().stream()
                .filter(e -> e instanceof InterfaceType)
                .map(e -> (Type) e)
                .collect(Collectors.toSet());
        bounds.boundExactly(INTERFACE, interfaceTuples.isEmpty() ? tupleFactory.noneOf(1) : tupleFactory.setOf(interfaceTuples.toArray()));

        Set<Method> methodTuples = typeSystem.getEntities().stream()
                .filter(e -> e instanceof Method)
                .map(e -> (Method) e)
                .collect(Collectors.toSet());
        bounds.boundExactly(METHOD, methodTuples.isEmpty() ? tupleFactory.noneOf(1) : tupleFactory.setOf(methodTuples.toArray()));

        Set<Constructor> constructorTuples = typeSystem.getEntities().stream()
                .filter(e -> e instanceof Constructor)
                .map(e -> (Constructor) e)
                .collect(Collectors.toSet());
        bounds.boundExactly(CONSTRUCTOR, constructorTuples.isEmpty() ? tupleFactory.noneOf(1) : tupleFactory.setOf(constructorTuples.toArray()));

        Set<Field> fieldTuples = typeSystem.getEntities().stream()
                .filter(e -> e instanceof Field)
                .map(e -> (Field) e)
                .collect(Collectors.toSet());
        bounds.boundExactly(FIELD, fieldTuples.isEmpty() ? tupleFactory.noneOf(1) : tupleFactory.setOf(fieldTuples.toArray()));


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

    public Relation add(String name) {
        Relation relation = createUnaryRelation(name);
        if (relation != null) {
            relationMap.put(name, relation);
        }
        return relation;
    }

    private Relation createUnaryRelation(String name) {
        if (relationMap.containsKey(name)) {
            return null;
        }

        Relation relation = Relation.unary(name);
        bounds.bound(relation, tupleFactory.allOf(1));
        formulas.add(relation.one());
        return relation;
    }

    public void addFormula(Formula formula) {
        formulas.add(formula);
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

    @Override
    public Map<String, Entity> next() {
        if (!hasNext())
            return null;

        Solution solution = currentSolution;
        currentSolution = solutionIterator.next();

        return solution.instance().relationTuples().entrySet().stream()
                .filter(e -> relationMap.containsValue(e.getKey()))
                .filter(e -> !e.getValue().isEmpty())
                .collect(Collectors.toMap(e -> e.getKey().name(), e -> e.getValue().stream()
                        .filter(f -> f.atom(0) instanceof Entity)
                        .map(f -> (Entity) f.atom(0)).findFirst().orElse(null)));
    }
}
