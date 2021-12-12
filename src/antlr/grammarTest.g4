grammar grammarTest;
//prule: 'hello' CHAR+;

@header{
    package antlr;
}

comment: '#' ~('\n')*;
prule: ifelseelif block+;
controlFlow: ifelseelif;
if_statement: IF expr ':\n' block?;
elif_rule: ELIF expr ':\n' block?;
else_rule: ELSE ':\n' block?;
block: (TAB CHAR+'\n')+;
ifelseelif: if_statement (elif_rule)* (else_rule)?;

prog: (decl | expr)+ EOF;
decl: ID '=' expr;
expr: expr CONDITIONAL expr
    | expr ARITHMETIC expr
    | ID
    | NUM
    ;


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