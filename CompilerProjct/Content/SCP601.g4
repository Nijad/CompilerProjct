grammar SCP601;

// Lexer Rules
WS: [ \t\r\n]+ -> skip;
TAB: '\t' -> skip;
ENTER: '\r'? '\n' -> skip;

COMMENT: '{*' .*? '*}' -> skip;
LINE_COMMENT: '//' ~[\r\n]* -> skip;

// Keywords
BOOLEAN: 'boolean';
DOUBLE: 'double';
INT: 'int';
IF: 'if';
ELSE: 'else';
WHILE: 'while';
FOR: 'for';
FALSE: 'false';
TRUE: 'true';
NULL: 'null';
VOID: 'void';
ARRAY: 'array';
CLASS: 'class';
PROGRAM: 'program';
STRUCT: 'struct';
STATIC: 'static';
RETURN: 'return';
WITH: 'with';

// Operators
PLUS: '+';
MINUS: '-';
MULT: '*';
DIV: '/';
MOD: '%';
ASSIGN: '=';
EQ: '==';
NEQ: '!=';
LT: '<';
LE: '<=';
GT: '>';
GE: '>=';
AND: '&&';
OR: '||';
NOT: '!';
INCREMENT: '++';
DECREMENT: '--';

// Identifiers and literals
IDENTIFIER: [a-zA-Z][a-zA-Z0-9_]*;
INTEGER: [0-9]| [1-9][0-9]+;
REAL:
	[0-9]+ '.' [0-9]* ([eE] [+-]? [0-9]+)?
	| '.' [0-9]+ ([eE] [+-]? [0-9]+)?
	| [0-9]+ [eE] [+-]? [0-9]+;

// Punctuation
LPAREN: '(';
RPAREN: ')';
LBRACE: '{';
RBRACE: '}';
SEMI: ';';
COMMA: ',';
DOT: '.';
COLON: ':';

// Parser Rules
program: entry;

entry: PROGRAM IDENTIFIER LBRACE member* RBRACE EOF;

member: function | struct | global;

function: (type | VOID) IDENTIFIER LPAREN arguments? RPAREN LBRACE statement* RBRACE;

arguments: argument (COMMA argument)*;
argument: type IDENTIFIER;

struct:
	STRUCT IDENTIFIER (COLON IDENTIFIER)? LBRACE struct_members RBRACE;
struct_members: (STATIC? type variable SEMI)*;

global: type variables SEMI;
variables: variable (COMMA variable)*;
variable: IDENTIFIER | IDENTIFIER ASSIGN expression;

type: BOOLEAN | INT | DOUBLE | IDENTIFIER;

expression:
	expression DOT IDENTIFIER						# dotIdentifierExpression
	| expression DOT IDENTIFIER ASSIGN expression	# dotIdentifierAssignExpression
	| IDENTIFIER LPAREN expr_list? RPAREN			# functionCallExpression
	| expression multypleOp expression				# multiplicativeExpression
	| expression additiveOp expression				# additiveExpression
	| expression compareOp expression				# comparisonExpression
	| expression logicalOp expression				# logicalExpression
	| INTEGER										# integerExpression
	| REAL											# realExpression
	| TRUE											# trueExpression
	| FALSE											# falseExpression
	| NULL											# nullExpression
	| IDENTIFIER									# identifierExpression
	| IDENTIFIER ASSIGN expression					# identifierAssignExpression
	| LPAREN expression RPAREN						# parenthesizedExpression
	| unaryOp expression							# unaryExpression
	| expression (INCREMENT | DECREMENT)			# postFixExpression
	| (INCREMENT | DECREMENT) expression			# preFixExpression;

expr_list: expression (COMMA expression)*;

unaryOp: PLUS | MINUS | NOT;

multypleOp: MULT | DIV | MOD;

additiveOp: PLUS | MINUS;

compareOp: EQ | NEQ | LT | LE | GT | GE;

logicalOp: AND | OR;

statement:
	IF LPAREN expression RPAREN statement											# ifStatement
	| IF LPAREN expression RPAREN statement ELSE statement							# ifElseStatement
	| WHILE LPAREN expression RPAREN statement										# whileStatement
	| FOR LPAREN type variables SEMI expression? SEMI expression? RPAREN statement	# forStatement
	| WITH LPAREN IDENTIFIER RPAREN statement										# withStatement
	| expression SEMI																# expressionStatement
	| type variables SEMI															# variableDeclarationStatement
	| SEMI																			# emptyStatement
	| LBRACE statement* RBRACE														# blockStatement
	| RETURN expression? SEMI														# returnStatement;