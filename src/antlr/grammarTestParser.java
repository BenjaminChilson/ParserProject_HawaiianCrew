// Generated from ./grammar/grammarTest.g4 by ANTLR 4.9.2

    package antlr;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class grammarTestParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, SKIP_=3, NEWLINE=4, IF=5, ELIF=6, ELSE=7, ARITHMETIC=8, 
		ASSIGNMENT=9, CONDITIONAL=10, ID=11, NUM=12, CHAR=13, COMMENT=14, NL=15, 
		OPEN_BRACE=16, CLOSE_BRACE=17, OPEN_BRACK=18, CLOSE_BRACK=19, OPEN_PAREN=20, 
		CLOSE_PAREN=21, WS=22, TAB=23, INDENT=24, DEDENT=25;
	public static final int
		RULE_prule = 0, RULE_controlFlow = 1, RULE_if_statement = 2, RULE_elif_rule = 3, 
		RULE_else_rule = 4, RULE_block = 5, RULE_ifelseelif = 6, RULE_prog = 7, 
		RULE_decl = 8, RULE_expr = 9;
	private static String[] makeRuleNames() {
		return new String[] {
			"prule", "controlFlow", "if_statement", "elif_rule", "else_rule", "block", 
			"ifelseelif", "prog", "decl", "expr"
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
			"WS", "TAB", "INDENT", "DEDENT"
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

	@Override
	public String getGrammarFileName() { return "grammarTest.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public grammarTestParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class PruleContext extends ParserRuleContext {
		public IfelseelifContext ifelseelif() {
			return getRuleContext(IfelseelifContext.class,0);
		}
		public List<BlockContext> block() {
			return getRuleContexts(BlockContext.class);
		}
		public BlockContext block(int i) {
			return getRuleContext(BlockContext.class,i);
		}
		public PruleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prule; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof grammarTestListener ) ((grammarTestListener)listener).enterPrule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof grammarTestListener ) ((grammarTestListener)listener).exitPrule(this);
		}
	}

	public final PruleContext prule() throws RecognitionException {
		PruleContext _localctx = new PruleContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prule);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(20);
			ifelseelif();
			setState(22); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(21);
				block();
				}
				}
				setState(24); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==TAB || _la==INDENT );
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

	public static class ControlFlowContext extends ParserRuleContext {
		public IfelseelifContext ifelseelif() {
			return getRuleContext(IfelseelifContext.class,0);
		}
		public ControlFlowContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_controlFlow; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof grammarTestListener ) ((grammarTestListener)listener).enterControlFlow(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof grammarTestListener ) ((grammarTestListener)listener).exitControlFlow(this);
		}
	}

	public final ControlFlowContext controlFlow() throws RecognitionException {
		ControlFlowContext _localctx = new ControlFlowContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_controlFlow);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(26);
			ifelseelif();
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

	public static class If_statementContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(grammarTestParser.IF, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public If_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_if_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof grammarTestListener ) ((grammarTestListener)listener).enterIf_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof grammarTestListener ) ((grammarTestListener)listener).exitIf_statement(this);
		}
	}

	public final If_statementContext if_statement() throws RecognitionException {
		If_statementContext _localctx = new If_statementContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_if_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(28);
			match(IF);
			setState(29);
			expr(0);
			setState(30);
			match(T__0);
			setState(32);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				{
				setState(31);
				block();
				}
				break;
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

	public static class Elif_ruleContext extends ParserRuleContext {
		public TerminalNode ELIF() { return getToken(grammarTestParser.ELIF, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public Elif_ruleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elif_rule; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof grammarTestListener ) ((grammarTestListener)listener).enterElif_rule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof grammarTestListener ) ((grammarTestListener)listener).exitElif_rule(this);
		}
	}

	public final Elif_ruleContext elif_rule() throws RecognitionException {
		Elif_ruleContext _localctx = new Elif_ruleContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_elif_rule);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(34);
			match(ELIF);
			setState(35);
			expr(0);
			setState(36);
			match(T__0);
			setState(38);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				{
				setState(37);
				block();
				}
				break;
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

	public static class Else_ruleContext extends ParserRuleContext {
		public TerminalNode ELSE() { return getToken(grammarTestParser.ELSE, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public Else_ruleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_else_rule; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof grammarTestListener ) ((grammarTestListener)listener).enterElse_rule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof grammarTestListener ) ((grammarTestListener)listener).exitElse_rule(this);
		}
	}

	public final Else_ruleContext else_rule() throws RecognitionException {
		Else_ruleContext _localctx = new Else_ruleContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_else_rule);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(40);
			match(ELSE);
			setState(41);
			match(T__0);
			setState(43);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				{
				setState(42);
				block();
				}
				break;
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

	public static class BlockContext extends ParserRuleContext {
		public List<TerminalNode> TAB() { return getTokens(grammarTestParser.TAB); }
		public TerminalNode TAB(int i) {
			return getToken(grammarTestParser.TAB, i);
		}
		public List<TerminalNode> NL() { return getTokens(grammarTestParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(grammarTestParser.NL, i);
		}
		public List<TerminalNode> CHAR() { return getTokens(grammarTestParser.CHAR); }
		public TerminalNode CHAR(int i) {
			return getToken(grammarTestParser.CHAR, i);
		}
		public TerminalNode INDENT() { return getToken(grammarTestParser.INDENT, 0); }
		public ControlFlowContext controlFlow() {
			return getRuleContext(ControlFlowContext.class,0);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof grammarTestListener ) ((grammarTestListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof grammarTestListener ) ((grammarTestListener)listener).exitBlock(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_block);
		int _la;
		try {
			int _alt;
			setState(58);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TAB:
				enterOuterAlt(_localctx, 1);
				{
				setState(52); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(45);
						match(TAB);
						setState(47); 
						_errHandler.sync(this);
						_la = _input.LA(1);
						do {
							{
							{
							setState(46);
							match(CHAR);
							}
							}
							setState(49); 
							_errHandler.sync(this);
							_la = _input.LA(1);
						} while ( _la==CHAR );
						setState(51);
						match(NL);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(54); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			case INDENT:
				enterOuterAlt(_localctx, 2);
				{
				setState(56);
				match(INDENT);
				setState(57);
				controlFlow();
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

	public static class IfelseelifContext extends ParserRuleContext {
		public If_statementContext if_statement() {
			return getRuleContext(If_statementContext.class,0);
		}
		public List<Elif_ruleContext> elif_rule() {
			return getRuleContexts(Elif_ruleContext.class);
		}
		public Elif_ruleContext elif_rule(int i) {
			return getRuleContext(Elif_ruleContext.class,i);
		}
		public Else_ruleContext else_rule() {
			return getRuleContext(Else_ruleContext.class,0);
		}
		public IfelseelifContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifelseelif; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof grammarTestListener ) ((grammarTestListener)listener).enterIfelseelif(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof grammarTestListener ) ((grammarTestListener)listener).exitIfelseelif(this);
		}
	}

	public final IfelseelifContext ifelseelif() throws RecognitionException {
		IfelseelifContext _localctx = new IfelseelifContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_ifelseelif);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(60);
			if_statement();
			setState(64);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(61);
					elif_rule();
					}
					} 
				}
				setState(66);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			}
			setState(68);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				{
				setState(67);
				else_rule();
				}
				break;
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

	public static class ProgContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(grammarTestParser.EOF, 0); }
		public List<DeclContext> decl() {
			return getRuleContexts(DeclContext.class);
		}
		public DeclContext decl(int i) {
			return getRuleContext(DeclContext.class,i);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof grammarTestListener ) ((grammarTestListener)listener).enterProg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof grammarTestListener ) ((grammarTestListener)listener).exitProg(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_prog);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(72); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(72);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
				case 1:
					{
					setState(70);
					decl();
					}
					break;
				case 2:
					{
					setState(71);
					expr(0);
					}
					break;
				}
				}
				setState(74); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==ID || _la==NUM );
			setState(76);
			match(EOF);
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

	public static class DeclContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(grammarTestParser.ID, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public DeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof grammarTestListener ) ((grammarTestListener)listener).enterDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof grammarTestListener ) ((grammarTestListener)listener).exitDecl(this);
		}
	}

	public final DeclContext decl() throws RecognitionException {
		DeclContext _localctx = new DeclContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_decl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(78);
			match(ID);
			setState(79);
			match(T__1);
			setState(80);
			expr(0);
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

	public static class ExprContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(grammarTestParser.ID, 0); }
		public TerminalNode NUM() { return getToken(grammarTestParser.NUM, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode CONDITIONAL() { return getToken(grammarTestParser.CONDITIONAL, 0); }
		public TerminalNode ARITHMETIC() { return getToken(grammarTestParser.ARITHMETIC, 0); }
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof grammarTestListener ) ((grammarTestListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof grammarTestListener ) ((grammarTestListener)listener).exitExpr(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 18;
		enterRecursionRule(_localctx, 18, RULE_expr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(85);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				{
				setState(83);
				match(ID);
				}
				break;
			case NUM:
				{
				setState(84);
				match(NUM);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(95);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(93);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
					case 1:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(87);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(88);
						match(CONDITIONAL);
						setState(89);
						expr(5);
						}
						break;
					case 2:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(90);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(91);
						match(ARITHMETIC);
						setState(92);
						expr(4);
						}
						break;
					}
					} 
				}
				setState(97);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
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
		case 9:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 4);
		case 1:
			return precpred(_ctx, 3);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\33e\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t\13\3"+
		"\2\3\2\6\2\31\n\2\r\2\16\2\32\3\3\3\3\3\4\3\4\3\4\3\4\5\4#\n\4\3\5\3\5"+
		"\3\5\3\5\5\5)\n\5\3\6\3\6\3\6\5\6.\n\6\3\7\3\7\6\7\62\n\7\r\7\16\7\63"+
		"\3\7\6\7\67\n\7\r\7\16\78\3\7\3\7\5\7=\n\7\3\b\3\b\7\bA\n\b\f\b\16\bD"+
		"\13\b\3\b\5\bG\n\b\3\t\3\t\6\tK\n\t\r\t\16\tL\3\t\3\t\3\n\3\n\3\n\3\n"+
		"\3\13\3\13\3\13\5\13X\n\13\3\13\3\13\3\13\3\13\3\13\3\13\7\13`\n\13\f"+
		"\13\16\13c\13\13\3\13\2\3\24\f\2\4\6\b\n\f\16\20\22\24\2\2\2h\2\26\3\2"+
		"\2\2\4\34\3\2\2\2\6\36\3\2\2\2\b$\3\2\2\2\n*\3\2\2\2\f<\3\2\2\2\16>\3"+
		"\2\2\2\20J\3\2\2\2\22P\3\2\2\2\24W\3\2\2\2\26\30\5\16\b\2\27\31\5\f\7"+
		"\2\30\27\3\2\2\2\31\32\3\2\2\2\32\30\3\2\2\2\32\33\3\2\2\2\33\3\3\2\2"+
		"\2\34\35\5\16\b\2\35\5\3\2\2\2\36\37\7\7\2\2\37 \5\24\13\2 \"\7\3\2\2"+
		"!#\5\f\7\2\"!\3\2\2\2\"#\3\2\2\2#\7\3\2\2\2$%\7\b\2\2%&\5\24\13\2&(\7"+
		"\3\2\2\')\5\f\7\2(\'\3\2\2\2()\3\2\2\2)\t\3\2\2\2*+\7\t\2\2+-\7\3\2\2"+
		",.\5\f\7\2-,\3\2\2\2-.\3\2\2\2.\13\3\2\2\2/\61\7\31\2\2\60\62\7\17\2\2"+
		"\61\60\3\2\2\2\62\63\3\2\2\2\63\61\3\2\2\2\63\64\3\2\2\2\64\65\3\2\2\2"+
		"\65\67\7\21\2\2\66/\3\2\2\2\678\3\2\2\28\66\3\2\2\289\3\2\2\29=\3\2\2"+
		"\2:;\7\32\2\2;=\5\4\3\2<\66\3\2\2\2<:\3\2\2\2=\r\3\2\2\2>B\5\6\4\2?A\5"+
		"\b\5\2@?\3\2\2\2AD\3\2\2\2B@\3\2\2\2BC\3\2\2\2CF\3\2\2\2DB\3\2\2\2EG\5"+
		"\n\6\2FE\3\2\2\2FG\3\2\2\2G\17\3\2\2\2HK\5\22\n\2IK\5\24\13\2JH\3\2\2"+
		"\2JI\3\2\2\2KL\3\2\2\2LJ\3\2\2\2LM\3\2\2\2MN\3\2\2\2NO\7\2\2\3O\21\3\2"+
		"\2\2PQ\7\r\2\2QR\7\4\2\2RS\5\24\13\2S\23\3\2\2\2TU\b\13\1\2UX\7\r\2\2"+
		"VX\7\16\2\2WT\3\2\2\2WV\3\2\2\2Xa\3\2\2\2YZ\f\6\2\2Z[\7\f\2\2[`\5\24\13"+
		"\7\\]\f\5\2\2]^\7\n\2\2^`\5\24\13\6_Y\3\2\2\2_\\\3\2\2\2`c\3\2\2\2a_\3"+
		"\2\2\2ab\3\2\2\2b\25\3\2\2\2ca\3\2\2\2\20\32\"(-\638<BFJLW_a";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}