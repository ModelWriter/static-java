package com.javaanalyzer.recognizer;

import com.javaanalyzer.solver.KodkodTranslator;
import com.javaanalyzer.typesystem.TypeSystem;
import kodkod.ast.Expression;
import kodkod.ast.Formula;
import kodkod.ast.Node;
import kodkod.ast.Relation;

public class JavaAnalyzerVisitorImpl extends JavaAnalyzerBaseVisitor<Node> {

    private KodkodTranslator kodkodTranslator;

    public JavaAnalyzerVisitorImpl(TypeSystem typeSystem) {
        kodkodTranslator = new KodkodTranslator(typeSystem);
    }

    public KodkodTranslator getKodkodTranslator() {
        return kodkodTranslator;
    }

    @Override
    public Node visitInput(JavaAnalyzerParser.InputContext ctx) {
        return super.visitInput(ctx);
    }

    @Override
    public Node visitLine(JavaAnalyzerParser.LineContext ctx) {
        if (ctx.formula() != null) {
            Formula formula = (Formula) visit(ctx.formula());
            kodkodTranslator.addFormula(formula);
            return formula;
        }
        else {
            return super.visitLine(ctx);
        }
    }

    @Override
    public Node visitDeclaration(JavaAnalyzerParser.DeclarationContext ctx) {
        Relation relation = kodkodTranslator.addRelation(ctx.VAR().getText());

        if (relation == null)
            return null;

        switch (ctx.type().getText()) {
            case "Class":
                kodkodTranslator.addFormula(relation.in(kodkodTranslator.CLASS));
                break;
            case "Interface":
                kodkodTranslator.addFormula(relation.in(kodkodTranslator.INTERFACE));
                break;
            case "Method":
                kodkodTranslator.addFormula(relation.in(kodkodTranslator.METHOD));
                break;
            case "Field":
                kodkodTranslator.addFormula(relation.in(kodkodTranslator.FIELD));
                break;
        }

        return relation;
    }

    @Override
    public Node visitVARIABLE(JavaAnalyzerParser.VARIABLEContext ctx) {
        Relation rel = kodkodTranslator.getRelation(ctx.VAR().getText());
        if (rel == null) {
            rel = kodkodTranslator.addRelation(ctx.VAR().getText());
        }
        return rel;
    }

    @Override
    public Node visitPHARANTHESSEDFORMULA(JavaAnalyzerParser.PHARANTHESSEDFORMULAContext ctx) {
        return visit(ctx.formula());
    }

    @Override
    public Node visitIN(JavaAnalyzerParser.INContext ctx) {
        Expression expression1 = (Expression) visit(ctx.expression(0));
        Expression expression2 = (Expression) visit(ctx.expression(1));
        return expression1.in(expression2);
    }

    @Override
    public Node visitEQUAL(JavaAnalyzerParser.EQUALContext ctx) {
        Expression expression1 = (Expression) visit(ctx.expression(0));
        Expression expression2 = (Expression) visit(ctx.expression(1));
        return expression1.eq(expression2);
    }

    @Override
    public Node visitUNION(JavaAnalyzerParser.UNIONContext ctx) {
        Expression expression1 = (Expression) visit(ctx.expression(0));
        Expression expression2 = (Expression) visit(ctx.expression(1));
        return expression1.union(expression2);
    }

    @Override
    public Node visitCLOSURE(JavaAnalyzerParser.CLOSUREContext ctx) {
        return ((Expression) visit(ctx.expression())).closure();
    }

    @Override
    public Node visitREFLEXIVECLOSURE(JavaAnalyzerParser.REFLEXIVECLOSUREContext ctx) {
        return ((Expression) visit(ctx.expression())).reflexiveClosure();
    }

    @Override
    public Node visitTRANSPOSE(JavaAnalyzerParser.TRANSPOSEContext ctx) {
        return ((Expression) visit(ctx.expression())).transpose();
    }

    @Override
    public Node visitJOIN(JavaAnalyzerParser.JOINContext ctx) {
        Expression expression1 = (Expression) visit(ctx.expression(0));
        Expression expression2 = (Expression) visit(ctx.expression(1));
        return expression1.join(expression2);
    }

    @Override
    public Node visitNOT(JavaAnalyzerParser.NOTContext ctx) {
        return ((Formula) visit(ctx.formula())).not();
    }

    @Override
    public Node visitAND(JavaAnalyzerParser.ANDContext ctx) {
        Formula formula1 = (Formula) visit(ctx.formula(0));
        Formula formula2 = (Formula) visit(ctx.formula(1));
        return formula1.and(formula2);
    }

    @Override
    public Node visitOR(JavaAnalyzerParser.ORContext ctx) {
        Formula formula1 = (Formula) visit(ctx.formula(0));
        Formula formula2 = (Formula) visit(ctx.formula(1));
        return formula1.or(formula2);
    }

    @Override
    public Node visitPHARANTHESSEDEXPRESSION(JavaAnalyzerParser.PHARANTHESSEDEXPRESSIONContext ctx) {
        return visit(ctx.expression());
    }

}
