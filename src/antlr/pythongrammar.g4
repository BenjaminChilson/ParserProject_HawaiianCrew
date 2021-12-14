/* ANTLR4 Grammar for Python 3
 * Principles of Programming Hawaiian Crew:
 * Ben Chilson, Matt Hackmann, and Nate Beattie
*/
grammar pythongrammar;

@header{
    package antlr;
}

// PARSER RULES:
comment: COMMENT ;
// Parse functions like range(0,6) and str(integer). cases such as print(str(integer)) do not parse correctly
function: FUNCTION OPEN_PAREN expr+ (','+expr)* CLOSE_PAREN ;
if_rule: IF_STATEMENT OPEN_PAREN? expr CLOSE_PAREN? COLON  block?;
elif_rule: ELIF_STATEMENT expr COLON  block?;
else_rule: ELSE_STATEMENT COLON  block?;

// Rule for entire python program
program: (expr | comment)+ EOF;
expr: expr ARITHMETIC expr
    | expr CONDITIONAL expr
    | expr ASSIGNMENT expr
    | ID
    | NUM
    | STRING
    | function
    ;
// RULES in progress:
prule: ifelseelif block+;
controlFlow: ifelseelif;
loop: ;

block: (TAB CHAR+ NEWLINE)+;
ifelseelif: if_rule (elif_rule)* (else_rule)?;

// LEXER RULES:
COMMENT: '#' ~('\n' )+;
IF_STATEMENT: 'if';
ELIF_STATEMENT: 'elif';
ELSE_STATEMENT: 'else';
// 3 Functions used in the test code
FUNCTION: 'print' | 'range' | 'str';

ARITHMETIC  : '*'
            | '/'
            | '+'
            | '-'
            | '%'
            | '^'
            ;
ASSIGNMENT  : '='
            | '+='
            | '-='
            | '*='
            | '/='
            | '^='
            | '%='
            ;
CONDITIONAL : '=='
            | '>'
            | '>='
            | '<'
            | '<='
            | 'and'
            | 'or'
            | 'not'
            ;
ID: [a-zA-Z][a-zA-Z0-9_]*;
NUM: '0' | '-'?[1-9][0-9]*;
CHAR: 'a'..'z'+(('a'..'z')+)*;
TAB: '\t' | '    ';
OPEN_PAREN: '(';
CLOSE_PAREN: ')';

QUOTE: '"'|'\'';
STRING: QUOTE [\u0000-\u00FF]* QUOTE;
WHITESPACE: ' ' -> skip;
COLON: ':';
NEWLINE: '\n' -> skip;
// Catchall rule
ANY: . ;
