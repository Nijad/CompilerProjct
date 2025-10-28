namespace CompilerProjct.AST
{
    public abstract class AstNode
    {
        public int LineNum { get; set; }
        public int ColumnNum { get; set; } = 0;
    }
}
