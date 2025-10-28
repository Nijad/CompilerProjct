namespace CompilerProjct.AST.Expressions.Terms
{
    internal class Num : Term
    {
        public string Value { get; set; }
        public Num(string value)
        {
            Value = value;
        }
    }
}
