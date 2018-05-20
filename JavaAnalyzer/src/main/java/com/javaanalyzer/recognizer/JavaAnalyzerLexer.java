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
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, WHITESPACE=24, 
		NEWLINE=25, VAR=26;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "T__16", 
		"T__17", "T__18", "T__19", "T__20", "T__21", "T__22", "ALPHA", "ALPHANUMERIC", 
		"WHITESPACE", "NEWLINE", "VAR"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'Class'", "'Interface'", "'Method'", "'Field'", "'Object'", "'('", 
		"')'", "'='", "'in'", "'no'", "'some'", "'one'", "'lone'", "'!'", "'||'", 
		"'&&'", "'.'", "'*'", "'^'", "'+'", "'-'", "'&'", "'~'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		"WHITESPACE", "NEWLINE", "VAR"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\34\u00ac\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\b\3\b\3\t"+
		"\3\t\3\n\3\n\3\n\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3"+
		"\16\3\16\3\16\3\16\3\16\3\17\3\17\3\20\3\20\3\20\3\21\3\21\3\21\3\22\3"+
		"\22\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3\27\3\30\3\30\3\31\3"+
		"\31\3\32\3\32\3\33\6\33\u0095\n\33\r\33\16\33\u0096\3\33\3\33\3\34\5\34"+
		"\u009c\n\34\3\34\3\34\6\34\u00a0\n\34\r\34\16\34\u00a1\3\35\3\35\3\35"+
		"\6\35\u00a7\n\35\r\35\16\35\u00a8\5\35\u00ab\n\35\2\2\36\3\3\5\4\7\5\t"+
		"\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23"+
		"%\24\'\25)\26+\27-\30/\31\61\2\63\2\65\32\67\339\34\3\2\5\4\2C\\c|\5\2"+
		"\62;C\\c|\4\2\13\13\"\"\2\u00b0\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2"+
		"\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2"+
		"\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2"+
		"\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2"+
		"\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2"+
		"\3;\3\2\2\2\5A\3\2\2\2\7K\3\2\2\2\tR\3\2\2\2\13X\3\2\2\2\r_\3\2\2\2\17"+
		"a\3\2\2\2\21c\3\2\2\2\23e\3\2\2\2\25h\3\2\2\2\27k\3\2\2\2\31p\3\2\2\2"+
		"\33t\3\2\2\2\35y\3\2\2\2\37{\3\2\2\2!~\3\2\2\2#\u0081\3\2\2\2%\u0083\3"+
		"\2\2\2\'\u0085\3\2\2\2)\u0087\3\2\2\2+\u0089\3\2\2\2-\u008b\3\2\2\2/\u008d"+
		"\3\2\2\2\61\u008f\3\2\2\2\63\u0091\3\2\2\2\65\u0094\3\2\2\2\67\u009f\3"+
		"\2\2\29\u00a3\3\2\2\2;<\7E\2\2<=\7n\2\2=>\7c\2\2>?\7u\2\2?@\7u\2\2@\4"+
		"\3\2\2\2AB\7K\2\2BC\7p\2\2CD\7v\2\2DE\7g\2\2EF\7t\2\2FG\7h\2\2GH\7c\2"+
		"\2HI\7e\2\2IJ\7g\2\2J\6\3\2\2\2KL\7O\2\2LM\7g\2\2MN\7v\2\2NO\7j\2\2OP"+
		"\7q\2\2PQ\7f\2\2Q\b\3\2\2\2RS\7H\2\2ST\7k\2\2TU\7g\2\2UV\7n\2\2VW\7f\2"+
		"\2W\n\3\2\2\2XY\7Q\2\2YZ\7d\2\2Z[\7l\2\2[\\\7g\2\2\\]\7e\2\2]^\7v\2\2"+
		"^\f\3\2\2\2_`\7*\2\2`\16\3\2\2\2ab\7+\2\2b\20\3\2\2\2cd\7?\2\2d\22\3\2"+
		"\2\2ef\7k\2\2fg\7p\2\2g\24\3\2\2\2hi\7p\2\2ij\7q\2\2j\26\3\2\2\2kl\7u"+
		"\2\2lm\7q\2\2mn\7o\2\2no\7g\2\2o\30\3\2\2\2pq\7q\2\2qr\7p\2\2rs\7g\2\2"+
		"s\32\3\2\2\2tu\7n\2\2uv\7q\2\2vw\7p\2\2wx\7g\2\2x\34\3\2\2\2yz\7#\2\2"+
		"z\36\3\2\2\2{|\7~\2\2|}\7~\2\2} \3\2\2\2~\177\7(\2\2\177\u0080\7(\2\2"+
		"\u0080\"\3\2\2\2\u0081\u0082\7\60\2\2\u0082$\3\2\2\2\u0083\u0084\7,\2"+
		"\2\u0084&\3\2\2\2\u0085\u0086\7`\2\2\u0086(\3\2\2\2\u0087\u0088\7-\2\2"+
		"\u0088*\3\2\2\2\u0089\u008a\7/\2\2\u008a,\3\2\2\2\u008b\u008c\7(\2\2\u008c"+
		".\3\2\2\2\u008d\u008e\7\u0080\2\2\u008e\60\3\2\2\2\u008f\u0090\t\2\2\2"+
		"\u0090\62\3\2\2\2\u0091\u0092\t\3\2\2\u0092\64\3\2\2\2\u0093\u0095\t\4"+
		"\2\2\u0094\u0093\3\2\2\2\u0095\u0096\3\2\2\2\u0096\u0094\3\2\2\2\u0096"+
		"\u0097\3\2\2\2\u0097\u0098\3\2\2\2\u0098\u0099\b\33\2\2\u0099\66\3\2\2"+
		"\2\u009a\u009c\7\17\2\2\u009b\u009a\3\2\2\2\u009b\u009c\3\2\2\2\u009c"+
		"\u009d\3\2\2\2\u009d\u00a0\7\f\2\2\u009e\u00a0\7\17\2\2\u009f\u009b\3"+
		"\2\2\2\u009f\u009e\3\2\2\2\u00a0\u00a1\3\2\2\2\u00a1\u009f\3\2\2\2\u00a1"+
		"\u00a2\3\2\2\2\u00a28\3\2\2\2\u00a3\u00aa\5\61\31\2\u00a4\u00a7\5\63\32"+
		"\2\u00a5\u00a7\7a\2\2\u00a6\u00a4\3\2\2\2\u00a6\u00a5\3\2\2\2\u00a7\u00a8"+
		"\3\2\2\2\u00a8\u00a6\3\2\2\2\u00a8\u00a9\3\2\2\2\u00a9\u00ab\3\2\2\2\u00aa"+
		"\u00a6\3\2\2\2\u00aa\u00ab\3\2\2\2\u00ab:\3\2\2\2\n\2\u0096\u009b\u009f"+
		"\u00a1\u00a6\u00a8\u00aa\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}