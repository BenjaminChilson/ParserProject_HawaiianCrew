// Generated from ./grammar/grammarTest.g4 by ANTLR 4.9.2

    package antlr;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link grammarTestParser}.
 */
public interface grammarTestListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link grammarTestParser#prule}.
	 * @param ctx the parse tree
	 */
	void enterPrule(grammarTestParser.PruleContext ctx);
	/**
	 * Exit a parse tree produced by {@link grammarTestParser#prule}.
	 * @param ctx the parse tree
	 */
	void exitPrule(grammarTestParser.PruleContext ctx);
	/**
	 * Enter a parse tree produced by {@link grammarTestParser#controlFlow}.
	 * @param ctx the parse tree
	 */
	void enterControlFlow(grammarTestParser.ControlFlowContext ctx);
	/**
	 * Exit a parse tree produced by {@link grammarTestParser#controlFlow}.
	 * @param ctx the parse tree
	 */
	void exitControlFlow(grammarTestParser.ControlFlowContext ctx);
	/**
	 * Enter a parse tree produced by {@link grammarTestParser#if_statement}.
	 * @param ctx the parse tree
	 */
	void enterIf_statement(grammarTestParser.If_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link grammarTestParser#if_statement}.
	 * @param ctx the parse tree
	 */
	void exitIf_statement(grammarTestParser.If_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link grammarTestParser#elif_rule}.
	 * @param ctx the parse tree
	 */
	void enterElif_rule(grammarTestParser.Elif_ruleContext ctx);
	/**
	 * Exit a parse tree produced by {@link grammarTestParser#elif_rule}.
	 * @param ctx the parse tree
	 */
	void exitElif_rule(grammarTestParser.Elif_ruleContext ctx);
	/**
	 * Enter a parse tree produced by {@link grammarTestParser#else_rule}.
	 * @param ctx the parse tree
	 */
	void enterElse_rule(grammarTestParser.Else_ruleContext ctx);
	/**
	 * Exit a parse tree produced by {@link grammarTestParser#else_rule}.
	 * @param ctx the parse tree
	 */
	void exitElse_rule(grammarTestParser.Else_ruleContext ctx);
	/**
	 * Enter a parse tree produced by {@link grammarTestParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(grammarTestParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link grammarTestParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(grammarTestParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link grammarTestParser#ifelseelif}.
	 * @param ctx the parse tree
	 */
	void enterIfelseelif(grammarTestParser.IfelseelifContext ctx);
	/**
	 * Exit a parse tree produced by {@link grammarTestParser#ifelseelif}.
	 * @param ctx the parse tree
	 */
	void exitIfelseelif(grammarTestParser.IfelseelifContext ctx);
	/**
	 * Enter a parse tree produced by {@link grammarTestParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(grammarTestParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link grammarTestParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(grammarTestParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by {@link grammarTestParser#decl}.
	 * @param ctx the parse tree
	 */
	void enterDecl(grammarTestParser.DeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link grammarTestParser#decl}.
	 * @param ctx the parse tree
	 */
	void exitDecl(grammarTestParser.DeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link grammarTestParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(grammarTestParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link grammarTestParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(grammarTestParser.ExprContext ctx);
}