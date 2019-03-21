package func.compiler;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Parser {
	Lexer l;
	Lexer.Yytoken symb;

	public Parser(String fname) throws Exception {
		l = new Lexer(new InputStreamReader(new FileInputStream(fname), "Cp1252"));
		lex();
	}

	private void advance(Lexer.Yytoken tok) throws Exception {
		System.out.println("Advancing " + tok);
		if (symb == tok)
			symb = l.yylex();
		else
			throw new Exception("Parser error : expected " + tok + " but is " + symb + " --> " + l.yytext());
	}

	public void lex() throws Exception {
		symb = l.yylex();
	}

	private String getString() {
		return l.yytext();
	}

	private int getInt() {
		return Integer.parseInt(getString());
	}

	public Program Program() throws Exception {
		List<Method> lMethod;
		lMethod = Methods();

		Program program = new Program(lMethod);
		return program;
	}

	public List<Method> Methods() throws Exception {
		List<Method> lMethod = new ArrayList<Method>();

		if (symb == Lexer.Yytoken.METHOD) {
			advance(Lexer.Yytoken.METHOD);
			lMethod.add(Method());
			lMethod.addAll(Methods());
		}
		return lMethod;
	}

	public Method Method() throws Exception {
		Method lMethod = new Method();
		ID id = null;
		Arguments arguments = null;
		Arguments variables = null;
		List<Statement> statements = null;
		ID rt = null;

		if (symb == Lexer.Yytoken.ID) {
			id = ID();
			advance(Lexer.Yytoken.LBRA);
			if (symb==Lexer.Yytoken.ID)
				arguments = new Arguments(Arguments());
			else
				arguments = new Arguments();
				
			advance(Lexer.Yytoken.RBRA);
			
			if (symb == Lexer.Yytoken.VARS) {
				advance(Lexer.Yytoken.VARS);
				variables = new Arguments(Arguments());
			}

			advance(Lexer.Yytoken.BEGIN);
			statements = new ArrayList<Statement>();
			statements.add(Statement());
			statements.addAll(Statements());
			if (symb == Lexer.Yytoken.RETURN) {
				advance(Lexer.Yytoken.RETURN);
				rt = ID();
				advance(Lexer.Yytoken.SEMI);
			}
		}
		advance(Lexer.Yytoken.ENDMETHOD);
		advance(Lexer.Yytoken.SEMI);
		lMethod = new Method(id, arguments, variables, statements, rt);
		return lMethod;
	}

	public List<ID> Arguments() throws Exception {
		List<ID> arguments = new ArrayList<ID>();

		
		arguments.add(ID());
		if (symb == Lexer.Yytoken.COMMA) {
			advance(Lexer.Yytoken.COMMA);
			arguments.addAll(Arguments());
		}

		return arguments;
	}

	public ID ID() throws Exception {
		ID id = new ID(getString());
		advance(Lexer.Yytoken.ID);
		return id;
	}

	public Int Int() throws Exception {
		Int id = new Int(getInt());
		advance(Lexer.Yytoken.INT);
		return id;
	}

	/**
	 * @return
	 * @throws Exception
	 */
	public List<Exp> Expressions() throws Exception {
		List<Exp> exps = new ArrayList<Exp>();
		exps.add(Expression());
		if (symb == Lexer.Yytoken.COMMA) {
			advance(Lexer.Yytoken.COMMA);
			exps.addAll(Expressions());
		}
		return exps;
	}

	public Exp Expression() throws Exception {
		Exp exp = null;
		if (symb == Lexer.Yytoken.INT) {

			return new IExpressions(Int());

		} else if (symb == Lexer.Yytoken.ID) {

			ID id = ID();
			List<Exp> exps = null;

			if (symb == Lexer.Yytoken.LBRA) {
				advance(Lexer.Yytoken.LBRA);
				exps = Expressions();
				advance(Lexer.Yytoken.RBRA);
				return new IDExpression(id, new Expressions(exps));
			} else
				return new IDExpression(id);

		} else
			throw new Exception("Expression expected. Got: " + symb);

	}

	public Exp IExpressions() throws Exception {
		return new IExpressions(Int());
	}

	public Exp IDExpression() throws Exception {
		ID id = ID();

		if (symb == Lexer.Yytoken.LBRA) {
			advance(Lexer.Yytoken.LBRA);
			Expressions exps = new Expressions(Expressions());
			advance(Lexer.Yytoken.RBRA);
			return new IDExpression(id, exps);
		}

		return new IDExpression(id, null);
	}

	public Exp TermExpressions() throws Exception {
		Lexer.Yytoken id = symb;
		lex();
		if (symb == Lexer.Yytoken.LBRA) {
			advance(Lexer.Yytoken.LBRA);
			Expressions exp = new Expressions(Expressions());
			advance(Lexer.Yytoken.RBRA);
			return new TermExpression(id, exp);
		} else {
			throw new Exception("Not valid term exp");
		}
	}

	public Cond Cond() throws Exception {
		Bop op = Bop();
		advance(Lexer.Yytoken.LBRA);
		Expressions exp = new Expressions(Expressions());
		advance(Lexer.Yytoken.RBRA);
		return new Cond(op, exp);
	}

	public Bop Bop() throws Exception {
		Lexer.Yytoken op = symb;
		Set<Lexer.Yytoken> valid = new HashSet<Lexer.Yytoken>();
		valid.add(Lexer.Yytoken.LT);
		valid.add(Lexer.Yytoken.LTE);
		valid.add(Lexer.Yytoken.EQ);
		valid.add(Lexer.Yytoken.NEQ);
		if (valid.contains(op)) {
			advance(op);
			return new Bop(op);
		} else {
			throw new Exception("Not valid operator");
		}
	}

	public List<Statement> Statements() throws Exception {
		System.out.println("Processing statements: " + symb);
		List<Statement> statements = new ArrayList<Statement>();

		if (symb == Lexer.Yytoken.RETURN || symb == Lexer.Yytoken.ENDMETHOD || symb == Lexer.Yytoken.ENDWHILE
				|| symb == Lexer.Yytoken.ELSE || symb == Lexer.Yytoken.ENDIF || symb == Lexer.Yytoken.COMMA
				|| symb == Lexer.Yytoken.SEMI) {
			System.out.println("in here");
			return statements;
		} else {
			statements.add(Statement());
			statements.addAll(Statements());
		}
		return statements;
	}

	public Statement Statement() throws Exception {
		System.out.println("Processing Statement: " + symb);
		Statement st;
		if (symb == Lexer.Yytoken.ID) {
			st = assignStatement();
			advance(Lexer.Yytoken.SEMI);
		} else if (symb == Lexer.Yytoken.READ) {
			st = readStatement();
			advance(Lexer.Yytoken.SEMI);
		} else if (symb == Lexer.Yytoken.WRITE) {
			st = writeStatement();
			advance(Lexer.Yytoken.SEMI);
		} else if (symb == Lexer.Yytoken.IF) {
			st = ifStatement();
			advance(Lexer.Yytoken.SEMI);
		} else if (symb == Lexer.Yytoken.WHILE) {
			System.out.println("found while");
			st = whileStatement();
			advance(Lexer.Yytoken.SEMI);
		} else {
			throw new Exception("Parser error: not Command: " + symb);
		}
		return st;
	}

	public List<Statement> writeStatements() throws Exception {
		List<Statement> statements = new ArrayList<Statement>();
		if (symb == Lexer.Yytoken.ENDWHILE) {
			return statements;
		} else {
			statements.add(Statement());
			statements.addAll(writeStatements());
		}
		return statements;
	}

	public Statement assignStatement() throws Exception {
		ID variable = ID();
		advance(Lexer.Yytoken.ASSIGN);
		Expressions exp = new Expressions(Expressions());
		return new assignStatement(variable, exp);
	}

	public Statement readStatement() throws Exception {
		advance(Lexer.Yytoken.READ);
		ID id = ID();
		return new readStatement(id);
	}

	public Statement writeStatement() throws Exception {
		advance(Lexer.Yytoken.WRITE);
		Exp exp = null;
		if (symb == Lexer.Yytoken.INT) {
			exp = IExpressions();
		} else if (symb == Lexer.Yytoken.ID) {
			exp = IDExpression();
		} else {
			throw new Exception("Parser error: Write Statement not EXP: " + symb);
		}
		return new writeStatement(exp);
	}

	public Statement whileStatement() throws Exception {
		advance(Lexer.Yytoken.WHILE);
		Cond cond = Cond();
		advance(Lexer.Yytoken.BEGIN);
		List<Statement> stat = Statements();
		advance(Lexer.Yytoken.ENDWHILE);

		return new whileStatement(cond, stat);
	}

	public Statement ifStatement() throws Exception {
		advance(Lexer.Yytoken.IF);
		Cond cond = Cond();
		advance(Lexer.Yytoken.THEN);
		List<Statement> statements = Statements();
		if (symb == Lexer.Yytoken.ELSE) {
			advance(Lexer.Yytoken.ELSE);
			List<Statement> exp = Statements();
			advance(Lexer.Yytoken.ENDIF);
			return new ifStatement(cond, statements, exp);
		}
		advance(Lexer.Yytoken.ENDIF);
		return new ifStatement(cond, statements);
	}

	public void lextest() throws IOException {
		Lexer.Yytoken tok = l.yylex();
		while (tok != Lexer.Yytoken.EOF) {
			System.out.print(l.yytext());
			System.out.println("  " + tok);
			tok = l.yylex();

		}
	}

}
