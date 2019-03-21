package func.compiler;

import java.io.*;

%%

%class Lexer

%{
  enum Yytoken{
    SEMI, COMMA, ASSIGN, IF, THEN, ELSE, ENDIF, BEGIN, METHOD, RETURN, ENDWHILE, ENDMETHOD, WHILE, INPUT, READ, WRITE, 
    PRINT, VARS, LBRA, RBRA, LT, LTE, EQ, NEQ, INT, ID, EOF
  }

%}

DIGIT = [0-9]
IDENT = [a-zA-Z][A-Za-z0-9]*

%%

";"   { return Yytoken.SEMI;}
","   { return Yytoken.COMMA;}
":="  { return Yytoken.ASSIGN;}
"if"  { return Yytoken.IF;}
"then"  { return Yytoken.THEN;}
"else"  { return Yytoken.ELSE;}
"endif" { return Yytoken.ENDIF;}
"begin" { return Yytoken.BEGIN;}
"method" { return Yytoken.METHOD;}
"return" { return Yytoken.RETURN;}
"endwhile" { return Yytoken.ENDWHILE;}
"endmethod" { return Yytoken.ENDMETHOD;}
"while" { return Yytoken.WHILE;} 
"input" { return Yytoken.INPUT;}  
"read" { return Yytoken.READ;}
"write" { return Yytoken.WRITE;} 
"print" { return Yytoken.PRINT;} 
"vars"   { return Yytoken.VARS;}
"("   { return Yytoken.LBRA;}
")"   { return Yytoken.RBRA;}
"less"   { return Yytoken.LT;}
"lessEq"  { return Yytoken.LTE;}
"eq"  { return Yytoken.EQ;}
"nEq"  { return Yytoken.NEQ;}
{DIGIT}+ { return Yytoken.INT;}
{IDENT}         { return Yytoken.ID;}
<<EOF>>         { return Yytoken.EOF;}
[\ \t\b\f\r\n]+ { /* eat whitespace */ }
.               { throw new Error("Unexpected character ["+yytext()+"]"); }