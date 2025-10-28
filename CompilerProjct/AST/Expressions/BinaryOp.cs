namespace CompilerProjct.AST.Expressions
{
    public class BinaryOp : Expression
    {
        public Expression Left { get; set; }
        public Expression Right { get; set; }
        public string Op { get; set; }
        public BinaryOp(Expression left, Expression right, string op)
        {
            Left = left;
            Right = right;
            Op = op;
        }
    }
}
