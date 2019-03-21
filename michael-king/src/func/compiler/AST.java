package func.compiler;

import java.util.ArrayList;
import java.util.List;

interface ASTVisitor {
	
	void visit(Program prog) throws Exception;

	void visit(Method mth) throws Exception;

	void visit(ID id) throws Exception;

	void visit(Int ind) throws Exception;

	void visit(Arguments arguments) throws Exception;

	
	void visit(IExpressions Expressions) throws Exception;

	void visit(IDExpression Expressions) throws Exception;

	void visit(TermExpression Expressions) throws Exception;

	void visit(Expressions Expressions) throws Exception;

	void visit(Bop op) throws Exception;

	void visit(Cond Expressions) throws Exception;

	void visit(assignStatement statement) throws Exception;

	void visit(ifStatement statement) throws Exception;

	void visit(whileStatement statement) throws Exception;

	void visit(readStatement statement) throws Exception;

	void visit(writeStatement statement) throws Exception;

}

interface ASTElement {
	void accept(ASTVisitor visitor) throws Exception;
}

class Program implements ASTElement {
	List<Method> method;

	public Program(List<Method> method) {
		this.method = method;
	}

	public void accept(ASTVisitor visitor) throws Exception {
		visitor.visit(this);
	}
}

class Method implements ASTElement {
	ID id;
	Arguments arguments;
	Arguments variables;
	List<Statement> statement;
	ID rt;

	public Method() {
		int ind = 0;
	}

	public Method(ID id, Arguments arguments, Arguments variables, List<Statement> statement, ID rt) {
		this.id = id;
		this.arguments = arguments;
		this.variables = variables;
		this.statement = statement;
		this.rt = rt;
	}

	public void accept(ASTVisitor visitor) throws Exception {
		visitor.visit(this);
	}
}

class ID implements ASTElement {
	String id;

	public ID(String id) {
		this.id = id;
	}

	public void accept(ASTVisitor visitor) throws Exception {
		visitor.visit(this);
	}
}

class Int implements ASTElement {
	int id;

	public Int(int id) {
		this.id = id;
	}

	public void accept(ASTVisitor visitor) throws Exception {
		visitor.visit(this);
	}
}

class Arguments implements ASTElement {
	List<ID> arguments;

	public Arguments(List<ID> arguments) {
		this.arguments = arguments;
	}

	public Arguments() {
		this.arguments=new ArrayList<ID>();
	}

	public void accept(ASTVisitor visitor) throws Exception {
		visitor.visit(this);
	}
}



abstract class Exp implements ASTElement {
}

class IExpressions extends Exp implements ASTElement {
	Int ind;

	public IExpressions(Int ind) {
		this.ind = ind;
	}

	public void accept(ASTVisitor visitor) throws Exception {
		visitor.visit(this);
	}
}

class IDExpression extends Exp implements ASTElement {
	
	ID id=null;
	Expressions exps=null;

	public IDExpression(ID id, Expressions Expressions) {
		this.id = id;
		this.exps = Expressions;
	}

	public IDExpression(ID id) {
		this.id = id;
	}

	public void accept(ASTVisitor visitor) throws Exception {
		visitor.visit(this);
	}
}

class TermExpression extends Exp implements ASTElement {
	Lexer.Yytoken id;;
	Expressions expressions;

	public TermExpression(Lexer.Yytoken id, Expressions Expressions) {
		this.id = id;
		this.expressions = Expressions;
	}

	public void accept(ASTVisitor visitor) throws Exception {
		visitor.visit(this);
	}
}

class Expressions implements ASTElement {
	List<Exp> Expressions;

	public Expressions(List<Exp> Expressions) {
		this.Expressions = Expressions;
	}

	public void accept(ASTVisitor visitor) throws Exception {
		visitor.visit(this);
	}
}

class Bop implements ASTElement {
	Lexer.Yytoken op;

	public Bop(Lexer.Yytoken op) {
		this.op = op;
	}

	public void accept(ASTVisitor visitor) throws Exception {
		visitor.visit(this);
	}
}

class Cond implements ASTElement {
	Bop op;
	Expressions Expressions;

	public Cond(Bop op, Expressions Expressions) {
		this.op = op;
		this.Expressions = Expressions;
	}

	public void accept(ASTVisitor visitor) throws Exception {
		visitor.visit(this);
	}
}

abstract class Statement implements ASTElement {}

class assignStatement extends Statement implements ASTElement {
	ID variable;
	Expressions exp;

	public assignStatement(ID variable, Expressions exp) {
		this.variable = variable;
		this.exp = exp;
	}

	public void accept(ASTVisitor visitor) throws Exception {
		visitor.visit(this);
	}
}

class ifStatement extends Statement implements ASTElement {
	Cond condition;
	List<Statement> cmd1;
	List<Statement> cmd2;

	public ifStatement(Cond condition, List<Statement> cmd1) {
		this.condition = condition;
		this.cmd1 = cmd1;
		this.cmd2 = null;
	}

	public ifStatement(Cond condition, List<Statement> cmd1, List<Statement> cmd2) {
		this.condition = condition;
		this.cmd1 = cmd1;
		this.cmd2 = cmd2;
	}

	public boolean hasElse() {
		return cmd2 != null;
	}

	public void accept(ASTVisitor visitor) throws Exception {
		visitor.visit(this);
	}
}

class whileStatement extends Statement implements ASTElement {
	Cond condition;
	List<Statement> cmd;

	public whileStatement(Cond condition, List<Statement> cmd) {
		this.condition = condition;
		this.cmd = cmd;
	}

	public void accept(ASTVisitor visitor) throws Exception {
		visitor.visit(this);
	}
}

class readStatement extends Statement implements ASTElement {
	ID id;

	public readStatement(ID id) {
		this.id = id;
	}

	public void accept(ASTVisitor visitor) throws Exception {
		visitor.visit(this);
	}
}

class writeStatement extends Statement implements ASTElement {
	Exp exp;

	public writeStatement(Exp exp) {
		this.exp = exp;
	}

	public void accept(ASTVisitor visitor) throws Exception {
		visitor.visit(this);
	}
}