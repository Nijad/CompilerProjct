namespace CompilerProjct.AST.Expressions
{
    public class UnaryOp : Expression
    {
        public Expression Exepression { get; set; }
        public string Op { get; set; }

        public UnaryOp(Expression expression, string op)
        {
            Exepression = expression;
            Op = op;
        }
    }
}
