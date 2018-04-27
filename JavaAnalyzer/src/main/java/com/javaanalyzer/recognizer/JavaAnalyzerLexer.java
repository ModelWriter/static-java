// Generated from /home/harun/git/static-java/JavaAnalyzer/src/main/java/com/javaanalyzer/recognizer/JavaAnalyzer.g4 by ANTLR 4.7
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
		T__9=10, WHITESPACE=11, NEWLINE=12, VAR=13;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "LOWERCASE", "UPPERCASE", "WHITESPACE", "NEWLINE", "VAR"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'Class'", "'Interface'", "'Method'", "'Field'", "'('", "')'", "'.'", 
		"'='", "'in'", "'!'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, "WHITESPACE", 
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\17f\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\n"+
		"\3\13\3\13\3\f\3\f\3\r\3\r\3\16\6\16Q\n\16\r\16\16\16R\3\16\3\16\3\17"+
		"\5\17X\n\17\3\17\3\17\6\17\\\n\17\r\17\16\17]\3\20\3\20\3\20\6\20c\n\20"+
		"\r\20\16\20d\2\2\21\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\2"+
		"\31\2\33\r\35\16\37\17\3\2\5\3\2c|\3\2C\\\4\2\13\13\"\"\2j\2\3\3\2\2\2"+
		"\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2"+
		"\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2"+
		"\2\37\3\2\2\2\3!\3\2\2\2\5\'\3\2\2\2\7\61\3\2\2\2\t8\3\2\2\2\13>\3\2\2"+
		"\2\r@\3\2\2\2\17B\3\2\2\2\21D\3\2\2\2\23F\3\2\2\2\25I\3\2\2\2\27K\3\2"+
		"\2\2\31M\3\2\2\2\33P\3\2\2\2\35[\3\2\2\2\37b\3\2\2\2!\"\7E\2\2\"#\7n\2"+
		"\2#$\7c\2\2$%\7u\2\2%&\7u\2\2&\4\3\2\2\2\'(\7K\2\2()\7p\2\2)*\7v\2\2*"+
		"+\7g\2\2+,\7t\2\2,-\7h\2\2-.\7c\2\2./\7e\2\2/\60\7g\2\2\60\6\3\2\2\2\61"+
		"\62\7O\2\2\62\63\7g\2\2\63\64\7v\2\2\64\65\7j\2\2\65\66\7q\2\2\66\67\7"+
		"f\2\2\67\b\3\2\2\289\7H\2\29:\7k\2\2:;\7g\2\2;<\7n\2\2<=\7f\2\2=\n\3\2"+
		"\2\2>?\7*\2\2?\f\3\2\2\2@A\7+\2\2A\16\3\2\2\2BC\7\60\2\2C\20\3\2\2\2D"+
		"E\7?\2\2E\22\3\2\2\2FG\7k\2\2GH\7p\2\2H\24\3\2\2\2IJ\7#\2\2J\26\3\2\2"+
		"\2KL\t\2\2\2L\30\3\2\2\2MN\t\3\2\2N\32\3\2\2\2OQ\t\4\2\2PO\3\2\2\2QR\3"+
		"\2\2\2RP\3\2\2\2RS\3\2\2\2ST\3\2\2\2TU\b\16\2\2U\34\3\2\2\2VX\7\17\2\2"+
		"WV\3\2\2\2WX\3\2\2\2XY\3\2\2\2Y\\\7\f\2\2Z\\\7\17\2\2[W\3\2\2\2[Z\3\2"+
		"\2\2\\]\3\2\2\2][\3\2\2\2]^\3\2\2\2^\36\3\2\2\2_c\5\27\f\2`c\5\31\r\2"+
		"ac\7a\2\2b_\3\2\2\2b`\3\2\2\2ba\3\2\2\2cd\3\2\2\2db\3\2\2\2de\3\2\2\2"+
		"e \3\2\2\2\t\2RW[]bd\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}