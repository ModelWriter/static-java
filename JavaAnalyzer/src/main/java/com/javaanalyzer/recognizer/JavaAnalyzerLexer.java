// Generated from C:/Users/Harun/Documents/GitHub/static-java/JavaAnalyzer/src/main/java/com/javaanalyzer/recognizer\JavaAnalyzer.g4 by ANTLR 4.7
package com.javaanalyzer.recognizer;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class JavaAnalyzerLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		WHITESPACE=18, NEWLINE=19, VAR=20;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "T__16", 
		"ALPHA", "ALPHANUMERIC", "WHITESPACE", "NEWLINE", "VAR"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'Class'", "'Interface'", "'Method'", "'Field'", "'Object'", "'('", 
		"')'", "'='", "'in'", "'!'", "'|'", "'&'", "'.'", "'*'", "'^'", "'+'", 
		"'~'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, "WHITESPACE", "NEWLINE", "VAR"
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


	public JavaAnalyzerLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "JavaAnalyzer.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\26\u0089\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3"+
		"\b\3\b\3\t\3\t\3\n\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3"+
		"\17\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\25\6\25r\n\25"+
		"\r\25\16\25s\3\25\3\25\3\26\5\26y\n\26\3\26\3\26\6\26}\n\26\r\26\16\26"+
		"~\3\27\3\27\3\27\6\27\u0084\n\27\r\27\16\27\u0085\5\27\u0088\n\27\2\2"+
		"\30\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35"+
		"\20\37\21!\22#\23%\2\'\2)\24+\25-\26\3\2\5\4\2C\\c|\5\2\62;C\\c|\4\2\13"+
		"\13\"\"\2\u008d\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3"+
		"\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2"+
		"\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3"+
		"\2\2\2\2#\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\3/\3\2\2\2\5\65\3\2"+
		"\2\2\7?\3\2\2\2\tF\3\2\2\2\13L\3\2\2\2\rS\3\2\2\2\17U\3\2\2\2\21W\3\2"+
		"\2\2\23Y\3\2\2\2\25\\\3\2\2\2\27^\3\2\2\2\31`\3\2\2\2\33b\3\2\2\2\35d"+
		"\3\2\2\2\37f\3\2\2\2!h\3\2\2\2#j\3\2\2\2%l\3\2\2\2\'n\3\2\2\2)q\3\2\2"+
		"\2+|\3\2\2\2-\u0080\3\2\2\2/\60\7E\2\2\60\61\7n\2\2\61\62\7c\2\2\62\63"+
		"\7u\2\2\63\64\7u\2\2\64\4\3\2\2\2\65\66\7K\2\2\66\67\7p\2\2\678\7v\2\2"+
		"89\7g\2\29:\7t\2\2:;\7h\2\2;<\7c\2\2<=\7e\2\2=>\7g\2\2>\6\3\2\2\2?@\7"+
		"O\2\2@A\7g\2\2AB\7v\2\2BC\7j\2\2CD\7q\2\2DE\7f\2\2E\b\3\2\2\2FG\7H\2\2"+
		"GH\7k\2\2HI\7g\2\2IJ\7n\2\2JK\7f\2\2K\n\3\2\2\2LM\7Q\2\2MN\7d\2\2NO\7"+
		"l\2\2OP\7g\2\2PQ\7e\2\2QR\7v\2\2R\f\3\2\2\2ST\7*\2\2T\16\3\2\2\2UV\7+"+
		"\2\2V\20\3\2\2\2WX\7?\2\2X\22\3\2\2\2YZ\7k\2\2Z[\7p\2\2[\24\3\2\2\2\\"+
		"]\7#\2\2]\26\3\2\2\2^_\7~\2\2_\30\3\2\2\2`a\7(\2\2a\32\3\2\2\2bc\7\60"+
		"\2\2c\34\3\2\2\2de\7,\2\2e\36\3\2\2\2fg\7`\2\2g \3\2\2\2hi\7-\2\2i\"\3"+
		"\2\2\2jk\7\u0080\2\2k$\3\2\2\2lm\t\2\2\2m&\3\2\2\2no\t\3\2\2o(\3\2\2\2"+
		"pr\t\4\2\2qp\3\2\2\2rs\3\2\2\2sq\3\2\2\2st\3\2\2\2tu\3\2\2\2uv\b\25\2"+
		"\2v*\3\2\2\2wy\7\17\2\2xw\3\2\2\2xy\3\2\2\2yz\3\2\2\2z}\7\f\2\2{}\7\17"+
		"\2\2|x\3\2\2\2|{\3\2\2\2}~\3\2\2\2~|\3\2\2\2~\177\3\2\2\2\177,\3\2\2\2"+
		"\u0080\u0087\5%\23\2\u0081\u0084\5\'\24\2\u0082\u0084\7a\2\2\u0083\u0081"+
		"\3\2\2\2\u0083\u0082\3\2\2\2\u0084\u0085\3\2\2\2\u0085\u0083\3\2\2\2\u0085"+
		"\u0086\3\2\2\2\u0086\u0088\3\2\2\2\u0087\u0083\3\2\2\2\u0087\u0088\3\2"+
		"\2\2\u0088.\3\2\2\2\n\2sx|~\u0083\u0085\u0087\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}