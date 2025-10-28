## Purpose
This file gives concise, actionable guidance for AI coding agents working on this repository. Focus on the single ANTLR grammar in `Content/SCP601.g4`, language conventions, where to change behavior, and how to generate parsers.

## Where to look
- Primary grammar: `Content/SCP601.g4` — contains both lexer and parser rules.

## Big picture (what the repo is)
- This repo currently contains one ANTLR v4 grammar (SCP601). The grammar defines the whole language (tokens + parser rules). There is no detected build script or project file in the repository (no `pom.xml`, `.sln`, `.csproj`, `package.json`, `build.gradle`, or `Makefile`).

## Important grammar-level details and conventions
- Lexer and parser live in one file: `SCP601.g4`.
- Token naming: uppercase token names (e.g. `IDENTIFIER`, `INTEGER`, `REAL`, `WS`) are used for lexer rules. Parser rules are lowercase (e.g. `program`, `function`, `expression`).
- Skipped tokens: `WS`, `TAB`, `ENTER`, `COMMENT`, `LINE_COMMENT` use `-> skip` — maintain these when editing to avoid noise tokens.
- Comment styles supported: block `(* ... *)` and line `// ...` (both skipped).
- Root entry: `program` (rule: `program: PROGRAM IDENTIFIER LBRACE member* RBRACE EOF;`).

## Key language constructs (examples from grammar)
- Program header: `program MyProg { ... }`.
- Function signature: `(type | VOID) IDENTIFIER LPAREN arguments? RPAREN { ... }` — example: `int foo(int x) { return x; }`.
- Structs: `struct Name ( : Parent )? { ... }` with `STATIC? type variable ;` members.
- Globals: `type variables ;` where `variable` is `IDENTIFIER` or `IDENTIFIER = expression`.
- Expressions: function calls `IDENTIFIER(expr_list?)`, field access `expr.DOT IDENTIFIER`, binary ops (EQ, NEQ, LT, GT, +, -, *, /, %), unary +/- and assignment `IDENTIFIER = expression`.

## Patterns and pitfalls for editing
- Expression rule contains several alternatives including left-recursive-style constructs; be careful when refactoring — preserve the order and alternatives to avoid changing parse behavior.
- Keep token names stable when other tooling or generated code depends on them (e.g., `IDENTIFIER`, `INTEGER`, `REAL`, `TRUE`, `FALSE`, `NULL`).
- When adding keywords, prefer adding a new lexer rule with the exact case used in the file (e.g., `BOOLEAN: 'Boolean';`) and add parser rules that use the token name, not literal strings.

## Integration & build notes (discoverable/assumed)
- No build definition was found in the repo. The most likely next step for developers is generating parser/lexer code from `SCP601.g4` with ANTLR4. Examples below use the ANTLR jar and PowerShell (Windows):

```powershell
java -jar antlr-4.9.2-complete.jar -Dlanguage=Java -o gen Content\SCP601.g4

java -jar antlr-4.9.2-complete.jar -Dlanguage=CSharp -o gen Content\SCP601.g4
```

Note: the repo does not include the ANTLR jar or a build file; confirm the target language (Java, C#, etc.) before generating code. If you want, I can add example build files (Maven, .NET) once you tell me the target platform.

## Tests, CI, debugging
- No tests or CI configuration found. For parser debugging, generate the parser with ANTLR then run small sample programs (use the `program ... { }` header) to exercise rules.

## Files to change for language updates
- Edit `Content/SCP601.g4` for grammar changes.
- If parser code is generated into `gen/` or a `src/` folder, update the generated code only via regeneration — avoid hand-editing generated files.

## Examples you can copy while coding agents
- Add a tiny test file to validate parsing: create `examples/hello.spc` with:

```
program Hello {
  int main() {
    return 0;
  }
}
```

Then generate the parser and run a small harness that parses `examples/hello.spc` to confirm no grammar regressions.

## If you need more context
- Tell me which target language/runtime you plan to use for generated parser code (Java, C#, Python, etc.). I can then:
  - Add a small build file (Maven, .NET, or a Python runner)
  - Generate the parser into a `gen/` directory and add a minimal test harness

## Feedback request
If any of the above assumptions are incorrect (target language, desired build tooling, or additional source files not indexed here), please tell me and I will update this guidance. 
