using CompilerProjct.AST.Expressions;

namespace CompilerProjct.AST
{
    public class Program : AstNode
    {
        public Expression Expression { get; set; }
        public Program(Expression expressions)
        {
            Expression = expressions;
        }
    }
}
