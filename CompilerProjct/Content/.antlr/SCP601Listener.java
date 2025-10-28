// Generated from c:/Users/nijad/source/repos/Nijad/CompilerProjct/CompilerProjct/Content/SCP601.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link SCP601Parser}.
 */
public interface SCP601Listener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link SCP601Parser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(SCP601Parser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link SCP601Parser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(SCP601Parser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link SCP601Parser#member}.
	 * @param ctx the parse tree
	 */
	void enterMember(SCP601Parser.MemberContext ctx);
	/**
	 * Exit a parse tree produced by {@link SCP601Parser#member}.
	 * @param ctx the parse tree
	 */
	void exitMember(SCP601Parser.MemberContext ctx);
	/**
	 * Enter a parse tree produced by {@link SCP601Parser#function}.
	 * @param ctx the parse tree
	 */
	void enterFunction(SCP601Parser.FunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SCP601Parser#function}.
	 * @param ctx the parse tree
	 */
	void exitFunction(SCP601Parser.FunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SCP601Parser#arguments}.
	 * @param ctx the parse tree
	 */
	void enterArguments(SCP601Parser.ArgumentsContext ctx);
	/**
	 * Exit a parse tree produced by {@link SCP601Parser#arguments}.
	 * @param ctx the parse tree
	 */
	void exitArguments(SCP601Parser.ArgumentsContext ctx);
	/**
	 * Enter a parse tree produced by {@link SCP601Parser#argument}.
	 * @param ctx the parse tree
	 */
	void enterArgument(SCP601Parser.ArgumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link SCP601Parser#argument}.
	 * @param ctx the parse tree
	 */
	void exitArgument(SCP601Parser.ArgumentContext ctx);
	/**
	 * Enter a parse tree produced by {@link SCP601Parser#struct}.
	 * @param ctx the parse tree
	 */
	void enterStruct(SCP601Parser.StructContext ctx);
	/**
	 * Exit a parse tree produced by {@link SCP601Parser#struct}.
	 * @param ctx the parse tree
	 */
	void exitStruct(SCP601Parser.StructContext ctx);
	/**
	 * Enter a parse tree produced by {@link SCP601Parser#struct_members}.
	 * @param ctx the parse tree
	 */
	void enterStruct_members(SCP601Parser.Struct_membersContext ctx);
	/**
	 * Exit a parse tree produced by {@link SCP601Parser#struct_members}.
	 * @param ctx the parse tree
	 */
	void exitStruct_members(SCP601Parser.Struct_membersContext ctx);
	/**
	 * Enter a parse tree produced by {@link SCP601Parser#global}.
	 * @param ctx the parse tree
	 */
	void enterGlobal(SCP601Parser.GlobalContext ctx);
	/**
	 * Exit a parse tree produced by {@link SCP601Parser#global}.
	 * @param ctx the parse tree
	 */
	void exitGlobal(SCP601Parser.GlobalContext ctx);
	/**
	 * Enter a parse tree produced by {@link SCP601Parser#variables}.
	 * @param ctx the parse tree
	 */
	void enterVariables(SCP601Parser.VariablesContext ctx);
	/**
	 * Exit a parse tree produced by {@link SCP601Parser#variables}.
	 * @param ctx the parse tree
	 */
	void exitVariables(SCP601Parser.VariablesContext ctx);
	/**
	 * Enter a parse tree produced by {@link SCP601Parser#variable}.
	 * @param ctx the parse tree
	 */
	void enterVariable(SCP601Parser.VariableContext ctx);
	/**
	 * Exit a parse tree produced by {@link SCP601Parser#variable}.
	 * @param ctx the parse tree
	 */
	void exitVariable(SCP601Parser.VariableContext ctx);
	/**
	 * Enter a parse tree produced by {@link SCP601Parser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(SCP601Parser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link SCP601Parser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(SCP601Parser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link SCP601Parser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(SCP601Parser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SCP601Parser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(SCP601Parser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SCP601Parser#expr_list}.
	 * @param ctx the parse tree
	 */
	void enterExpr_list(SCP601Parser.Expr_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link SCP601Parser#expr_list}.
	 * @param ctx the parse tree
	 */
	void exitExpr_list(SCP601Parser.Expr_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link SCP601Parser#binaryOp}.
	 * @param ctx the parse tree
	 */
	void enterBinaryOp(SCP601Parser.BinaryOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link SCP601Parser#binaryOp}.
	 * @param ctx the parse tree
	 */
	void exitBinaryOp(SCP601Parser.BinaryOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link SCP601Parser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(SCP601Parser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SCP601Parser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(SCP601Parser.StatementContext ctx);
}