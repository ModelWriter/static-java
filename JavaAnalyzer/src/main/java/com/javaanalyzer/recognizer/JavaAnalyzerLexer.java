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
		T__17=18, T__18=19, T__19=20, T__20=21, WHITESPACE=22, NEWLINE=23, VAR=24;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "T__16", 
		"T__17", "T__18", "T__19", "T__20", "ALPHA", "ALPHANUMERIC", "WHITESPACE", 
		"NEWLINE", "VAR"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'Class'", "'Interface'", "'Method'", "'Field'", "'Object'", "'('", 
		"')'", "'='", "'in'", "'no'", "'some'", "'one'", "'lone'", "'!'", "'||'", 
		"'&&'", "'.'", "'*'", "'^'", "'+'", "'~'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, "WHITESPACE", 
		"NEWLINE", "VAR"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\32\u00a4\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\n\3\13"+
		"\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16"+
		"\3\17\3\17\3\20\3\20\3\20\3\21\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24"+
		"\3\25\3\25\3\26\3\26\3\27\3\27\3\30\3\30\3\31\6\31\u008d\n\31\r\31\16"+
		"\31\u008e\3\31\3\31\3\32\5\32\u0094\n\32\3\32\3\32\6\32\u0098\n\32\r\32"+
		"\16\32\u0099\3\33\3\33\3\33\6\33\u009f\n\33\r\33\16\33\u00a0\5\33\u00a3"+
		"\n\33\2\2\34\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16"+
		"\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\2/\2\61\30\63\31\65\32\3"+
		"\2\5\4\2C\\c|\5\2\62;C\\c|\4\2\13\13\"\"\2\u00a8\2\3\3\2\2\2\2\5\3\2\2"+
		"\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21"+
		"\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2"+
		"\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3"+
		"\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\3"+
		"\67\3\2\2\2\5=\3\2\2\2\7G\3\2\2\2\tN\3\2\2\2\13T\3\2\2\2\r[\3\2\2\2\17"+
		"]\3\2\2\2\21_\3\2\2\2\23a\3\2\2\2\25d\3\2\2\2\27g\3\2\2\2\31l\3\2\2\2"+
		"\33p\3\2\2\2\35u\3\2\2\2\37w\3\2\2\2!z\3\2\2\2#}\3\2\2\2%\177\3\2\2\2"+
		"\'\u0081\3\2\2\2)\u0083\3\2\2\2+\u0085\3\2\2\2-\u0087\3\2\2\2/\u0089\3"+
		"\2\2\2\61\u008c\3\2\2\2\63\u0097\3\2\2\2\65\u009b\3\2\2\2\678\7E\2\28"+
		"9\7n\2\29:\7c\2\2:;\7u\2\2;<\7u\2\2<\4\3\2\2\2=>\7K\2\2>?\7p\2\2?@\7v"+
		"\2\2@A\7g\2\2AB\7t\2\2BC\7h\2\2CD\7c\2\2DE\7e\2\2EF\7g\2\2F\6\3\2\2\2"+
		"GH\7O\2\2HI\7g\2\2IJ\7v\2\2JK\7j\2\2KL\7q\2\2LM\7f\2\2M\b\3\2\2\2NO\7"+
		"H\2\2OP\7k\2\2PQ\7g\2\2QR\7n\2\2RS\7f\2\2S\n\3\2\2\2TU\7Q\2\2UV\7d\2\2"+
		"VW\7l\2\2WX\7g\2\2XY\7e\2\2YZ\7v\2\2Z\f\3\2\2\2[\\\7*\2\2\\\16\3\2\2\2"+
		"]^\7+\2\2^\20\3\2\2\2_`\7?\2\2`\22\3\2\2\2ab\7k\2\2bc\7p\2\2c\24\3\2\2"+
		"\2de\7p\2\2ef\7q\2\2f\26\3\2\2\2gh\7u\2\2hi\7q\2\2ij\7o\2\2jk\7g\2\2k"+
		"\30\3\2\2\2lm\7q\2\2mn\7p\2\2no\7g\2\2o\32\3\2\2\2pq\7n\2\2qr\7q\2\2r"+
		"s\7p\2\2st\7g\2\2t\34\3\2\2\2uv\7#\2\2v\36\3\2\2\2wx\7~\2\2xy\7~\2\2y"+
		" \3\2\2\2z{\7(\2\2{|\7(\2\2|\"\3\2\2\2}~\7\60\2\2~$\3\2\2\2\177\u0080"+
		"\7,\2\2\u0080&\3\2\2\2\u0081\u0082\7`\2\2\u0082(\3\2\2\2\u0083\u0084\7"+
		"-\2\2\u0084*\3\2\2\2\u0085\u0086\7\u0080\2\2\u0086,\3\2\2\2\u0087\u0088"+
		"\t\2\2\2\u0088.\3\2\2\2\u0089\u008a\t\3\2\2\u008a\60\3\2\2\2\u008b\u008d"+
		"\t\4\2\2\u008c\u008b\3\2\2\2\u008d\u008e\3\2\2\2\u008e\u008c\3\2\2\2\u008e"+
		"\u008f\3\2\2\2\u008f\u0090\3\2\2\2\u0090\u0091\b\31\2\2\u0091\62\3\2\2"+
		"\2\u0092\u0094\7\17\2\2\u0093\u0092\3\2\2\2\u0093\u0094\3\2\2\2\u0094"+
		"\u0095\3\2\2\2\u0095\u0098\7\f\2\2\u0096\u0098\7\17\2\2\u0097\u0093\3"+
		"\2\2\2\u0097\u0096\3\2\2\2\u0098\u0099\3\2\2\2\u0099\u0097\3\2\2\2\u0099"+
		"\u009a\3\2\2\2\u009a\64\3\2\2\2\u009b\u00a2\5-\27\2\u009c\u009f\5/\30"+
		"\2\u009d\u009f\7a\2\2\u009e\u009c\3\2\2\2\u009e\u009d\3\2\2\2\u009f\u00a0"+
		"\3\2\2\2\u00a0\u009e\3\2\2\2\u00a0\u00a1\3\2\2\2\u00a1\u00a3\3\2\2\2\u00a2"+
		"\u009e\3\2\2\2\u00a2\u00a3\3\2\2\2\u00a3\66\3\2\2\2\n\2\u008e\u0093\u0097"+
		"\u0099\u009e\u00a0\u00a2\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}