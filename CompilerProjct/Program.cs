using Antlr4.Runtime;

namespace CompilerProjct
{
    public class Program
    {
        static void Main(string[] args)
        {
            
            var fileContents = File.ReadAllText(args[0]);
            Console.WriteLine("Input: " + fileContents);
            var inputStream = CharStreams.fromString(fileContents);
            var lexer = new SCP601Lexer(inputStream);
            var errorListener = new Content.ParserErrorListener();
            var tokenStream = new CommonTokenStream(lexer);
            var parser = new SCP601Parser(tokenStream);
            parser.RemoveErrorListeners();
            parser.AddErrorListener(errorListener);
            var parseTree = parser.program();
            Console.WriteLine("Parse Tree: " + parseTree.ToStringTree(parser));
            if (parseTree == null)
            {
                Console.WriteLine("Parse tree is null. Check the parser.");
                return;
            }
            Console.WriteLine("Parse Tree: " + parseTree.ToString());
            errorListener.StopIfErrors();

            var ast = parseTree.Accept(new ToAstVisitor());
            if(ast == null)
            {
                Console.WriteLine("AST is null. Check toAstVisitor.");
                return;
            }
            Console.WriteLine("AST: " + ast);

            var interpreter = new Interpreter();
            var finalValue = interpreter.EvaluateProgram(ast as AST.Program);
            Console.WriteLine("Final Value: " + finalValue);
            Console.ReadLine();
        }
    }
}
