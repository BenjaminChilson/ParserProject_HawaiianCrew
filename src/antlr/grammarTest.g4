/* ANTLR4 Grammar for Python 3
 * Principles of Programming Hawaiian Crew:
 * Ben Chilson, Matt Hackmann, and Nate Beattie
*/
grammar grammartest;

@header{
    package antlr;
}


IF_STATEMENT: 'if';
ELIF_STATEMENT: 'elif';
ELSE_STATEMENT: 'else';
PRINT_STATEMENT: 'print';

OPERATOR: '*'
        | '/'
        | '+'
        | '-'
        | '%'
        ;
COMPARISON: '=='
          | '>'
          | '>='
          | '<'
          | '<='
          ;
ID: [a-zA-Z][a-zA-Z0-9_]*;
NUM: '0' | '-'?[1-9][0-9]*;
WS: [ \t\n]+ -> skip;
CHAR: 'a'..'z'+(('a'..'z')+)*;
TAB: '\t' | '    ';
// Trying to figure out how to accept both cases: if(condition): and if condition:
OPEN_PAREN: '(';
CLOSE_PAREN: ')';

QUOTE: '"'|'\'';
STRING_LIT: QUOTE ID QUOTE;
// What is valid inside a print().
PRINT_STRING: STRING_LIT | ID;
// Basic rule for print statements.
print_rule: PRINT_STATEMENT OPEN_PAREN? PRINT_STRING CLOSE_PAREN?;
prule: ifelseelif block+;
controlFlow: ifelseelif;
loop: ;
if_rule: IF_STATEMENT OPEN_PAREN? expr CLOSE_PAREN? ':\n' block?;
elif_rule: ELIF_STATEMENT expr ':\n' block?;
else_rule: ELSE_STATEMENT ':\n' block?;

block: (TAB CHAR+'\n')+;
ifelseelif: if_statement (elif_rule)* (else_rule)?;


prog: (decl | expr | controlFlow | statement)+ EOF;

decl: ID '=' expr;
expr: expr CONDITIONAL expr
    | expr ARITHMETIC expr
    | ID
    | NUM
    ;


// Work in progress
statement: print_rule;

IF: 'if';
ELIF: 'elif';
ELSE: 'else';
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
CHAR: 'a'..'z'+(' '('a'..'z')+)*;
COMMENT: '#' ~('\n')* -> skip;
NL: '\n' -> skip;
WS: [ \t\n] -> skip;
TAB: '\t' | '    ';

