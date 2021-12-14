// Generated from ./grammar/grammarTest.g4 by ANTLR 4.9.2

    package antlr;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class grammarTestLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, SKIP_=3, NEWLINE=4, IF=5, ELIF=6, ELSE=7, ARITHMETIC=8, 
		ASSIGNMENT=9, CONDITIONAL=10, ID=11, NUM=12, CHAR=13, COMMENT=14, NL=15, 
		OPEN_BRACE=16, CLOSE_BRACE=17, OPEN_BRACK=18, CLOSE_BRACK=19, OPEN_PAREN=20, 
		CLOSE_PAREN=21, WS=22, TAB=23;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "SKIP_", "NEWLINE", "IF", "ELIF", "ELSE", "ARITHMETIC", 
			"ASSIGNMENT", "CONDITIONAL", "ID", "NUM", "CHAR", "COMMENT", "NL", "OPEN_BRACE", 
			"CLOSE_BRACE", "OPEN_BRACK", "CLOSE_BRACK", "OPEN_PAREN", "CLOSE_PAREN", 
			"SPACES", "LINE_JOINING", "WS", "TAB"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "':\n'", "'='", null, null, "'if'", "'elif'", "'else'", null, null, 
			null, null, null, null, null, "'\n'", "'{'", "'}'", "'['", "']'", "'('", 
			"')'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, "SKIP_", "NEWLINE", "IF", "ELIF", "ELSE", "ARITHMETIC", 
			"ASSIGNMENT", "CONDITIONAL", "ID", "NUM", "CHAR", "COMMENT", "NL", "OPEN_BRACE", 
			"CLOSE_BRACE", "OPEN_BRACK", "CLOSE_BRACK", "OPEN_PAREN", "CLOSE_PAREN", 
			"WS", "TAB"
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

	      private java.util.Stack<Integer> indents = new java.util.Stack<>();

	      private int opened = 0;

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
	          this.emit(commonToken(NEWLINE, "\n"));

	          // Now emit as much DEDENT tokens as needed.
	          while (!indents.isEmpty()) {
	            this.emit(createDedent());
	            indents.pop();
	          }

	          // Put the EOF back on the token stream.
	          this.emit(commonToken(EOF, "<EOF>"));
	        }

	        Token next = super.nextToken();

	        if (next.getChannel() == Token.DEFAULT_CHANNEL) {
	          // Keep track of the last token on the default channel.
	          this.lastToken = next;
	        }

	        return tokens.isEmpty() ? next : tokens.poll();
	      }

	      private Token createDedent() {
	        CommonToken dedent = commonToken(DEDENT, "");
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
	          if (opened > 0 || (nextnext != -1 && (next == '\r' || next == '\n' || next == '\f' || next == '#'))) {
	              // If we're inside a list or on a blank line, ignore all indents,
	              // dedents and line breaks.
	              skip();
	          }
	          else {
	              emit(commonToken(NEWLINE, newLine));
	              int indent = getIndentationCount(spaces);
	              int previous = indents.isEmpty() ? 0 : indents.peek();
	              if (indent == previous) {
	                  // skip indents of the same size as the present indent-size
	                  skip();
	              }
	              else if (indent > previous) {
	                  indents.push(indent);
	                  emit(commonToken(INDENT, spaces));
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


	public grammarTestLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "grammarTest.g4"; }

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
		case 3:
			NEWLINE_action((RuleContext)_localctx, actionIndex);
			break;
		case 15:
			OPEN_BRACE_action((RuleContext)_localctx, actionIndex);
			break;
		case 16:
			CLOSE_BRACE_action((RuleContext)_localctx, actionIndex);
			break;
		case 17:
			OPEN_BRACK_action((RuleContext)_localctx, actionIndex);
			break;
		case 18:
			CLOSE_BRACK_action((RuleContext)_localctx, actionIndex);
			break;
		case 19:
			OPEN_PAREN_action((RuleContext)_localctx, actionIndex);
			break;
		case 20:
			CLOSE_PAREN_action((RuleContext)_localctx, actionIndex);
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
	private void OPEN_BRACE_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 1:
			openBrace();
			break;
		}
	}
	private void CLOSE_BRACE_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 2:
			closeBrace();
			break;
		}
	}
	private void OPEN_BRACK_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 3:
			openBrace();
			break;
		}
	}
	private void CLOSE_BRACK_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 4:
			closeBrace();
			break;
		}
	}
	private void OPEN_PAREN_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 5:
			openBrace();
			break;
		}
	}
	private void CLOSE_PAREN_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 6:
			closeBrace();
			break;
		}
	}
	@Override
	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 3:
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\31\u00df\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\3\2\3\2\3\2\3\3\3\3\3\4\3\4\3\4\5\4>\n\4\3\4\3\4\3\5\3"+
		"\5\3\5\5\5E\n\5\3\5\3\5\5\5I\n\5\3\5\5\5L\n\5\5\5N\n\5\3\5\3\5\3\6\3\6"+
		"\3\6\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\nn\n\n\3\13\3\13\3\13\3\13\3\13\3"+
		"\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u0080\n\13"+
		"\3\f\3\f\7\f\u0084\n\f\f\f\16\f\u0087\13\f\3\r\3\r\5\r\u008b\n\r\3\r\3"+
		"\r\7\r\u008f\n\r\f\r\16\r\u0092\13\r\5\r\u0094\n\r\3\16\6\16\u0097\n\16"+
		"\r\16\16\16\u0098\3\16\3\16\6\16\u009d\n\16\r\16\16\16\u009e\7\16\u00a1"+
		"\n\16\f\16\16\16\u00a4\13\16\3\17\3\17\7\17\u00a8\n\17\f\17\16\17\u00ab"+
		"\13\17\3\17\3\17\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\22\3\22\3\22\3\23"+
		"\3\23\3\23\3\24\3\24\3\24\3\25\3\25\3\25\3\26\3\26\3\26\3\27\6\27\u00c6"+
		"\n\27\r\27\16\27\u00c7\3\30\3\30\5\30\u00cc\n\30\3\30\5\30\u00cf\n\30"+
		"\3\30\3\30\5\30\u00d3\n\30\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32"+
		"\5\32\u00de\n\32\2\2\33\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f"+
		"\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\2/\2\61\30\63"+
		"\31\3\2\n\7\2\'\',-//\61\61``\4\2C\\c|\6\2\62;C\\aac|\3\2\63;\3\2\62;"+
		"\3\2\f\f\4\2\13\13\"\"\4\2\13\f\"\"\2\u00fc\2\3\3\2\2\2\2\5\3\2\2\2\2"+
		"\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2"+
		"\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2"+
		"\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2"+
		"\2\2)\3\2\2\2\2+\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\3\65\3\2\2\2\58\3\2"+
		"\2\2\7=\3\2\2\2\tM\3\2\2\2\13Q\3\2\2\2\rT\3\2\2\2\17Y\3\2\2\2\21^\3\2"+
		"\2\2\23m\3\2\2\2\25\177\3\2\2\2\27\u0081\3\2\2\2\31\u0093\3\2\2\2\33\u0096"+
		"\3\2\2\2\35\u00a5\3\2\2\2\37\u00ae\3\2\2\2!\u00b2\3\2\2\2#\u00b5\3\2\2"+
		"\2%\u00b8\3\2\2\2\'\u00bb\3\2\2\2)\u00be\3\2\2\2+\u00c1\3\2\2\2-\u00c5"+
		"\3\2\2\2/\u00c9\3\2\2\2\61\u00d4\3\2\2\2\63\u00dd\3\2\2\2\65\66\7<\2\2"+
		"\66\67\7\f\2\2\67\4\3\2\2\289\7?\2\29\6\3\2\2\2:>\5-\27\2;>\5\35\17\2"+
		"<>\5/\30\2=:\3\2\2\2=;\3\2\2\2=<\3\2\2\2>?\3\2\2\2?@\b\4\2\2@\b\3\2\2"+
		"\2AB\6\5\2\2BN\5-\27\2CE\7\17\2\2DC\3\2\2\2DE\3\2\2\2EF\3\2\2\2FI\7\f"+
		"\2\2GI\4\16\17\2HD\3\2\2\2HG\3\2\2\2IK\3\2\2\2JL\5-\27\2KJ\3\2\2\2KL\3"+
		"\2\2\2LN\3\2\2\2MA\3\2\2\2MH\3\2\2\2NO\3\2\2\2OP\b\5\3\2P\n\3\2\2\2QR"+
		"\7k\2\2RS\7h\2\2S\f\3\2\2\2TU\7g\2\2UV\7n\2\2VW\7k\2\2WX\7h\2\2X\16\3"+
		"\2\2\2YZ\7g\2\2Z[\7n\2\2[\\\7u\2\2\\]\7g\2\2]\20\3\2\2\2^_\t\2\2\2_\22"+
		"\3\2\2\2`n\7?\2\2ab\7-\2\2bn\7?\2\2cd\7/\2\2dn\7?\2\2ef\7,\2\2fn\7?\2"+
		"\2gh\7\61\2\2hn\7?\2\2ij\7`\2\2jn\7?\2\2kl\7\'\2\2ln\7?\2\2m`\3\2\2\2"+
		"ma\3\2\2\2mc\3\2\2\2me\3\2\2\2mg\3\2\2\2mi\3\2\2\2mk\3\2\2\2n\24\3\2\2"+
		"\2op\7?\2\2p\u0080\7?\2\2q\u0080\7@\2\2rs\7@\2\2s\u0080\7?\2\2t\u0080"+
		"\7>\2\2uv\7>\2\2v\u0080\7?\2\2wx\7c\2\2xy\7p\2\2y\u0080\7f\2\2z{\7q\2"+
		"\2{\u0080\7t\2\2|}\7p\2\2}~\7q\2\2~\u0080\7v\2\2\177o\3\2\2\2\177q\3\2"+
		"\2\2\177r\3\2\2\2\177t\3\2\2\2\177u\3\2\2\2\177w\3\2\2\2\177z\3\2\2\2"+
		"\177|\3\2\2\2\u0080\26\3\2\2\2\u0081\u0085\t\3\2\2\u0082\u0084\t\4\2\2"+
		"\u0083\u0082\3\2\2\2\u0084\u0087\3\2\2\2\u0085\u0083\3\2\2\2\u0085\u0086"+
		"\3\2\2\2\u0086\30\3\2\2\2\u0087\u0085\3\2\2\2\u0088\u0094\7\62\2\2\u0089"+
		"\u008b\7/\2\2\u008a\u0089\3\2\2\2\u008a\u008b\3\2\2\2\u008b\u008c\3\2"+
		"\2\2\u008c\u0090\t\5\2\2\u008d\u008f\t\6\2\2\u008e\u008d\3\2\2\2\u008f"+
		"\u0092\3\2\2\2\u0090\u008e\3\2\2\2\u0090\u0091\3\2\2\2\u0091\u0094\3\2"+
		"\2\2\u0092\u0090\3\2\2\2\u0093\u0088\3\2\2\2\u0093\u008a\3\2\2\2\u0094"+
		"\32\3\2\2\2\u0095\u0097\4c|\2\u0096\u0095\3\2\2\2\u0097\u0098\3\2\2\2"+
		"\u0098\u0096\3\2\2\2\u0098\u0099\3\2\2\2\u0099\u00a2\3\2\2\2\u009a\u009c"+
		"\7\"\2\2\u009b\u009d\4c|\2\u009c\u009b\3\2\2\2\u009d\u009e\3\2\2\2\u009e"+
		"\u009c\3\2\2\2\u009e\u009f\3\2\2\2\u009f\u00a1\3\2\2\2\u00a0\u009a\3\2"+
		"\2\2\u00a1\u00a4\3\2\2\2\u00a2\u00a0\3\2\2\2\u00a2\u00a3\3\2\2\2\u00a3"+
		"\34\3\2\2\2\u00a4\u00a2\3\2\2\2\u00a5\u00a9\7%\2\2\u00a6\u00a8\n\7\2\2"+
		"\u00a7\u00a6\3\2\2\2\u00a8\u00ab\3\2\2\2\u00a9\u00a7\3\2\2\2\u00a9\u00aa"+
		"\3\2\2\2\u00aa\u00ac\3\2\2\2\u00ab\u00a9\3\2\2\2\u00ac\u00ad\b\17\2\2"+
		"\u00ad\36\3\2\2\2\u00ae\u00af\7\f\2\2\u00af\u00b0\3\2\2\2\u00b0\u00b1"+
		"\b\20\2\2\u00b1 \3\2\2\2\u00b2\u00b3\7}\2\2\u00b3\u00b4\b\21\4\2\u00b4"+
		"\"\3\2\2\2\u00b5\u00b6\7\177\2\2\u00b6\u00b7\b\22\5\2\u00b7$\3\2\2\2\u00b8"+
		"\u00b9\7]\2\2\u00b9\u00ba\b\23\6\2\u00ba&\3\2\2\2\u00bb\u00bc\7_\2\2\u00bc"+
		"\u00bd\b\24\7\2\u00bd(\3\2\2\2\u00be\u00bf\7*\2\2\u00bf\u00c0\b\25\b\2"+
		"\u00c0*\3\2\2\2\u00c1\u00c2\7+\2\2\u00c2\u00c3\b\26\t\2\u00c3,\3\2\2\2"+
		"\u00c4\u00c6\t\b\2\2\u00c5\u00c4\3\2\2\2\u00c6\u00c7\3\2\2\2\u00c7\u00c5"+
		"\3\2\2\2\u00c7\u00c8\3\2\2\2\u00c8.\3\2\2\2\u00c9\u00cb\7^\2\2\u00ca\u00cc"+
		"\5-\27\2\u00cb\u00ca\3\2\2\2\u00cb\u00cc\3\2\2\2\u00cc\u00d2\3\2\2\2\u00cd"+
		"\u00cf\7\17\2\2\u00ce\u00cd\3\2\2\2\u00ce\u00cf\3\2\2\2\u00cf\u00d0\3"+
		"\2\2\2\u00d0\u00d3\7\f\2\2\u00d1\u00d3\4\16\17\2\u00d2\u00ce\3\2\2\2\u00d2"+
		"\u00d1\3\2\2\2\u00d3\60\3\2\2\2\u00d4\u00d5\t\t\2\2\u00d5\u00d6\3\2\2"+
		"\2\u00d6\u00d7\b\31\2\2\u00d7\62\3\2\2\2\u00d8\u00de\7\13\2\2\u00d9\u00da"+
		"\7\"\2\2\u00da\u00db\7\"\2\2\u00db\u00dc\7\"\2\2\u00dc\u00de\7\"\2\2\u00dd"+
		"\u00d8\3\2\2\2\u00dd\u00d9\3\2\2\2\u00de\64\3\2\2\2\27\2=DHKMm\177\u0085"+
		"\u008a\u0090\u0093\u0098\u009e\u00a2\u00a9\u00c7\u00cb\u00ce\u00d2\u00dd"+
		"\n\b\2\2\3\5\2\3\21\3\3\22\4\3\23\5\3\24\6\3\25\7\3\26\b";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}