namespace CompilerProjct.AST.Expressions.Terms
{
    public class Bool: Term
    {
        public string Value { get; set; }
        public Bool(string value)
        {
            Value = value;
        }
    }
}
