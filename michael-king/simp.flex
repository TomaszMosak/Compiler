package simp.compiler;

import java.io.*;

%%

%class Lexer

%{
  enum Yytoken{
    SEMI, ASSIGN, IF, THEN, ELSE, 
    BEGIN, END, WHILE, DO, PLUS, MINUS, INPUT, 
    PRINT, VAR, STAR, SLASH, LBRA, RBRA, LT, LTE,
    EQ, NEQ, GT, GTE, INT, ID, EOF
  }

%}

DIGIT = [0-9]
IDENT = [a-zA-Z][A-Za-z0-9]*

%%

";"   { return Yytoken.SEMI;}
":="  { return Yytoken.ASSIGN;}
";"   { return Yytoken.SEMI;}
":="  { return Yytoken.ASSIGN;}
"IF"  { return Yytoken.IF;}
"THEN"  { return Yytoken.THEN;}
"ELSE"  { return Yytoken.ELSE;}
"BEGIN" { return Yytoken.BEGIN;}
"END" { return Yytoken.END;}
"WHILE" { return Yytoken.WHILE;}
"DO"  { return Yytoken.DO;}
"+"   {return Yytoken.PLUS;}
"-" { return Yytoken.MINUS;}  
"INPUT" { return Yytoken.INPUT;}  
"PRINT" { return Yytoken.PRINT;} 
"VAR"   { return Yytoken.VAR;}
"*"   { return Yytoken.STAR;}
"/"   { return Yytoken.SLASH;}
"("   { return Yytoken.LBRA;}
")"   { return Yytoken.RBRA;}
"<"   { return Yytoken.LT;}
"<="  { return Yytoken.LTE;}
"=="  { return Yytoken.EQ;}
"!="  { return Yytoken.NEQ;}
">"   { return Yytoken.GT;}
">="  { return Yytoken.GTE;}
{DIGIT}+ { return Yytoken.INT;}
{IDENT}         { return Yytoken.ID;}
<<EOF>>         { return Yytoken.EOF;}
[\ \t\b\f\r\n]+ { /* eat whitespace */ }
.               { throw new Error("Unexpected character ["+yytext()+"]"); }
