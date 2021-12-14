grammar grammarTest;
//prule: 'hello' CHAR+;

tokens { INDENT, DEDENT }

@header{
    package antlr;
}

@lexer::members {

      private java.util.LinkedList<Token> tokens = new java.util.LinkedList<>();

      private java.util.Stack<Integer> indents = new java.util.Stack<>();

      private int opened = 0;

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
          if (opened > 0 || (nextnext != -1 && (next == '\r' || next == '\n' || next == '\f' || next == '#'))) {
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

// more parser rules

SKIP_
 : ( SPACES | COMMENT | LINE_JOINING ) -> skip
 ;

NEWLINE
 : ( {atStartOfInput()}?   SPACES
   | ( '\r'? '\n' | '\r' | '\f' ) SPACES?
   )
   {onNewLine();}
 ;

prule: ifelseelif block+;
controlFlow: ifelseelif;
if_statement: IF expr ':\n' block?;
elif_rule: ELIF expr ':\n' block?;
else_rule: ELSE ':\n' block?;
block: (TAB CHAR+'\n')+ | INDENT controlFlow;
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
OPEN_BRACE : '{' {openBrace();};
CLOSE_BRACE : '}' {closeBrace();};
OPEN_BRACK : '[' {openBrace();};
CLOSE_BRACK : ']' {closeBrace();};
OPEN_PAREN : '(' {openBrace();};
CLOSE_PAREN : ')' {closeBrace();};


fragment SPACES
 : [ \t]+
 ;
 fragment LINE_JOINING
  : '\\' SPACES? ( '\r'? '\n' | '\r' | '\f')
  ;


WS: [ \t\n] -> skip;
TAB: '\t' | '    ';

