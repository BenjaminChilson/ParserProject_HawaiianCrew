grammar PythonGrammar;

@header {
	package pythonGrammar;
}

/// Java code borrowed from 
/// https://stackoverflow.com/questions/8642154/antlr-what-is-simpliest-way-to-realize-python-like-indent-depending-grammar

@lexer::members {
	private java.util.LinkedList<Token> tokens = new java.util.LinkedList<>();
    // The stack that keeps track of the indentation level.
    private java.util.Stack<Integer> indents = new java.util.Stack<>();
    // The amount of opened braces, brackets and parenthesis.
    private int opened = 0;
    // The most recently produced token.
    private Token lastToken = null;
    @Override
    public void emit(Token t) {
        super.setToken(t);
        tokens.offer(t);
    }

    @Override
    public Token nextToken() {
        // Check if the end-of-file is ahead and there are still some DEDENTS expected.
        if (_input.LA(1) == EOF && !this.indents.isEmpty()) {
            // Remove any trailing EOF tokens from our buffer.
            for (int i = tokens.size() - 1; i >= 0; i--) {
                if (tokens.get(i).getType() == EOF) {
                    tokens.remove(i);
                }
            }

            // First emit an extra line break that serves as the end of the statement.
            this.emit(commonToken(NEWLINE, "\n"));

            // Now emit as much DEDENT tokens as needed.
            while (!indents.isEmpty()) {
                this.emit(createDedent());
                indents.pop();
            }

            // Put the EOF back on the token stream.
            this.emit(commonToken(EOF, "<EOF>"));
        }

        Token next = super.nextToken();

        if (next.getChannel() == Token.DEFAULT_CHANNEL) {
            // Keep track of the last token on the default channel.
            this.lastToken = next;
        }

        return tokens.isEmpty() ? next : tokens.poll();
    }

    private Token createDedent() {
        CommonToken dedent = commonToken(DEDENT, "");
        dedent.setLine(this.lastToken.getLine());
        return dedent;
    }

    private CommonToken commonToken(int type, String text) {
        int stop = this.getCharIndex() - 1;
        int start = text.isEmpty() ? stop : stop - text.length() + 1;
        return new CommonToken(this._tokenFactorySourcePair, type, DEFAULT_TOKEN_CHANNEL, start, stop);
    }

    // Calculates the indentation of the provided spaces, taking the
    // following rules into account:
    //
    // "Tabs are replaced (from left to right) by one to eight spaces
    //  such that the total number of characters up to and including
    //  the replacement is a multiple of eight [...]"
    //
    //  -- https://docs.python.org/3.1/reference/lexical_analysis.html#indentation
    static int getIndentationCount(String spaces) {
        int count = 0;
        for (char ch : spaces.toCharArray()) {
            switch (ch) {
                case '\t':
                    count += 8 - (count % 8);
                    break;
                default:
                    // A normal space char.
                    count++;
            }
        }

        return count;
    }

    boolean atStartOfInput() {
        return super.getCharPositionInLine() == 0 && super.getLine() == 1;
    }

    void openBrace(){
        this.opened++;
    }

    void closeBrace(){
        this.opened--;
    }

    void onNewLine(){
        String newLine = getText().replaceAll("[^\r\n\f]+", "");
        String spaces = getText().replaceAll("[\r\n\f]+", "");

        // Strip newlines inside open clauses except if we are near EOF. We keep NEWLINEs near EOF to
        // satisfy the final newline needed by the single_put rule used by the REPL.
        int next = _input.LA(1);
        int nextnext = _input.LA(2);
        if (opened > 0 || (nextnext != -1 && (next == '\r' || next == '\n' || next == '\f'))) {
            // If we're inside a list or on a blank line, ignore all indents,
            // dedents and line breaks.
            skip();
        }
        else {
            emit(commonToken(NEWLINE, newLine));
            int indent = getIndentationCount(spaces);
            int previous = indents.isEmpty() ? 0 : indents.peek();
            if (indent == previous) {
                // skip indents of the same size as the present indent-size
                skip();
            }
            else if (indent > previous) {
                indents.push(indent);
                emit(commonToken(INDENT, spaces));
            }
            else {
                // Possibly emit more than 1 DEDENT token.
                while(!indents.isEmpty() && indents.peek() > indent) {
                    this.emit(createDedent());
                    indents.pop();
                }
            }
        }
	}
}

prog: (block)? EOF;

function: FUNCTION OPEN_PAREN expr+ (','+expr)* CLOSE_PAREN;

variable_def: ID assignment expr;

control_flow: if_structure | while_statement | for_loop;

if_structure: if_statement (elif_statement)* else_statment?;

if_statement: IF OPEN_PAREN? expr CLOSE_PAREN? COLON block;

elif_statement: ELIF expr COLON block;

else_statment: ELSE COLON block;

for_loop: FOR ID IN function COLON block;

while_statement: WHILE expr COLON block;

comment: COMMENT NEWLINE;

block: ((comment | variable_def | control_flow | statement) NEWLINE?)+ | NEWLINE INDENT (comment | variable_def | control_flow| statement)+ DEDENT;

statement: expr NEWLINE;

expr: expr conditional expr
    | expr arithmetic expr
    | expr assignment expr
    | ID
    | NUM
    | STRING
    | function
    ;

arithmetic: ARITHMETIC;
conditional: CONDITIONAL;
assignment: ASSIGNMENT;

COMMENT: '#' ~[\r\n\f]*;

IF: 'if';
ELIF: 'elif';
ELSE: 'else';
WHILE: 'while';
FOR: 'for';
IN: 'in';

OPEN_PAREN: '(';
CLOSE_PAREN: ')';

STRING : '"' (~('"'))* '"' ;

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

COLON: ':';

NEWLINE
 : ( {atStartOfInput()}?   SPACES
   | ( '\r'? '\n' | '\r' | '\f' ) SPACES?
   )
   {onNewLine();}
 ;

/// Rules don't work when empty, so I had to add some unmatchable string to them
INDENT: 'addu#@#jfn*fsncn#!(#*s';
DEDENT: 'bcsdncd3!#(8!)#ncjknsjncd';

SKIP_
 : ( SPACES | LINE_JOINING | '\n') -> skip
 ;

fragment SPACES: [ \t]+;

fragment LINE_JOINING
 : '\\' SPACES? ( '\r'? '\n' | '\r' | '\f')
 ;