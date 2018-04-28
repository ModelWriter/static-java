// Generated from C:/Users/Harun/Documents/GitHub/static-java/JavaAnalyzer/src/main/java/com/javaanalyzer/recognizer\JavaAnalyzer.g4 by ANTLR 4.7
package com.javaanalyzer.recognizer;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class JavaAnalyzerParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, WHITESPACE=17, 
		NEWLINE=18, VAR=19;
	public static final int
		RULE_input = 0, RULE_line = 1, RULE_declaration = 2, RULE_type = 3, RULE_formula = 4, 
		RULE_expression = 5;
	public static final String[] ruleNames = {
		"input", "line", "declaration", "type", "formula", "expression"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'Class'", "'Interface'", "'Method'", "'Field'", "'Object'", "'('", 
		"')'", "'='", "'in'", "'!'", "'|'", "'&'", "'.'", "'*'", "'^'", "'+'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, "WHITESPACE", "NEWLINE", "VAR"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "JavaAnalyzer.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public JavaAnalyzerParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class InputContext extends ParserRuleContext {
		public List<LineContext> line() {
			return getRuleContexts(LineContext.class);
		}
		public LineContext line(int i) {
			return getRuleContext(LineContext.class,i);
		}
		public InputContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_input; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaAnalyzerListener ) ((JavaAnalyzerListener)listener).enterInput(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaAnalyzerListener ) ((JavaAnalyzerListener)listener).exitInput(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaAnalyzerVisitor ) return ((JavaAnalyzerVisitor<? extends T>)visitor).visitInput(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InputContext input() throws RecognitionException {
		InputContext _localctx = new InputContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_input);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(13); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(12);
				line();
				}
				}
				setState(15); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << T__9) | (1L << T__13) | (1L << T__14) | (1L << VAR))) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LineContext extends ParserRuleContext {
		public DeclarationContext declaration() {
			return getRuleContext(DeclarationContext.class,0);
		}
		public FormulaContext formula() {
			return getRuleContext(FormulaContext.class,0);
		}
		public TerminalNode NEWLINE() { return getToken(JavaAnalyzerParser.NEWLINE, 0); }
		public LineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_line; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaAnalyzerListener ) ((JavaAnalyzerListener)listener).enterLine(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaAnalyzerListener ) ((JavaAnalyzerListener)listener).exitLine(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaAnalyzerVisitor ) return ((JavaAnalyzerVisitor<? extends T>)visitor).visitLine(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LineContext line() throws RecognitionException {
		LineContext _localctx = new LineContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_line);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(19);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				{
				setState(17);
				declaration();
				}
				break;
			case 2:
				{
				setState(18);
				formula(0);
				}
				break;
			}
			setState(22);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NEWLINE) {
				{
				setState(21);
				match(NEWLINE);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclarationContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode VAR() { return getToken(JavaAnalyzerParser.VAR, 0); }
		public DeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaAnalyzerListener ) ((JavaAnalyzerListener)listener).enterDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaAnalyzerListener ) ((JavaAnalyzerListener)listener).exitDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaAnalyzerVisitor ) return ((JavaAnalyzerVisitor<? extends T>)visitor).visitDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclarationContext declaration() throws RecognitionException {
		DeclarationContext _localctx = new DeclarationContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_declaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(24);
			type();
			setState(25);
			match(VAR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeContext extends ParserRuleContext {
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaAnalyzerListener ) ((JavaAnalyzerListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaAnalyzerListener ) ((JavaAnalyzerListener)listener).exitType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaAnalyzerVisitor ) return ((JavaAnalyzerVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_type);
		int _la;
		try {
			setState(34);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
				enterOuterAlt(_localctx, 1);
				{
				setState(27);
				match(T__0);
				}
				break;
			case T__1:
				enterOuterAlt(_localctx, 2);
				{
				setState(28);
				match(T__1);
				}
				break;
			case T__2:
				enterOuterAlt(_localctx, 3);
				{
				setState(29);
				match(T__2);
				}
				break;
			case T__3:
				enterOuterAlt(_localctx, 4);
				{
				setState(30);
				match(T__3);
				}
				break;
			case T__4:
			case VAR:
				enterOuterAlt(_localctx, 5);
				{
				setState(32);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__4) {
					{
					setState(31);
					match(T__4);
					}
				}

				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FormulaContext extends ParserRuleContext {
		public FormulaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formula; }
	 
		public FormulaContext() { }
		public void copyFrom(FormulaContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class NOTContext extends FormulaContext {
		public FormulaContext formula() {
			return getRuleContext(FormulaContext.class,0);
		}
		public NOTContext(FormulaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaAnalyzerListener ) ((JavaAnalyzerListener)listener).enterNOT(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaAnalyzerListener ) ((JavaAnalyzerListener)listener).exitNOT(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaAnalyzerVisitor ) return ((JavaAnalyzerVisitor<? extends T>)visitor).visitNOT(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ORContext extends FormulaContext {
		public List<FormulaContext> formula() {
			return getRuleContexts(FormulaContext.class);
		}
		public FormulaContext formula(int i) {
			return getRuleContext(FormulaContext.class,i);
		}
		public ORContext(FormulaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaAnalyzerListener ) ((JavaAnalyzerListener)listener).enterOR(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaAnalyzerListener ) ((JavaAnalyzerListener)listener).exitOR(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaAnalyzerVisitor ) return ((JavaAnalyzerVisitor<? extends T>)visitor).visitOR(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PHARANTHESSEDFORMULAContext extends FormulaContext {
		public FormulaContext formula() {
			return getRuleContext(FormulaContext.class,0);
		}
		public PHARANTHESSEDFORMULAContext(FormulaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaAnalyzerListener ) ((JavaAnalyzerListener)listener).enterPHARANTHESSEDFORMULA(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaAnalyzerListener ) ((JavaAnalyzerListener)listener).exitPHARANTHESSEDFORMULA(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaAnalyzerVisitor ) return ((JavaAnalyzerVisitor<? extends T>)visitor).visitPHARANTHESSEDFORMULA(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class INContext extends FormulaContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public INContext(FormulaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaAnalyzerListener ) ((JavaAnalyzerListener)listener).enterIN(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaAnalyzerListener ) ((JavaAnalyzerListener)listener).exitIN(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaAnalyzerVisitor ) return ((JavaAnalyzerVisitor<? extends T>)visitor).visitIN(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class EQUALContext extends FormulaContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public EQUALContext(FormulaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaAnalyzerListener ) ((JavaAnalyzerListener)listener).enterEQUAL(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaAnalyzerListener ) ((JavaAnalyzerListener)listener).exitEQUAL(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaAnalyzerVisitor ) return ((JavaAnalyzerVisitor<? extends T>)visitor).visitEQUAL(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ANDContext extends FormulaContext {
		public List<FormulaContext> formula() {
			return getRuleContexts(FormulaContext.class);
		}
		public FormulaContext formula(int i) {
			return getRuleContext(FormulaContext.class,i);
		}
		public ANDContext(FormulaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaAnalyzerListener ) ((JavaAnalyzerListener)listener).enterAND(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaAnalyzerListener ) ((JavaAnalyzerListener)listener).exitAND(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaAnalyzerVisitor ) return ((JavaAnalyzerVisitor<? extends T>)visitor).visitAND(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FormulaContext formula() throws RecognitionException {
		return formula(0);
	}

	private FormulaContext formula(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		FormulaContext _localctx = new FormulaContext(_ctx, _parentState);
		FormulaContext _prevctx = _localctx;
		int _startState = 8;
		enterRecursionRule(_localctx, 8, RULE_formula, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(51);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				{
				_localctx = new PHARANTHESSEDFORMULAContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(37);
				match(T__5);
				setState(38);
				formula(0);
				setState(39);
				match(T__6);
				}
				break;
			case 2:
				{
				_localctx = new EQUALContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(41);
				expression(0);
				setState(42);
				match(T__7);
				setState(43);
				expression(0);
				}
				break;
			case 3:
				{
				_localctx = new INContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(45);
				expression(0);
				setState(46);
				match(T__8);
				setState(47);
				expression(0);
				}
				break;
			case 4:
				{
				_localctx = new NOTContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(49);
				match(T__9);
				setState(50);
				formula(3);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(61);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(59);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
					case 1:
						{
						_localctx = new ORContext(new FormulaContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(53);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(54);
						match(T__10);
						setState(55);
						formula(3);
						}
						break;
					case 2:
						{
						_localctx = new ANDContext(new FormulaContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(56);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(57);
						match(T__11);
						setState(58);
						formula(2);
						}
						break;
					}
					} 
				}
				setState(63);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class ExpressionContext extends ParserRuleContext {
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	 
		public ExpressionContext() { }
		public void copyFrom(ExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class PHARANTHESSEDEXPRESSIONContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public PHARANTHESSEDEXPRESSIONContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaAnalyzerListener ) ((JavaAnalyzerListener)listener).enterPHARANTHESSEDEXPRESSION(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaAnalyzerListener ) ((JavaAnalyzerListener)listener).exitPHARANTHESSEDEXPRESSION(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaAnalyzerVisitor ) return ((JavaAnalyzerVisitor<? extends T>)visitor).visitPHARANTHESSEDEXPRESSION(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class VARIABLEContext extends ExpressionContext {
		public TerminalNode VAR() { return getToken(JavaAnalyzerParser.VAR, 0); }
		public VARIABLEContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaAnalyzerListener ) ((JavaAnalyzerListener)listener).enterVARIABLE(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaAnalyzerListener ) ((JavaAnalyzerListener)listener).exitVARIABLE(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaAnalyzerVisitor ) return ((JavaAnalyzerVisitor<? extends T>)visitor).visitVARIABLE(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class REFLEXIVECLOSUREContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public REFLEXIVECLOSUREContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaAnalyzerListener ) ((JavaAnalyzerListener)listener).enterREFLEXIVECLOSURE(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaAnalyzerListener ) ((JavaAnalyzerListener)listener).exitREFLEXIVECLOSURE(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaAnalyzerVisitor ) return ((JavaAnalyzerVisitor<? extends T>)visitor).visitREFLEXIVECLOSURE(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class JOINContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public JOINContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaAnalyzerListener ) ((JavaAnalyzerListener)listener).enterJOIN(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaAnalyzerListener ) ((JavaAnalyzerListener)listener).exitJOIN(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaAnalyzerVisitor ) return ((JavaAnalyzerVisitor<? extends T>)visitor).visitJOIN(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CLOSUREContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public CLOSUREContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaAnalyzerListener ) ((JavaAnalyzerListener)listener).enterCLOSURE(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaAnalyzerListener ) ((JavaAnalyzerListener)listener).exitCLOSURE(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaAnalyzerVisitor ) return ((JavaAnalyzerVisitor<? extends T>)visitor).visitCLOSURE(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class UNIONContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public UNIONContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaAnalyzerListener ) ((JavaAnalyzerListener)listener).enterUNION(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaAnalyzerListener ) ((JavaAnalyzerListener)listener).exitUNION(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaAnalyzerVisitor ) return ((JavaAnalyzerVisitor<? extends T>)visitor).visitUNION(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 10;
		enterRecursionRule(_localctx, 10, RULE_expression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(74);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case VAR:
				{
				_localctx = new VARIABLEContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(65);
				match(VAR);
				}
				break;
			case T__5:
				{
				_localctx = new PHARANTHESSEDEXPRESSIONContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(66);
				match(T__5);
				setState(67);
				expression(0);
				setState(68);
				match(T__6);
				}
				break;
			case T__13:
				{
				_localctx = new REFLEXIVECLOSUREContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(70);
				match(T__13);
				setState(71);
				expression(3);
				}
				break;
			case T__14:
				{
				_localctx = new CLOSUREContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(72);
				match(T__14);
				setState(73);
				expression(2);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(84);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(82);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
					case 1:
						{
						_localctx = new JOINContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(76);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(77);
						match(T__12);
						setState(78);
						expression(5);
						}
						break;
					case 2:
						{
						_localctx = new UNIONContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(79);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(80);
						match(T__15);
						setState(81);
						expression(2);
						}
						break;
					}
					} 
				}
				setState(86);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 4:
			return formula_sempred((FormulaContext)_localctx, predIndex);
		case 5:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean formula_sempred(FormulaContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 2);
		case 1:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2:
			return precpred(_ctx, 4);
		case 3:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\25Z\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\3\2\6\2\20\n\2\r\2\16\2\21\3\3\3\3"+
		"\5\3\26\n\3\3\3\5\3\31\n\3\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\5\5#\n\5\5"+
		"\5%\n\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5"+
		"\6\66\n\6\3\6\3\6\3\6\3\6\3\6\3\6\7\6>\n\6\f\6\16\6A\13\6\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7M\n\7\3\7\3\7\3\7\3\7\3\7\3\7\7\7U\n\7"+
		"\f\7\16\7X\13\7\3\7\2\4\n\f\b\2\4\6\b\n\f\2\2\2e\2\17\3\2\2\2\4\25\3\2"+
		"\2\2\6\32\3\2\2\2\b$\3\2\2\2\n\65\3\2\2\2\fL\3\2\2\2\16\20\5\4\3\2\17"+
		"\16\3\2\2\2\20\21\3\2\2\2\21\17\3\2\2\2\21\22\3\2\2\2\22\3\3\2\2\2\23"+
		"\26\5\6\4\2\24\26\5\n\6\2\25\23\3\2\2\2\25\24\3\2\2\2\26\30\3\2\2\2\27"+
		"\31\7\24\2\2\30\27\3\2\2\2\30\31\3\2\2\2\31\5\3\2\2\2\32\33\5\b\5\2\33"+
		"\34\7\25\2\2\34\7\3\2\2\2\35%\7\3\2\2\36%\7\4\2\2\37%\7\5\2\2 %\7\6\2"+
		"\2!#\7\7\2\2\"!\3\2\2\2\"#\3\2\2\2#%\3\2\2\2$\35\3\2\2\2$\36\3\2\2\2$"+
		"\37\3\2\2\2$ \3\2\2\2$\"\3\2\2\2%\t\3\2\2\2&\'\b\6\1\2\'(\7\b\2\2()\5"+
		"\n\6\2)*\7\t\2\2*\66\3\2\2\2+,\5\f\7\2,-\7\n\2\2-.\5\f\7\2.\66\3\2\2\2"+
		"/\60\5\f\7\2\60\61\7\13\2\2\61\62\5\f\7\2\62\66\3\2\2\2\63\64\7\f\2\2"+
		"\64\66\5\n\6\5\65&\3\2\2\2\65+\3\2\2\2\65/\3\2\2\2\65\63\3\2\2\2\66?\3"+
		"\2\2\2\678\f\4\2\289\7\r\2\29>\5\n\6\5:;\f\3\2\2;<\7\16\2\2<>\5\n\6\4"+
		"=\67\3\2\2\2=:\3\2\2\2>A\3\2\2\2?=\3\2\2\2?@\3\2\2\2@\13\3\2\2\2A?\3\2"+
		"\2\2BC\b\7\1\2CM\7\25\2\2DE\7\b\2\2EF\5\f\7\2FG\7\t\2\2GM\3\2\2\2HI\7"+
		"\20\2\2IM\5\f\7\5JK\7\21\2\2KM\5\f\7\4LB\3\2\2\2LD\3\2\2\2LH\3\2\2\2L"+
		"J\3\2\2\2MV\3\2\2\2NO\f\6\2\2OP\7\17\2\2PU\5\f\7\7QR\f\3\2\2RS\7\22\2"+
		"\2SU\5\f\7\4TN\3\2\2\2TQ\3\2\2\2UX\3\2\2\2VT\3\2\2\2VW\3\2\2\2W\r\3\2"+
		"\2\2XV\3\2\2\2\r\21\25\30\"$\65=?LTV";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}