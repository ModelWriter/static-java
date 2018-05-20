// Generated from C:/Users/Harun/Documents/GitHub/static-java/JavaAnalyzer/src/main/java/com/javaanalyzer/recognizer\JavaAnalyzer.g4 by ANTLR 4.7
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
	 * Visit a parse tree produced by {@link JavaAnalyzerParser#input}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInput(JavaAnalyzerParser.InputContext ctx);
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
	 * Visit a parse tree produced by {@link JavaAnalyzerParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(JavaAnalyzerParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NO}
	 * labeled alternative in {@link JavaAnalyzerParser#formula}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNO(JavaAnalyzerParser.NOContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SOME}
	 * labeled alternative in {@link JavaAnalyzerParser#formula}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSOME(JavaAnalyzerParser.SOMEContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NOT}
	 * labeled alternative in {@link JavaAnalyzerParser#formula}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNOT(JavaAnalyzerParser.NOTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code OR}
	 * labeled alternative in {@link JavaAnalyzerParser#formula}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOR(JavaAnalyzerParser.ORContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PHARANTHESSEDFORMULA}
	 * labeled alternative in {@link JavaAnalyzerParser#formula}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPHARANTHESSEDFORMULA(JavaAnalyzerParser.PHARANTHESSEDFORMULAContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IN}
	 * labeled alternative in {@link JavaAnalyzerParser#formula}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIN(JavaAnalyzerParser.INContext ctx);
	/**
	 * Visit a parse tree produced by the {@code EQUAL}
	 * labeled alternative in {@link JavaAnalyzerParser#formula}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEQUAL(JavaAnalyzerParser.EQUALContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ONE}
	 * labeled alternative in {@link JavaAnalyzerParser#formula}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitONE(JavaAnalyzerParser.ONEContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AND}
	 * labeled alternative in {@link JavaAnalyzerParser#formula}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAND(JavaAnalyzerParser.ANDContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LONE}
	 * labeled alternative in {@link JavaAnalyzerParser#formula}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLONE(JavaAnalyzerParser.LONEContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PHARANTHESSEDEXPRESSION}
	 * labeled alternative in {@link JavaAnalyzerParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPHARANTHESSEDEXPRESSION(JavaAnalyzerParser.PHARANTHESSEDEXPRESSIONContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TRANSPOSE}
	 * labeled alternative in {@link JavaAnalyzerParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTRANSPOSE(JavaAnalyzerParser.TRANSPOSEContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DIFFERENCE}
	 * labeled alternative in {@link JavaAnalyzerParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDIFFERENCE(JavaAnalyzerParser.DIFFERENCEContext ctx);
	/**
	 * Visit a parse tree produced by the {@code INTERSECTION}
	 * labeled alternative in {@link JavaAnalyzerParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitINTERSECTION(JavaAnalyzerParser.INTERSECTIONContext ctx);
	/**
	 * Visit a parse tree produced by the {@code VARIABLE}
	 * labeled alternative in {@link JavaAnalyzerParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVARIABLE(JavaAnalyzerParser.VARIABLEContext ctx);
	/**
	 * Visit a parse tree produced by the {@code REFLEXIVECLOSURE}
	 * labeled alternative in {@link JavaAnalyzerParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitREFLEXIVECLOSURE(JavaAnalyzerParser.REFLEXIVECLOSUREContext ctx);
	/**
	 * Visit a parse tree produced by the {@code JOIN}
	 * labeled alternative in {@link JavaAnalyzerParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJOIN(JavaAnalyzerParser.JOINContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CLOSURE}
	 * labeled alternative in {@link JavaAnalyzerParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCLOSURE(JavaAnalyzerParser.CLOSUREContext ctx);
	/**
	 * Visit a parse tree produced by the {@code UNION}
	 * labeled alternative in {@link JavaAnalyzerParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUNION(JavaAnalyzerParser.UNIONContext ctx);
}