using Antlr4.Runtime.Misc;
using Antlr4.Runtime.Tree;
using CompilerProjct.AST;
using CompilerProjct.AST.Expressions;

namespace CompilerProjct
{
    public class ToAstVisitor : SCP601BaseVisitor<AstNode>
    {

        //PROGRAM IDENTIFIER LBRACE MEMBER* RBRACE EOF
        public override AstNode VisitProgram([NotNull] SCP601Parser.ProgramContext context)
        {
            Expression expression = (Expression) context.Accept(this);
            return new AST.Program(expression);
        }

        public override AstNode VisitChildren(IRuleNode node)
        {
            return base.VisitChildren(node);
        }

        public override AstNode VisitTerminal(ITerminalNode node)
        {
            return base.VisitTerminal(node);
        }

        public  override AstNode VisitErrorNode(IErrorNode node)
        {
            return base.VisitErrorNode(node);
        }

        public override AstNode VisitMember([NotNull] SCP601Parser.MemberContext context)
        {
            // For now, only handle function members
            if (context.function() != null)
            {
                return Visit(context.function());
            }
            return null;
        }

        public override AstNode VisitFunction([NotNull] SCP601Parser.FunctionContext context)
        {
            // Implementation for function AST node creation goes here
            // For now, return null or a placeholder
            return null;
        }

        public override AstNode VisitArguments([NotNull] SCP601Parser.ArgumentsContext context)
        {
            // Implementation for arguments AST node creation goes here
            // For now, return null or a placeholder
            return null;
        }

        public override AstNode VisitArgument([NotNull] SCP601Parser.ArgumentContext context)
        {
            // Implementation for argument AST node creation goes here
            // For now, return null or a placeholder
            return null;
        }

        public override AstNode VisitStruct([NotNull] SCP601Parser.StructContext context)
        {
            // Implementation for struct AST node creation goes here
            // For now, return null or a placeholder
            return null;
        }

        public override AstNode VisitStruct_members([NotNull] SCP601Parser.Struct_membersContext context)
        {
            // Implementation for struct members AST node creation goes here
            // For now, return null or a placeholder
            return null;
        }

        public override AstNode VisitGlobal([NotNull] SCP601Parser.GlobalContext context)
        {
            return base.VisitGlobal(context);
        }

        public override AstNode VisitVariables([NotNull] SCP601Parser.VariablesContext context)
        {
            return base.VisitVariables(context);
        }

        public override AstNode VisitVariable([NotNull] SCP601Parser.VariableContext context)
        {
            return base.VisitVariable(context);
        }

        public override AstNode VisitType([NotNull] SCP601Parser.TypeContext context)
        {
            return base.VisitType(context);
        }

        public override AstNode VisitExpr_list([NotNull] SCP601Parser.Expr_listContext context)
        {
            return base.VisitExpr_list(context);
        }
    }
}
