// Generated from /home/harun/git/static-java/JavaAnalyzer/src/main/java/com/javaanalyzer/recognizer/JavaAnalyzer.g4 by ANTLR 4.7
package com.javaanalyzer.recognizer;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link JavaAnalyzerParser}.
 */
public interface JavaAnalyzerListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link JavaAnalyzerParser#whole}.
	 * @param ctx the parse tree
	 */
	void enterWhole(JavaAnalyzerParser.WholeContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaAnalyzerParser#whole}.
	 * @param ctx the parse tree
	 */
	void exitWhole(JavaAnalyzerParser.WholeContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaAnalyzerParser#line}.
	 * @param ctx the parse tree
	 */
	void enterLine(JavaAnalyzerParser.LineContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaAnalyzerParser#line}.
	 * @param ctx the parse tree
	 */
	void exitLine(JavaAnalyzerParser.LineContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaAnalyzerParser#declaration}.
	 * @param ctx the parse tree
	 */
	void enterDeclaration(JavaAnalyzerParser.DeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaAnalyzerParser#declaration}.
	 * @param ctx the parse tree
	 */
	void exitDeclaration(JavaAnalyzerParser.DeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaAnalyzerParser#variable}.
	 * @param ctx the parse tree
	 */
	void enterVariable(JavaAnalyzerParser.VariableContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaAnalyzerParser#variable}.
	 * @param ctx the parse tree
	 */
	void exitVariable(JavaAnalyzerParser.VariableContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaAnalyzerParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterFormula(JavaAnalyzerParser.FormulaContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaAnalyzerParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitFormula(JavaAnalyzerParser.FormulaContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaAnalyzerParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(JavaAnalyzerParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaAnalyzerParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(JavaAnalyzerParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaAnalyzerParser#join}.
	 * @param ctx the parse tree
	 */
	void enterJoin(JavaAnalyzerParser.JoinContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaAnalyzerParser#join}.
	 * @param ctx the parse tree
	 */
	void exitJoin(JavaAnalyzerParser.JoinContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaAnalyzerParser#eq}.
	 * @param ctx the parse tree
	 */
	void enterEq(JavaAnalyzerParser.EqContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaAnalyzerParser#eq}.
	 * @param ctx the parse tree
	 */
	void exitEq(JavaAnalyzerParser.EqContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaAnalyzerParser#in}.
	 * @param ctx the parse tree
	 */
	void enterIn(JavaAnalyzerParser.InContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaAnalyzerParser#in}.
	 * @param ctx the parse tree
	 */
	void exitIn(JavaAnalyzerParser.InContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaAnalyzerParser#not}.
	 * @param ctx the parse tree
	 */
	void enterNot(JavaAnalyzerParser.NotContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaAnalyzerParser#not}.
	 * @param ctx the parse tree
	 */
	void exitNot(JavaAnalyzerParser.NotContext ctx);
}