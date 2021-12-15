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
// Parse functions like range(0,6) and str(integer).
function: FUNCTION OPEN_PAREN expr+ (','+expr)* CLOSE_PAREN ;
// Loops.
while_loop: WHILE expr ('and' expr)* COLON block;
for_loop: FOR ID IN function COLON block;
loop: while_loop | for_loop;

// Rule for entire python program
program: (expr | comment | loop | if_rule)+ EOF;
expr: expr ARITHMETIC expr
    | expr CONDITIONAL expr
    | expr ASSIGNMENT expr
    | ID
    | NUM
    | STRING
    | function
    ;
// RULES in progress:
if_rule: IF_STATEMENT OPEN_PAREN? expr CLOSE_PAREN? COLON  block?;
elif_rule: ELIF_STATEMENT expr COLON  block?;
else_rule: ELSE_STATEMENT COLON  block?;
prule: ifelseelif block+;
controlFlow: ifelseelif;


block: (TAB expr)+;
ifelseelif: if_rule (elif_rule)* (else_rule)?;

// LEXER RULES:
COMMENT: '#' ~('\n' )+;
IF_STATEMENT: 'if';
ELIF_STATEMENT: 'elif';
ELSE_STATEMENT: 'else';
WHILE: 'while';
FOR: 'for';
IN: 'in';
// 3 Functions used in the test code
FUNCTION: 'print' | 'range' | 'str' | 'int';

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
            | '!='
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

STRING : '"' (~('"'))* '"' ;

WHITESPACE: ' ' -> skip;
COLON: ':';
NEWLINE: '\n' -> skip;
// Catchall rule
ANY: . ;
