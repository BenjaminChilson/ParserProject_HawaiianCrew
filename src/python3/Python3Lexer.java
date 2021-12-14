// Generated from Python3.g4 by ANTLR 4.9.2

	package python3;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class Python3Lexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, ARITHMETIC=6, ASSIGNMENT=7, CONDITIONAL=8, 
		ID=9, NUM=10, NEWLINE=11, INDENT=12, DEDENT=13, SKIP_=14;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "ARITHMETIC", "ASSIGNMENT", "CONDITIONAL", 
			"ID", "NUM", "NEWLINE", "INDENT", "DEDENT", "SKIP_", "SPACES", "LINE_JOINING"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'if condition_here:'", "'elif condition_here:'", "'else:'", "'#'", 
			"'='", null, null, null, null, null, null, "'addujfnfsncns'", "'bcsdncdncjknsjncd'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, "ARITHMETIC", "ASSIGNMENT", "CONDITIONAL", 
			"ID", "NUM", "NEWLINE", "INDENT", "DEDENT", "SKIP_"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
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


		private java.util.LinkedList<Token> tokens = new java.util.LinkedList<>();
	    // The stack that keeps track of the indentation level.
	    private java.util.Stack<Integer> indents = new java.util.Stack<>();
	    // The amount of opened braces, brackets and parenthesis.
	    private int opened = 0;
	    // The most recently produced token.
	    private Token lastToken = null;
	    @Override
	    public void emit(Token t) {
	        super.setToken(t);
	        tokens.offer(t);
	    }

	    @Override
	    public Token nextToken() {
	        // Check if the end-of-file is ahead and there are still some DEDENTS expected.
	        if (_input.LA(1) == EOF && !this.indents.isEmpty()) {
	            // Remove any trailing EOF tokens from our buffer.
	            for (int i = tokens.size() - 1; i >= 0; i--) {
	                if (tokens.get(i).getType() == EOF) {
	                    tokens.remove(i);
	                }
	            }

	            // First emit an extra line break that serves as the end of the statement.
	            this.emit(commonToken(Python3Lexer.NEWLINE, "\n"));

	            // Now emit as much DEDENT tokens as needed.
	            while (!indents.isEmpty()) {
	                this.emit(createDedent());
	                indents.pop();
	            }

	            // Put the EOF back on the token stream.
	            this.emit(commonToken(Python3Lexer.EOF, "<EOF>"));
	        }

	        Token next = super.nextToken();

	        if (next.getChannel() == Token.DEFAULT_CHANNEL) {
	            // Keep track of the last token on the default channel.
	            this.lastToken = next;
	        }

	        return tokens.isEmpty() ? next : tokens.poll();
	    }

	    private Token createDedent() {
	        CommonToken dedent = commonToken(Python3Lexer.DEDENT, "");
	        dedent.setLine(this.lastToken.getLine());
	        return dedent;
	    }

	    private CommonToken commonToken(int type, String text) {
	        int stop = this.getCharIndex() - 1;
	        int start = text.isEmpty() ? stop : stop - text.length() + 1;
	        return new CommonToken(this._tokenFactorySourcePair, type, DEFAULT_TOKEN_CHANNEL, start, stop);
	    }

	    // Calculates the indentation of the provided spaces, taking the
	    // following rules into account:
	    //
	    // "Tabs are replaced (from left to right) by one to eight spaces
	    //  such that the total number of characters up to and including
	    //  the replacement is a multiple of eight [...]"
	    //
	    //  -- https://docs.python.org/3.1/reference/lexical_analysis.html#indentation
	    static int getIndentationCount(String spaces) {
	        int count = 0;
	        for (char ch : spaces.toCharArray()) {
	            switch (ch) {
	                case '\t':
	                    count += 8 - (count % 8);
	                    break;
	                default:
	                    // A normal space char.
	                    count++;
	            }
	        }

	        return count;
	    }

	    boolean atStartOfInput() {
	        return super.getCharPositionInLine() == 0 && super.getLine() == 1;
	    }

	    void openBrace(){
	        this.opened++;
	    }

	    void closeBrace(){
	        this.opened--;
	    }

	    void onNewLine(){
	        String newLine = getText().replaceAll("[^\r\n\f]+", "");
	        String spaces = getText().replaceAll("[\r\n\f]+", "");

	        // Strip newlines inside open clauses except if we are near EOF. We keep NEWLINEs near EOF to
	        // satisfy the final newline needed by the single_put rule used by the REPL.
	        int next = _input.LA(1);
	        int nextnext = _input.LA(2);
	        if (opened > 0 || (nextnext != -1 && (next == '\r' || next == '\n' || next == '\f'))) {
	            // If we're inside a list or on a blank line, ignore all indents,
	            // dedents and line breaks.
	            skip();
	        }
	        else {
	            emit(commonToken(Python3Lexer.NEWLINE, newLine));
	            int indent = getIndentationCount(spaces);
	            int previous = indents.isEmpty() ? 0 : indents.peek();
	            if (indent == previous) {
	                // skip indents of the same size as the present indent-size
	                skip();
	            }
	            else if (indent > previous) {
	                indents.push(indent);
	                emit(commonToken(Python3Lexer.INDENT, spaces));
	            }
	            else {
	                // Possibly emit more than 1 DEDENT token.
	                while(!indents.isEmpty() && indents.peek() > indent) {
	                    this.emit(createDedent());
	                    indents.pop();
	                }
	            }
	        }
		}


	public Python3Lexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Python3.g4"; }

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

	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 10:
			NEWLINE_action((RuleContext)_localctx, actionIndex);
			break;
		}
	}
	private void NEWLINE_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0:
			onNewLine();
			break;
		}
	}
	@Override
	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 10:
			return NEWLINE_sempred((RuleContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean NEWLINE_sempred(RuleContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return atStartOfInput();
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\20\u00d3\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\be\n\b\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\tw\n\t\3\n\3\n\7\n"+
		"{\n\n\f\n\16\n~\13\n\3\13\3\13\5\13\u0082\n\13\3\13\3\13\7\13\u0086\n"+
		"\13\f\13\16\13\u0089\13\13\5\13\u008b\n\13\3\f\3\f\3\f\5\f\u0090\n\f\3"+
		"\f\3\f\5\f\u0094\n\f\3\f\5\f\u0097\n\f\5\f\u0099\n\f\3\f\3\f\3\r\3\r\3"+
		"\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\17"+
		"\3\17\3\17\5\17\u00c0\n\17\3\17\3\17\3\20\6\20\u00c5\n\20\r\20\16\20\u00c6"+
		"\3\21\3\21\5\21\u00cb\n\21\3\21\5\21\u00ce\n\21\3\21\3\21\5\21\u00d2\n"+
		"\21\2\2\22\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33"+
		"\17\35\20\37\2!\2\3\2\b\7\2\'\',-//\61\61``\4\2C\\c|\6\2\62;C\\aac|\3"+
		"\2\63;\3\2\62;\4\2\13\13\"\"\2\u00eb\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2"+
		"\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23"+
		"\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2"+
		"\2\2\3#\3\2\2\2\5\66\3\2\2\2\7K\3\2\2\2\tQ\3\2\2\2\13S\3\2\2\2\rU\3\2"+
		"\2\2\17d\3\2\2\2\21v\3\2\2\2\23x\3\2\2\2\25\u008a\3\2\2\2\27\u0098\3\2"+
		"\2\2\31\u009c\3\2\2\2\33\u00aa\3\2\2\2\35\u00bf\3\2\2\2\37\u00c4\3\2\2"+
		"\2!\u00c8\3\2\2\2#$\7k\2\2$%\7h\2\2%&\7\"\2\2&\'\7e\2\2\'(\7q\2\2()\7"+
		"p\2\2)*\7f\2\2*+\7k\2\2+,\7v\2\2,-\7k\2\2-.\7q\2\2./\7p\2\2/\60\7a\2\2"+
		"\60\61\7j\2\2\61\62\7g\2\2\62\63\7t\2\2\63\64\7g\2\2\64\65\7<\2\2\65\4"+
		"\3\2\2\2\66\67\7g\2\2\678\7n\2\289\7k\2\29:\7h\2\2:;\7\"\2\2;<\7e\2\2"+
		"<=\7q\2\2=>\7p\2\2>?\7f\2\2?@\7k\2\2@A\7v\2\2AB\7k\2\2BC\7q\2\2CD\7p\2"+
		"\2DE\7a\2\2EF\7j\2\2FG\7g\2\2GH\7t\2\2HI\7g\2\2IJ\7<\2\2J\6\3\2\2\2KL"+
		"\7g\2\2LM\7n\2\2MN\7u\2\2NO\7g\2\2OP\7<\2\2P\b\3\2\2\2QR\7%\2\2R\n\3\2"+
		"\2\2ST\7?\2\2T\f\3\2\2\2UV\t\2\2\2V\16\3\2\2\2We\7?\2\2XY\7-\2\2Ye\7?"+
		"\2\2Z[\7/\2\2[e\7?\2\2\\]\7,\2\2]e\7?\2\2^_\7\61\2\2_e\7?\2\2`a\7`\2\2"+
		"ae\7?\2\2bc\7\'\2\2ce\7?\2\2dW\3\2\2\2dX\3\2\2\2dZ\3\2\2\2d\\\3\2\2\2"+
		"d^\3\2\2\2d`\3\2\2\2db\3\2\2\2e\20\3\2\2\2fg\7?\2\2gw\7?\2\2hw\7@\2\2"+
		"ij\7@\2\2jw\7?\2\2kw\7>\2\2lm\7>\2\2mw\7?\2\2no\7c\2\2op\7p\2\2pw\7f\2"+
		"\2qr\7q\2\2rw\7t\2\2st\7p\2\2tu\7q\2\2uw\7v\2\2vf\3\2\2\2vh\3\2\2\2vi"+
		"\3\2\2\2vk\3\2\2\2vl\3\2\2\2vn\3\2\2\2vq\3\2\2\2vs\3\2\2\2w\22\3\2\2\2"+
		"x|\t\3\2\2y{\t\4\2\2zy\3\2\2\2{~\3\2\2\2|z\3\2\2\2|}\3\2\2\2}\24\3\2\2"+
		"\2~|\3\2\2\2\177\u008b\7\62\2\2\u0080\u0082\7/\2\2\u0081\u0080\3\2\2\2"+
		"\u0081\u0082\3\2\2\2\u0082\u0083\3\2\2\2\u0083\u0087\t\5\2\2\u0084\u0086"+
		"\t\6\2\2\u0085\u0084\3\2\2\2\u0086\u0089\3\2\2\2\u0087\u0085\3\2\2\2\u0087"+
		"\u0088\3\2\2\2\u0088\u008b\3\2\2\2\u0089\u0087\3\2\2\2\u008a\177\3\2\2"+
		"\2\u008a\u0081\3\2\2\2\u008b\26\3\2\2\2\u008c\u008d\6\f\2\2\u008d\u0099"+
		"\5\37\20\2\u008e\u0090\7\17\2\2\u008f\u008e\3\2\2\2\u008f\u0090\3\2\2"+
		"\2\u0090\u0091\3\2\2\2\u0091\u0094\7\f\2\2\u0092\u0094\4\16\17\2\u0093"+
		"\u008f\3\2\2\2\u0093\u0092\3\2\2\2\u0094\u0096\3\2\2\2\u0095\u0097\5\37"+
		"\20\2\u0096\u0095\3\2\2\2\u0096\u0097\3\2\2\2\u0097\u0099\3\2\2\2\u0098"+
		"\u008c\3\2\2\2\u0098\u0093\3\2\2\2\u0099\u009a\3\2\2\2\u009a\u009b\b\f"+
		"\2\2\u009b\30\3\2\2\2\u009c\u009d\7c\2\2\u009d\u009e\7f\2\2\u009e\u009f"+
		"\7f\2\2\u009f\u00a0\7w\2\2\u00a0\u00a1\7l\2\2\u00a1\u00a2\7h\2\2\u00a2"+
		"\u00a3\7p\2\2\u00a3\u00a4\7h\2\2\u00a4\u00a5\7u\2\2\u00a5\u00a6\7p\2\2"+
		"\u00a6\u00a7\7e\2\2\u00a7\u00a8\7p\2\2\u00a8\u00a9\7u\2\2\u00a9\32\3\2"+
		"\2\2\u00aa\u00ab\7d\2\2\u00ab\u00ac\7e\2\2\u00ac\u00ad\7u\2\2\u00ad\u00ae"+
		"\7f\2\2\u00ae\u00af\7p\2\2\u00af\u00b0\7e\2\2\u00b0\u00b1\7f\2\2\u00b1"+
		"\u00b2\7p\2\2\u00b2\u00b3\7e\2\2\u00b3\u00b4\7l\2\2\u00b4\u00b5\7m\2\2"+
		"\u00b5\u00b6\7p\2\2\u00b6\u00b7\7u\2\2\u00b7\u00b8\7l\2\2\u00b8\u00b9"+
		"\7p\2\2\u00b9\u00ba\7e\2\2\u00ba\u00bb\7f\2\2\u00bb\34\3\2\2\2\u00bc\u00c0"+
		"\5\37\20\2\u00bd\u00c0\5!\21\2\u00be\u00c0\7\f\2\2\u00bf\u00bc\3\2\2\2"+
		"\u00bf\u00bd\3\2\2\2\u00bf\u00be\3\2\2\2\u00c0\u00c1\3\2\2\2\u00c1\u00c2"+
		"\b\17\3\2\u00c2\36\3\2\2\2\u00c3\u00c5\t\7\2\2\u00c4\u00c3\3\2\2\2\u00c5"+
		"\u00c6\3\2\2\2\u00c6\u00c4\3\2\2\2\u00c6\u00c7\3\2\2\2\u00c7 \3\2\2\2"+
		"\u00c8\u00ca\7^\2\2\u00c9\u00cb\5\37\20\2\u00ca\u00c9\3\2\2\2\u00ca\u00cb"+
		"\3\2\2\2\u00cb\u00d1\3\2\2\2\u00cc\u00ce\7\17\2\2\u00cd\u00cc\3\2\2\2"+
		"\u00cd\u00ce\3\2\2\2\u00ce\u00cf\3\2\2\2\u00cf\u00d2\7\f\2\2\u00d0\u00d2"+
		"\4\16\17\2\u00d1\u00cd\3\2\2\2\u00d1\u00d0\3\2\2\2\u00d2\"\3\2\2\2\22"+
		"\2dv|\u0081\u0087\u008a\u008f\u0093\u0096\u0098\u00bf\u00c6\u00ca\u00cd"+
		"\u00d1\4\3\f\2\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}