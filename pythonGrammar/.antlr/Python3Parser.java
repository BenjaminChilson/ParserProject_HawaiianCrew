// Generated from c:\Users\benja\CS_Courses\ParserProject_HawaiianCrew\pythonGrammar\Python3.g4 by ANTLR 4.8

	package python3;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class Python3Parser extends Parser {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, COMMENT=4, IF_STATEMENT=5, ELIF_STATEMENT=6, ELSE_STATEMENT=7, 
		WHILE=8, FOR=9, IN=10, OPEN_PAREN=11, CLOSE_PAREN=12, STRING=13, FUNCTION=14, 
		ARITHMETIC=15, ASSIGNMENT=16, CONDITIONAL=17, ID=18, NUM=19, COLON=20, 
		NEWLINE=21, INDENT=22, DEDENT=23, SKIP_=24;
	public static final int
		RULE_prog = 0, RULE_function = 1, RULE_control_flow = 2, RULE_if_statement = 3, 
		RULE_for_loop = 4, RULE_while_statement = 5, RULE_statement = 6, RULE_block = 7, 
		RULE_decl = 8, RULE_expr = 9;
	private static String[] makeRuleNames() {
		return new String[] {
			"prog", "function", "control_flow", "if_statement", "for_loop", "while_statement", 
			"statement", "block", "decl", "expr"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "','", "'else:'", "'='", null, "'if'", "'elif'", "'else'", "'while'", 
			"'for'", "'in'", "'('", "')'", null, null, null, null, null, null, null, 
			"':'", null, "'addu#@#jfn*fsncn#!(#*s'", "'bcsdncd3!#(8!)#ncjknsjncd'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, "COMMENT", "IF_STATEMENT", "ELIF_STATEMENT", 
			"ELSE_STATEMENT", "WHILE", "FOR", "IN", "OPEN_PAREN", "CLOSE_PAREN", 
			"STRING", "FUNCTION", "ARITHMETIC", "ASSIGNMENT", "CONDITIONAL", "ID", 
			"NUM", "COLON", "NEWLINE", "INDENT", "DEDENT", "SKIP_"
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
	public String getGrammarFileName() { return "Python3.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public Python3Parser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(Python3Parser.EOF, 0); }
		public List<Control_flowContext> control_flow() {
			return getRuleContexts(Control_flowContext.class);
		}
		public Control_flowContext control_flow(int i) {
			return getRuleContext(Control_flowContext.class,i);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(24);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << COMMENT) | (1L << IF_STATEMENT) | (1L << WHILE) | (1L << FOR) | (1L << STRING) | (1L << FUNCTION) | (1L << ID) | (1L << NUM))) != 0)) {
				{
				setState(22);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case IF_STATEMENT:
				case WHILE:
				case FOR:
					{
					setState(20);
					control_flow();
					}
					break;
				case COMMENT:
				case STRING:
				case FUNCTION:
				case ID:
				case NUM:
					{
					setState(21);
					statement();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(26);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(27);
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

	public static class FunctionContext extends ParserRuleContext {
		public TerminalNode FUNCTION() { return getToken(Python3Parser.FUNCTION, 0); }
		public TerminalNode OPEN_PAREN() { return getToken(Python3Parser.OPEN_PAREN, 0); }
		public TerminalNode CLOSE_PAREN() { return getToken(Python3Parser.CLOSE_PAREN, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public FunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function; }
	}

	public final FunctionContext function() throws RecognitionException {
		FunctionContext _localctx = new FunctionContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_function);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(29);
			match(FUNCTION);
			setState(30);
			match(OPEN_PAREN);
			setState(32); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(31);
				expr(0);
				}
				}
				setState(34); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << STRING) | (1L << FUNCTION) | (1L << ID) | (1L << NUM))) != 0) );
			setState(44);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(37); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(36);
					match(T__0);
					}
					}
					setState(39); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==T__0 );
				setState(41);
				expr(0);
				}
				}
				setState(46);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(47);
			match(CLOSE_PAREN);
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

	public static class Control_flowContext extends ParserRuleContext {
		public If_statementContext if_statement() {
			return getRuleContext(If_statementContext.class,0);
		}
		public While_statementContext while_statement() {
			return getRuleContext(While_statementContext.class,0);
		}
		public For_loopContext for_loop() {
			return getRuleContext(For_loopContext.class,0);
		}
		public Control_flowContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_control_flow; }
	}

	public final Control_flowContext control_flow() throws RecognitionException {
		Control_flowContext _localctx = new Control_flowContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_control_flow);
		try {
			setState(52);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IF_STATEMENT:
				enterOuterAlt(_localctx, 1);
				{
				setState(49);
				if_statement();
				}
				break;
			case WHILE:
				enterOuterAlt(_localctx, 2);
				{
				setState(50);
				while_statement();
				}
				break;
			case FOR:
				enterOuterAlt(_localctx, 3);
				{
				setState(51);
				for_loop();
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

	public static class If_statementContext extends ParserRuleContext {
		public TerminalNode IF_STATEMENT() { return getToken(Python3Parser.IF_STATEMENT, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> COLON() { return getTokens(Python3Parser.COLON); }
		public TerminalNode COLON(int i) {
			return getToken(Python3Parser.COLON, i);
		}
		public List<BlockContext> block() {
			return getRuleContexts(BlockContext.class);
		}
		public BlockContext block(int i) {
			return getRuleContext(BlockContext.class,i);
		}
		public TerminalNode OPEN_PAREN() { return getToken(Python3Parser.OPEN_PAREN, 0); }
		public TerminalNode CLOSE_PAREN() { return getToken(Python3Parser.CLOSE_PAREN, 0); }
		public List<TerminalNode> ELIF_STATEMENT() { return getTokens(Python3Parser.ELIF_STATEMENT); }
		public TerminalNode ELIF_STATEMENT(int i) {
			return getToken(Python3Parser.ELIF_STATEMENT, i);
		}
		public If_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_if_statement; }
	}

	public final If_statementContext if_statement() throws RecognitionException {
		If_statementContext _localctx = new If_statementContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_if_statement);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(54);
			match(IF_STATEMENT);
			setState(56);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==OPEN_PAREN) {
				{
				setState(55);
				match(OPEN_PAREN);
				}
			}

			setState(58);
			expr(0);
			setState(60);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==CLOSE_PAREN) {
				{
				setState(59);
				match(CLOSE_PAREN);
				}
			}

			setState(62);
			match(COLON);
			setState(63);
			block();
			setState(71);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(64);
					match(ELIF_STATEMENT);
					setState(65);
					expr(0);
					setState(66);
					match(COLON);
					setState(67);
					block();
					}
					} 
				}
				setState(73);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			}
			setState(76);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				{
				setState(74);
				match(T__1);
				setState(75);
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

	public static class For_loopContext extends ParserRuleContext {
		public TerminalNode FOR() { return getToken(Python3Parser.FOR, 0); }
		public TerminalNode ID() { return getToken(Python3Parser.ID, 0); }
		public TerminalNode IN() { return getToken(Python3Parser.IN, 0); }
		public FunctionContext function() {
			return getRuleContext(FunctionContext.class,0);
		}
		public TerminalNode COLON() { return getToken(Python3Parser.COLON, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public For_loopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_for_loop; }
	}

	public final For_loopContext for_loop() throws RecognitionException {
		For_loopContext _localctx = new For_loopContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_for_loop);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(78);
			match(FOR);
			setState(79);
			match(ID);
			setState(80);
			match(IN);
			setState(81);
			function();
			setState(82);
			match(COLON);
			setState(83);
			block();
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

	public static class While_statementContext extends ParserRuleContext {
		public TerminalNode WHILE() { return getToken(Python3Parser.WHILE, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode COLON() { return getToken(Python3Parser.COLON, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public While_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_while_statement; }
	}

	public final While_statementContext while_statement() throws RecognitionException {
		While_statementContext _localctx = new While_statementContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_while_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(85);
			match(WHILE);
			setState(86);
			expr(0);
			setState(87);
			match(COLON);
			setState(88);
			block();
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

	public static class StatementContext extends ParserRuleContext {
		public TerminalNode NEWLINE() { return getToken(Python3Parser.NEWLINE, 0); }
		public DeclContext decl() {
			return getRuleContext(DeclContext.class,0);
		}
		public TerminalNode COMMENT() { return getToken(Python3Parser.COMMENT, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public FunctionContext function() {
			return getRuleContext(FunctionContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(94);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				{
				setState(90);
				decl();
				}
				break;
			case 2:
				{
				setState(91);
				match(COMMENT);
				}
				break;
			case 3:
				{
				setState(92);
				expr(0);
				}
				break;
			case 4:
				{
				setState(93);
				function();
				}
				break;
			}
			setState(96);
			match(NEWLINE);
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
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public List<Control_flowContext> control_flow() {
			return getRuleContexts(Control_flowContext.class);
		}
		public Control_flowContext control_flow(int i) {
			return getRuleContext(Control_flowContext.class,i);
		}
		public TerminalNode NEWLINE() { return getToken(Python3Parser.NEWLINE, 0); }
		public TerminalNode INDENT() { return getToken(Python3Parser.INDENT, 0); }
		public TerminalNode DEDENT() { return getToken(Python3Parser.DEDENT, 0); }
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_block);
		int _la;
		try {
			setState(112);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case COMMENT:
			case IF_STATEMENT:
			case WHILE:
			case FOR:
			case STRING:
			case FUNCTION:
			case ID:
			case NUM:
				enterOuterAlt(_localctx, 1);
				{
				setState(100);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case COMMENT:
				case STRING:
				case FUNCTION:
				case ID:
				case NUM:
					{
					setState(98);
					statement();
					}
					break;
				case IF_STATEMENT:
				case WHILE:
				case FOR:
					{
					setState(99);
					control_flow();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case NEWLINE:
				enterOuterAlt(_localctx, 2);
				{
				setState(102);
				match(NEWLINE);
				setState(103);
				match(INDENT);
				setState(106); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					setState(106);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case COMMENT:
					case STRING:
					case FUNCTION:
					case ID:
					case NUM:
						{
						setState(104);
						statement();
						}
						break;
					case IF_STATEMENT:
					case WHILE:
					case FOR:
						{
						setState(105);
						control_flow();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					setState(108); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << COMMENT) | (1L << IF_STATEMENT) | (1L << WHILE) | (1L << FOR) | (1L << STRING) | (1L << FUNCTION) | (1L << ID) | (1L << NUM))) != 0) );
				setState(110);
				match(DEDENT);
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

	public static class DeclContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(Python3Parser.ID, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public DeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decl; }
	}

	public final DeclContext decl() throws RecognitionException {
		DeclContext _localctx = new DeclContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_decl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(114);
			match(ID);
			setState(115);
			match(T__2);
			setState(116);
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
		public TerminalNode ID() { return getToken(Python3Parser.ID, 0); }
		public TerminalNode NUM() { return getToken(Python3Parser.NUM, 0); }
		public TerminalNode STRING() { return getToken(Python3Parser.STRING, 0); }
		public FunctionContext function() {
			return getRuleContext(FunctionContext.class,0);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode CONDITIONAL() { return getToken(Python3Parser.CONDITIONAL, 0); }
		public TerminalNode ARITHMETIC() { return getToken(Python3Parser.ARITHMETIC, 0); }
		public TerminalNode ASSIGNMENT() { return getToken(Python3Parser.ASSIGNMENT, 0); }
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
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
			setState(123);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				{
				setState(119);
				match(ID);
				}
				break;
			case NUM:
				{
				setState(120);
				match(NUM);
				}
				break;
			case STRING:
				{
				setState(121);
				match(STRING);
				}
				break;
			case FUNCTION:
				{
				setState(122);
				function();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(136);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(134);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
					case 1:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(125);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(126);
						match(CONDITIONAL);
						setState(127);
						expr(8);
						}
						break;
					case 2:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(128);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(129);
						match(ARITHMETIC);
						setState(130);
						expr(7);
						}
						break;
					case 3:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(131);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(132);
						match(ASSIGNMENT);
						setState(133);
						expr(6);
						}
						break;
					}
					} 
				}
				setState(138);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
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
			return precpred(_ctx, 7);
		case 1:
			return precpred(_ctx, 6);
		case 2:
			return precpred(_ctx, 5);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\32\u008e\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\3\2\3\2\7\2\31\n\2\f\2\16\2\34\13\2\3\2\3\2\3\3\3\3\3\3\6\3#\n\3"+
		"\r\3\16\3$\3\3\6\3(\n\3\r\3\16\3)\3\3\7\3-\n\3\f\3\16\3\60\13\3\3\3\3"+
		"\3\3\4\3\4\3\4\5\4\67\n\4\3\5\3\5\5\5;\n\5\3\5\3\5\5\5?\n\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\7\5H\n\5\f\5\16\5K\13\5\3\5\3\5\5\5O\n\5\3\6\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\5\ba\n\b\3\b\3"+
		"\b\3\t\3\t\5\tg\n\t\3\t\3\t\3\t\3\t\6\tm\n\t\r\t\16\tn\3\t\3\t\5\ts\n"+
		"\t\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\5\13~\n\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\7\13\u0089\n\13\f\13\16\13\u008c\13\13"+
		"\3\13\2\3\24\f\2\4\6\b\n\f\16\20\22\24\2\2\2\u009b\2\32\3\2\2\2\4\37\3"+
		"\2\2\2\6\66\3\2\2\2\b8\3\2\2\2\nP\3\2\2\2\fW\3\2\2\2\16`\3\2\2\2\20r\3"+
		"\2\2\2\22t\3\2\2\2\24}\3\2\2\2\26\31\5\6\4\2\27\31\5\16\b\2\30\26\3\2"+
		"\2\2\30\27\3\2\2\2\31\34\3\2\2\2\32\30\3\2\2\2\32\33\3\2\2\2\33\35\3\2"+
		"\2\2\34\32\3\2\2\2\35\36\7\2\2\3\36\3\3\2\2\2\37 \7\20\2\2 \"\7\r\2\2"+
		"!#\5\24\13\2\"!\3\2\2\2#$\3\2\2\2$\"\3\2\2\2$%\3\2\2\2%.\3\2\2\2&(\7\3"+
		"\2\2\'&\3\2\2\2()\3\2\2\2)\'\3\2\2\2)*\3\2\2\2*+\3\2\2\2+-\5\24\13\2,"+
		"\'\3\2\2\2-\60\3\2\2\2.,\3\2\2\2./\3\2\2\2/\61\3\2\2\2\60.\3\2\2\2\61"+
		"\62\7\16\2\2\62\5\3\2\2\2\63\67\5\b\5\2\64\67\5\f\7\2\65\67\5\n\6\2\66"+
		"\63\3\2\2\2\66\64\3\2\2\2\66\65\3\2\2\2\67\7\3\2\2\28:\7\7\2\29;\7\r\2"+
		"\2:9\3\2\2\2:;\3\2\2\2;<\3\2\2\2<>\5\24\13\2=?\7\16\2\2>=\3\2\2\2>?\3"+
		"\2\2\2?@\3\2\2\2@A\7\26\2\2AI\5\20\t\2BC\7\b\2\2CD\5\24\13\2DE\7\26\2"+
		"\2EF\5\20\t\2FH\3\2\2\2GB\3\2\2\2HK\3\2\2\2IG\3\2\2\2IJ\3\2\2\2JN\3\2"+
		"\2\2KI\3\2\2\2LM\7\4\2\2MO\5\20\t\2NL\3\2\2\2NO\3\2\2\2O\t\3\2\2\2PQ\7"+
		"\13\2\2QR\7\24\2\2RS\7\f\2\2ST\5\4\3\2TU\7\26\2\2UV\5\20\t\2V\13\3\2\2"+
		"\2WX\7\n\2\2XY\5\24\13\2YZ\7\26\2\2Z[\5\20\t\2[\r\3\2\2\2\\a\5\22\n\2"+
		"]a\7\6\2\2^a\5\24\13\2_a\5\4\3\2`\\\3\2\2\2`]\3\2\2\2`^\3\2\2\2`_\3\2"+
		"\2\2ab\3\2\2\2bc\7\27\2\2c\17\3\2\2\2dg\5\16\b\2eg\5\6\4\2fd\3\2\2\2f"+
		"e\3\2\2\2gs\3\2\2\2hi\7\27\2\2il\7\30\2\2jm\5\16\b\2km\5\6\4\2lj\3\2\2"+
		"\2lk\3\2\2\2mn\3\2\2\2nl\3\2\2\2no\3\2\2\2op\3\2\2\2pq\7\31\2\2qs\3\2"+
		"\2\2rf\3\2\2\2rh\3\2\2\2s\21\3\2\2\2tu\7\24\2\2uv\7\5\2\2vw\5\24\13\2"+
		"w\23\3\2\2\2xy\b\13\1\2y~\7\24\2\2z~\7\25\2\2{~\7\17\2\2|~\5\4\3\2}x\3"+
		"\2\2\2}z\3\2\2\2}{\3\2\2\2}|\3\2\2\2~\u008a\3\2\2\2\177\u0080\f\t\2\2"+
		"\u0080\u0081\7\23\2\2\u0081\u0089\5\24\13\n\u0082\u0083\f\b\2\2\u0083"+
		"\u0084\7\21\2\2\u0084\u0089\5\24\13\t\u0085\u0086\f\7\2\2\u0086\u0087"+
		"\7\22\2\2\u0087\u0089\5\24\13\b\u0088\177\3\2\2\2\u0088\u0082\3\2\2\2"+
		"\u0088\u0085\3\2\2\2\u0089\u008c\3\2\2\2\u008a\u0088\3\2\2\2\u008a\u008b"+
		"\3\2\2\2\u008b\25\3\2\2\2\u008c\u008a\3\2\2\2\24\30\32$).\66:>IN`flnr"+
		"}\u0088\u008a";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}