package func.compiler;

public class ASTPrinter implements ASTVisitor {
    int indent;

    private void printIndent() {
        for (int i = 0; i < indent; i++)
            System.out.print(" ");
    }

    public ASTPrinter() {
        indent = 0;
    }

    public void visit(Program prog) throws Exception {
        if (prog.method != null) {
            for (Method d : prog.method) {
                 d.accept(this);
            }
        }
    }

    public void visit(Method method) throws Exception {
        indent = 0;
        System.out.print("METHOD ");
        method.id.accept(this);
        System.out.print("(");
        method.arguments.accept(this);
        System.out.print(") VARS ");
        method.variables.accept(this);
        System.out.println("\nBEGIN");
        indent += 2;
        for (Statement statement : method.statement) {
            statement.accept(this);
            System.out.println();
        }
        if (method.rt != null) {
            System.out.print("RETURN ");
            method.rt.accept(this);
            System.out.println();
        }
        indent -= 2;
        System.out.println("ENDMETHOD\n");

    }

    public void visit(ID id) throws Exception {
        System.out.print(id.id);
    }

    public void visit(Int i) throws Exception {
        System.out.print(i.id);

    }

    public void visit(Arguments arguments) throws Exception {
    	if (arguments.arguments.isEmpty())
    		return;
    	
 
        for (int i=0; i< arguments.arguments.size()-1;i++) {
            arguments.arguments.get(i).accept(this);
            System.out.print(",");
        }
        
        arguments.arguments.get(arguments.arguments.size()-1).accept(this);
        

    }

   

    public void visit(IExpressions exp) throws Exception {
        exp.ind.accept(this);
    }

    public void visit(IDExpression exp) throws Exception {
        exp.id.accept(this);
        if (exp.exps != null) {
            System.out.print("(");
            exp.exps.accept(this);
            System.out.print(")");
        }
    }

    public void visit(TermExpression exp) throws Exception {
        System.out.print(exp.id);
        System.out.print("(");
        exp.expressions.accept(this);
        System.out.print(")");
    }

    public void visit(Expressions Expressions) throws Exception {
        for(int i = 0; i < Expressions.Expressions.size()-1; i++){
        
            Expressions.Expressions.get(i).accept(this);
            System.out.print(",");
        }        
        Expressions.Expressions.get(Expressions.Expressions.size()-1).accept(this);
    }

    public void visit(Bop op) throws Exception {
        if (op.op == Lexer.Yytoken.LT)
            System.out.print("less");
        if (op.op == Lexer.Yytoken.LTE)
            System.out.print("lessEq");
        if (op.op == Lexer.Yytoken.EQ)
            System.out.print("eq");
        if (op.op == Lexer.Yytoken.NEQ)
            System.out.print("nEq");
    }

    public void visit(Cond Expressions) throws Exception {
        Expressions.op.accept(this);
        System.out.print("(");
        Expressions.Expressions.accept(this);
        System.out.print(")");
    }

    public void visit(assignStatement statement) throws Exception {
        printIndent();
        statement.variable.accept(this);
        System.out.print(" := ");
        statement.exp.accept(this);
    }

    public void visit(ifStatement statement) throws Exception {
        printIndent();
        System.out.print("IF ");
        statement.condition.accept(this);
        System.out.println(" THEN ");
        indent += 2;
        for (Statement s : statement.cmd1) {
            s.accept(this);
            System.out.print("\n");
        }
        indent -= 2;
        if (statement.cmd2 != null) {
            printIndent();
            System.out.print("ELSE\n");
            indent += 2;
            for (Statement s : statement.cmd2) {
                s.accept(this);
                System.out.print("\n");
            }
            indent -= 2;
        }
        printIndent();
        System.out.print("ENDIF ");
    }

     
    public void visit(whileStatement statement) throws Exception {
        printIndent();
        System.out.print("WHILE ");
        statement.condition.accept(this);
        System.out.println();
        printIndent();
        System.out.print("BEGIN\n");
        indent += 2;
        for (Statement s : statement.cmd) {
            s.accept(this);
            System.out.print("\n");
        }
        indent -= 2;
        printIndent();
        System.out.print("ENDWHILE ");
    }

     
    public void visit(readStatement statement) throws Exception {
        printIndent();
        System.out.print("READ ");
        statement.id.accept(this);
    }

     
    public void visit(writeStatement statement) throws Exception {
        printIndent();
        System.out.print("WRTIE ");
        statement.exp.accept(this);
    }
}
