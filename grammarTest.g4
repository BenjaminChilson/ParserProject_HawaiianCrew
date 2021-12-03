grammar grammarTest;
//prule: 'hello' CHAR+;

prule: ifelseelif block+;
if_rule: IF_STATEMENT block?;
elif_rule: ELIF_STATEMENT block?;
else_rule: ELSE_STATEMENT block?;
block: (TAB CHAR+'\n')+;
ifelseelif: if_rule (elif_rule)+(else_rule)?;

prog: (decl | expr)+ EOF;
decl: ID '=' expr;
expr: expr '*' expr
    | expr '/' expr
    | expr '+' expr
    | expr '-' expr
    | ID
    | NUM
    ;

ID: [a-zA-Z][a-zA-Z0-9_]*;
NUM: '0' | '-'?[1-9][0-9]*;
WS: [ \t\n]+ -> skip;
CHAR: 'a'..'z'+(' '('a'..'z')+)*;
TAB: '\t' | '    ';
IF_STATEMENT: 'if''\n';
ELIF_STATEMENT: 'elif''\n';
ELSE_STATEMENT: 'else''\n';