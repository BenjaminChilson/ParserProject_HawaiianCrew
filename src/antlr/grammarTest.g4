grammar grammarTest;
//prule: 'hello' CHAR+;

@header{
    package antlr;
}

comments_rule: '#' ~('\n')* '\n'?;

prule: ifelseelif block+;
controlFlow: ifelseelif;
loop: ;
if_rule: IF_STATEMENT expr ':\n' block?;
elif_rule: ELIF_STATEMENT expr ':\n' block?;
else_rule: ELSE_STATEMENT ':\n' block?;
block: (TAB CHAR+'\n')+;
ifelseelif: if_rule (elif_rule)* (else_rule)?;

prog: (decl | expr | controlFlow | comments_rule)+ EOF;
decl: ID '=' expr;
expr: expr OPERATOR expr
    | expr COMPARISON expr
    | ID
    | NUM
    ;


IF_STATEMENT: 'if';
ELIF_STATEMENT: 'elif';
ELSE_STATEMENT: 'else';
OPERATOR: '*'
        | '/'
        | '+'
        | '-'
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
CHAR: 'a'..'z'+(' '('a'..'z')+)*;
TAB: '\t' | '    ';
ANY_CHAR: .;