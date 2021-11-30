grammar grammarTest;
//prule: 'hello' CHAR+;
CHAR: 'a'..'z'+(' '('a'..'z')+)*;
TAB: '\t' | '    ';
IF_STATEMENT: 'if''\n';
prule: IF_STATEMENT block+;
block: (TAB CHAR+'\n')+;