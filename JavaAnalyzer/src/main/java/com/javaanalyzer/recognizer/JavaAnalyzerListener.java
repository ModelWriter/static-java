// Generated from C:/Users/Harun/Documents/GitHub/static-java/JavaAnalyzer/src/main/java/com/javaanalyzer/recognizer\JavaAnalyzer.g4 by ANTLR 4.7
package com.javaanalyzer.recognizer;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link JavaAnalyzerParser}.
 */
public interface JavaAnalyzerListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link JavaAnalyzerParser#input}.
	 * @param ctx the parse tree
	 */
	void enterInput(JavaAnalyzerParser.InputContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaAnalyzerParser#input}.
	 * @param ctx the parse tree
	 */
	void exitInput(JavaAnalyzerParser.InputContext ctx);
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
	 * Enter a parse tree produced by {@link JavaAnalyzerParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(JavaAnalyzerParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaAnalyzerParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(JavaAnalyzerParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NO}
	 * labeled alternative in {@link JavaAnalyzerParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterNO(JavaAnalyzerParser.NOContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NO}
	 * labeled alternative in {@link JavaAnalyzerParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitNO(JavaAnalyzerParser.NOContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SOME}
	 * labeled alternative in {@link JavaAnalyzerParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterSOME(JavaAnalyzerParser.SOMEContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SOME}
	 * labeled alternative in {@link JavaAnalyzerParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitSOME(JavaAnalyzerParser.SOMEContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NOT}
	 * labeled alternative in {@link JavaAnalyzerParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterNOT(JavaAnalyzerParser.NOTContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NOT}
	 * labeled alternative in {@link JavaAnalyzerParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitNOT(JavaAnalyzerParser.NOTContext ctx);
	/**
	 * Enter a parse tree produced by the {@code OR}
	 * labeled alternative in {@link JavaAnalyzerParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterOR(JavaAnalyzerParser.ORContext ctx);
	/**
	 * Exit a parse tree produced by the {@code OR}
	 * labeled alternative in {@link JavaAnalyzerParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitOR(JavaAnalyzerParser.ORContext ctx);
	/**
	 * Enter a parse tree produced by the {@code PHARANTHESSEDFORMULA}
	 * labeled alternative in {@link JavaAnalyzerParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterPHARANTHESSEDFORMULA(JavaAnalyzerParser.PHARANTHESSEDFORMULAContext ctx);
	/**
	 * Exit a parse tree produced by the {@code PHARANTHESSEDFORMULA}
	 * labeled alternative in {@link JavaAnalyzerParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitPHARANTHESSEDFORMULA(JavaAnalyzerParser.PHARANTHESSEDFORMULAContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IN}
	 * labeled alternative in {@link JavaAnalyzerParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterIN(JavaAnalyzerParser.INContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IN}
	 * labeled alternative in {@link JavaAnalyzerParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitIN(JavaAnalyzerParser.INContext ctx);
	/**
	 * Enter a parse tree produced by the {@code EQUAL}
	 * labeled alternative in {@link JavaAnalyzerParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterEQUAL(JavaAnalyzerParser.EQUALContext ctx);
	/**
	 * Exit a parse tree produced by the {@code EQUAL}
	 * labeled alternative in {@link JavaAnalyzerParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitEQUAL(JavaAnalyzerParser.EQUALContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ONE}
	 * labeled alternative in {@link JavaAnalyzerParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterONE(JavaAnalyzerParser.ONEContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ONE}
	 * labeled alternative in {@link JavaAnalyzerParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitONE(JavaAnalyzerParser.ONEContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AND}
	 * labeled alternative in {@link JavaAnalyzerParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterAND(JavaAnalyzerParser.ANDContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AND}
	 * labeled alternative in {@link JavaAnalyzerParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitAND(JavaAnalyzerParser.ANDContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LONE}
	 * labeled alternative in {@link JavaAnalyzerParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterLONE(JavaAnalyzerParser.LONEContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LONE}
	 * labeled alternative in {@link JavaAnalyzerParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitLONE(JavaAnalyzerParser.LONEContext ctx);
	/**
	 * Enter a parse tree produced by the {@code PHARANTHESSEDEXPRESSION}
	 * labeled alternative in {@link JavaAnalyzerParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterPHARANTHESSEDEXPRESSION(JavaAnalyzerParser.PHARANTHESSEDEXPRESSIONContext ctx);
	/**
	 * Exit a parse tree produced by the {@code PHARANTHESSEDEXPRESSION}
	 * labeled alternative in {@link JavaAnalyzerParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitPHARANTHESSEDEXPRESSION(JavaAnalyzerParser.PHARANTHESSEDEXPRESSIONContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TRANSPOSE}
	 * labeled alternative in {@link JavaAnalyzerParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterTRANSPOSE(JavaAnalyzerParser.TRANSPOSEContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TRANSPOSE}
	 * labeled alternative in {@link JavaAnalyzerParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitTRANSPOSE(JavaAnalyzerParser.TRANSPOSEContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DIFFERENCE}
	 * labeled alternative in {@link JavaAnalyzerParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterDIFFERENCE(JavaAnalyzerParser.DIFFERENCEContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DIFFERENCE}
	 * labeled alternative in {@link JavaAnalyzerParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitDIFFERENCE(JavaAnalyzerParser.DIFFERENCEContext ctx);
	/**
	 * Enter a parse tree produced by the {@code INTERSECTION}
	 * labeled alternative in {@link JavaAnalyzerParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterINTERSECTION(JavaAnalyzerParser.INTERSECTIONContext ctx);
	/**
	 * Exit a parse tree produced by the {@code INTERSECTION}
	 * labeled alternative in {@link JavaAnalyzerParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitINTERSECTION(JavaAnalyzerParser.INTERSECTIONContext ctx);
	/**
	 * Enter a parse tree produced by the {@code VARIABLE}
	 * labeled alternative in {@link JavaAnalyzerParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterVARIABLE(JavaAnalyzerParser.VARIABLEContext ctx);
	/**
	 * Exit a parse tree produced by the {@code VARIABLE}
	 * labeled alternative in {@link JavaAnalyzerParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitVARIABLE(JavaAnalyzerParser.VARIABLEContext ctx);
	/**
	 * Enter a parse tree produced by the {@code REFLEXIVECLOSURE}
	 * labeled alternative in {@link JavaAnalyzerParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterREFLEXIVECLOSURE(JavaAnalyzerParser.REFLEXIVECLOSUREContext ctx);
	/**
	 * Exit a parse tree produced by the {@code REFLEXIVECLOSURE}
	 * labeled alternative in {@link JavaAnalyzerParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitREFLEXIVECLOSURE(JavaAnalyzerParser.REFLEXIVECLOSUREContext ctx);
	/**
	 * Enter a parse tree produced by the {@code JOIN}
	 * labeled alternative in {@link JavaAnalyzerParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterJOIN(JavaAnalyzerParser.JOINContext ctx);
	/**
	 * Exit a parse tree produced by the {@code JOIN}
	 * labeled alternative in {@link JavaAnalyzerParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitJOIN(JavaAnalyzerParser.JOINContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CLOSURE}
	 * labeled alternative in {@link JavaAnalyzerParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterCLOSURE(JavaAnalyzerParser.CLOSUREContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CLOSURE}
	 * labeled alternative in {@link JavaAnalyzerParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitCLOSURE(JavaAnalyzerParser.CLOSUREContext ctx);
	/**
	 * Enter a parse tree produced by the {@code UNION}
	 * labeled alternative in {@link JavaAnalyzerParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterUNION(JavaAnalyzerParser.UNIONContext ctx);
	/**
	 * Exit a parse tree produced by the {@code UNION}
	 * labeled alternative in {@link JavaAnalyzerParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitUNION(JavaAnalyzerParser.UNIONContext ctx);
}