package com.javaanalyzer.solver;

import com.javaanalyzer.typesystem.ClassType;
import com.javaanalyzer.typesystem.InterfaceType;
import com.javaanalyzer.typesystem.Type;
import com.javaanalyzer.typesystem.TypeSystem;
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
public class KodkodTranslator implements Iterator<Map<String, Type>> {

    private Universe universe;
    private TupleFactory tupleFactory;
    private Bounds bounds;
    private Set<Formula> formulas;

    private Solver solver;

    public final Relation CLASS;
    public final Relation INTERFACE;
    public final Relation INHERITS;
    public final Relation EXTENDS;
    public final Relation IMPLEMENTS;
    public final Relation CONTAINS;
    public final Relation CALLS;

    private Map<String, Relation> relationMap;

    private Iterator<Solution> solutionIterator;
    private Solution currentSolution;

    public KodkodTranslator(TypeSystem typeSystem) {
        formulas = new HashSet<>();
        relationMap = new HashMap<>();
        solutionIterator = null;
        currentSolution = null;

        universe = new Universe(typeSystem.getTypes());

        CLASS = Relation.unary("Class");
        INTERFACE = Relation.unary("Interface");
        INHERITS = Relation.binary("inherits");
        EXTENDS = Relation.binary("extends");
        IMPLEMENTS = Relation.binary("implements");
        CONTAINS = Relation.binary("contains");
        CALLS = Relation.binary("calls");

        tupleFactory = universe.factory();
        bounds = new Bounds(universe);

        Set<Type> classTuples = typeSystem.getTypes().stream()
                .filter(e -> e instanceof ClassType)
                .collect(Collectors.toSet());
        bounds.boundExactly(CLASS, classTuples.isEmpty() ? tupleFactory.noneOf(1) : tupleFactory.setOf(classTuples.toArray()));

        Set<Type> interfaceTuples = typeSystem.getTypes().stream()
                .filter(e -> e instanceof InterfaceType)
                .collect(Collectors.toSet());
        bounds.boundExactly(INTERFACE, interfaceTuples.isEmpty() ? tupleFactory.noneOf(1) : tupleFactory.setOf(interfaceTuples.toArray()));

        Set<Tuple> extendsTuples = typeSystem.getExtends().getEdges().stream()
                .map(e -> tupleFactory.tuple(e.getSource(), e.getTarget()))
                .collect(Collectors.toSet());
        bounds.boundExactly(EXTENDS, extendsTuples.isEmpty() ? tupleFactory.noneOf(2) : tupleFactory.setOf(extendsTuples));

        Set<Tuple> implementsTuples = typeSystem.getImplements().getEdges().stream()
                .map(e -> tupleFactory.tuple(e.getSource(), e.getTarget()))
                .collect(Collectors.toSet());
        bounds.boundExactly(IMPLEMENTS, implementsTuples.isEmpty() ? tupleFactory.noneOf(2) : tupleFactory.setOf(implementsTuples));

        Set<Tuple> inheritsTuples = new HashSet<>(extendsTuples);
        inheritsTuples.addAll(implementsTuples);
        bounds.boundExactly(INHERITS, inheritsTuples.isEmpty() ? tupleFactory.noneOf(2) : tupleFactory.setOf(inheritsTuples));

        Set<Tuple> containsTuples = typeSystem.getContains().getEdges().stream()
                .map(e -> tupleFactory.tuple(e.getSource(), e.getTarget()))
                .collect(Collectors.toSet());
        bounds.boundExactly(CONTAINS, containsTuples.isEmpty() ? tupleFactory.noneOf(2) : tupleFactory.setOf(containsTuples));

        Set<Tuple> callsTuples = typeSystem.getCalls().getEdges().stream()
                .map(e -> tupleFactory.tuple(e.getSource(), e.getTarget()))
                .collect(Collectors.toSet());
        bounds.boundExactly(CALLS, callsTuples.isEmpty() ? tupleFactory.noneOf(2) : tupleFactory.setOf(callsTuples));

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

    public void isClass(String type, boolean value) {
        Relation rel = relationMap.computeIfAbsent(type, this::createUnaryRelation);
        if (value)
            formulas.add(rel.in(CLASS));
        else
            formulas.add(rel.in(CLASS).not());
    }

    public void isInterface(String type, boolean value) {
        Relation rel = relationMap.computeIfAbsent(type, this::createUnaryRelation);
        if (value)
            formulas.add(rel.in(INTERFACE));
        else
            formulas.add(rel.in(INTERFACE).not());
    }

    public void setInherits(String subType, String superType, boolean value) {
        Relation subRel = relationMap.computeIfAbsent(subType, this::createUnaryRelation);
        Relation superRel = relationMap.computeIfAbsent(superType, this::createUnaryRelation);
        if (value)
            formulas.add(superRel.in(subRel.join(INHERITS)));
        else
            formulas.add(superRel.in(subRel.join(INHERITS)).not());
    }

    public void setExtends(String subType, String superType, boolean value) {
        Relation subRel = relationMap.computeIfAbsent(subType, this::createUnaryRelation);
        Relation superRel = relationMap.computeIfAbsent(superType, this::createUnaryRelation);
        if (value)
            formulas.add(superRel.in(subRel.join(EXTENDS)));
        else
            formulas.add(superRel.in(subRel.join(EXTENDS)).not());
    }

    public void setImplements(String subType, String superType, boolean value) {
        Relation subRel = relationMap.computeIfAbsent(subType, this::createUnaryRelation);
        Relation superRel = relationMap.computeIfAbsent(superType, this::createUnaryRelation);
        if (value)
            formulas.add(superRel.in(subRel.join(IMPLEMENTS)));
        else
            formulas.add(superRel.in(subRel.join(IMPLEMENTS)).not());
    }

    public void setContains(String container, String contained, boolean value) {
        Relation containerRel = relationMap.computeIfAbsent(container, this::createUnaryRelation);
        Relation containedRel = relationMap.computeIfAbsent(contained, this::createUnaryRelation);
        if (value)
            formulas.add(containedRel.in(containerRel.join(CONTAINS)));
        else
            formulas.add(containedRel.in(containerRel.join(CONTAINS)).not());
    }

    public void setCalls(String caller, String called, boolean value) {
        Relation callerRel = relationMap.computeIfAbsent(caller, this::createUnaryRelation);
        Relation calledRel = relationMap.computeIfAbsent(called, this::createUnaryRelation);
        if (value)
            formulas.add(calledRel.in(callerRel.join(CALLS)));
        else
            formulas.add(calledRel.in(callerRel.join(CALLS)).not());
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
    public Map<String, Type> next() {
        if (!hasNext())
            return null;

        Solution solution = currentSolution;
        currentSolution = solutionIterator.next();

        return solution.instance().relationTuples().entrySet().stream()
                .filter(e -> relationMap.containsKey(e.getKey().name()))
                .filter(e -> !e.getValue().isEmpty())
                .collect(Collectors.toMap(e -> e.getKey().name(), e -> e.getValue().stream()
                        .filter(f -> f.atom(0) instanceof Type)
                        .map(f -> (Type) f.atom(0)).findFirst().orElse(null)));
    }
}
