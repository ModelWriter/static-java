// Generated from /home/harun/git/static-java/JavaAnalyzer/src/main/java/com/javaanalyzer/recognizer/JavaAnalyzer.g4 by ANTLR 4.7
package com.javaanalyzer.recognizer;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link JavaAnalyzerParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface JavaAnalyzerVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link JavaAnalyzerParser#whole}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhole(JavaAnalyzerParser.WholeContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaAnalyzerParser#line}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLine(JavaAnalyzerParser.LineContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaAnalyzerParser#declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaration(JavaAnalyzerParser.DeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaAnalyzerParser#variable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariable(JavaAnalyzerParser.VariableContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaAnalyzerParser#formula}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormula(JavaAnalyzerParser.FormulaContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaAnalyzerParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(JavaAnalyzerParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaAnalyzerParser#join}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJoin(JavaAnalyzerParser.JoinContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaAnalyzerParser#eq}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEq(JavaAnalyzerParser.EqContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaAnalyzerParser#in}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIn(JavaAnalyzerParser.InContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaAnalyzerParser#not}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNot(JavaAnalyzerParser.NotContext ctx);
}