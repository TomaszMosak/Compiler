package func.compiler;


import java.util.HashMap;

import com.sun.javafx.collections.MappingChange.Map;

public class Compile implements ASTVisitor{
	
	class Frame{
		final Frame parent;
		final int start;
		int current;
		HashMap<String,Integer> vars;
		
		public Frame(int start){
			vars = new HashMap<String,Integer>();
			this.start = start;
			current = start;
			parent = null;
		}
		public Frame(int start,Frame parent){
			vars = new HashMap<String,Integer>();
			this.start = start;
			current = start;
			this.parent = parent;
		}
		
		public void addVar(String name){
			vars.put(name,current++);
		}
		
		public int checkVar(String name){
			Integer v = vars.get(name);
			if (v != null)
				return v;
			return -1;
		}
		
		public int findVar(String name){
			Integer v = vars.get(name);
			if (v != null)
				return v;
			if (parent != null)
				return parent.findVar(name);
			return -1;
		}
		
	}
	StringBuffer code;
	Frame frame;
	int labno;
	int RD;
    final int E1 = 16;
    final int E2 = 17;
    final int A0 = 18;
	
	public Compile() {
		code = new StringBuffer("");
		frame = new Frame(0);
		labno = 0;
	}
	
    private final String tab = "\t";
    private final String newline = System.lineSeparator();
    
    private void line(String s){
      code.append(tab + s + newline);
    }
	
    private void pushFrame(){
    	frame = new Frame(frame.current,frame);
    }
    
    private void popFrame() throws Exception{
    	if(frame.parent == null)
    		throw new Exception("Trying to pop top frame");
    	frame = frame.parent;
    }
    
    private String regname(int n){
    	switch(n) {
    		case E1: return "$t8";
    		case E2: return "$t9";
    		case A0: return "$a0";
    		default:
    			return n < 8 ? "$s" + n : "$t" + (n-8);
    	}
    }
    
    private void codePush(int r){
    	line ("addi $sp,$sp,-4");
	    line (String.format("sw %s,0($sp)",regname(r)));
    }

    private void codePop(int r){  
    	line (String.format("lw %s,0($sp)",regname(r)));
    	line ("addi $sp,$sp,4");
    }
    
    private String notComp(Bop op) throws Exception{
    	switch(op.op){
    	       case LT: return "ge";
    	       case LTE: return "gt";
    	       case EQ: return "ne";
    	       case NEQ: return "eq";
    	       default: throw new Exception("Not an comparison operator" + op);
    	     }
    	   }
    
	public void visit(Program p) throws Exception{
	      line (".data");
	      code.append ("sinp:   .asciiz \"INPUT> \"\n");
	      code.append(newline);
	      line (".text");
	
	      for(Method mthd : p.method){
	    	  visit(mthd);
	      }
	}
	
	public void visit(Method mth) throws Exception {
		
	}
	
	public void visit(Arguments arguments) throws Exception {
		
	}
	
	public void visit(writeStatement statement) throws Exception {
		line ("li  $v0, 1");
	    RD=A0;
		statement.exp.accept(this);
		line ("syscall");
	}

	public void visit(readStatement statement) throws Exception {
		int reg = frame.findVar(statement.id.id);
		if (reg == -1)
		  throw new Exception ("Error: variable not declared : " + statement.id);
	    line ("li  $v0, 4");
	    line ("la  $a0, sinp");
	    line ("syscall");
	    // reads input
	    line ("li  $v0, 5");
	    line ("syscall");
	    line (String.format("move  %s,$v0",regname(reg)));	
	}


	private String compileCondExp (Cond exp) throws Exception{
		RD=E1;
		exp.Expressions.Expressions.get(0).accept(this);;
        codePush(E1);
		RD=E2;
		exp.Expressions.Expressions.get(1).accept(this);;
        codePop(E1);
		return notComp(exp.op);
	}
	
	public void visit(ifStatement statement) throws Exception{
		int ln = labno++;
		// Visitor pattern not working properly here
		Cond op = (Cond) statement.condition;
		String oper = compileCondExp(op);
		if(statement.hasElse()){
			line(String.format("b%s %s,%s,IFALSE%d\n",oper,regname(E1),regname(E2),ln));
			for (Statement s : statement.cmd1){
				s.accept(this);
			}
			line(String.format("j IFEND%d",ln));
			code.append(String.format("IFALSE%d:\n",ln));
			for (Statement s : statement.cmd2){
				s.accept(this);
			}
		}else{
			line(String.format("\tb%s %s,%s,IFEND%d\n",oper,regname(E1),regname(E2),ln));
			((Bop) statement.cmd1).accept(this);
		}
		code.append(String.format("IFEND%d:\n",ln));
		
	}

	public void visit(whileStatement statement) throws Exception {
		int ln = labno++;
		code.append(String.format("WLOOP%d:\n",ln));
		// Visitor pattern not working properly here
		Cond op = (Cond) statement.condition;
		String oper = compileCondExp(op);
        line(String.format("b%s %s,%s,WEND%d",oper,regname(E1),regname(E2),ln));
        ((Bop) statement.cmd).accept(this);
        line (String.format("j WLOOP%d",ln));
        code.append(String.format("WEND%d:\n",ln));
	}

	@Override
	public void visit(assignStatement statement) throws Exception {
		int reg = frame.findVar(statement.variable.id);
		if (reg == -1)
			throw new Exception("Assignment - Variable not present: " + statement.variable.id);
		RD=reg;
		statement.accept(this);		
	}

	public void visit(Cond e) throws Exception {
		int cur = RD;
		RD=E1;
		e.Expressions.Expressions.get(0).accept(this);
        codePush(E1);
		RD=E2;
		e.Expressions.Expressions.get(1).accept(this);
        codePop(E1);
        line (String.format("%s %s,%s,%s", compileCondExp(e), regname(cur), regname(E1), regname(E2)));		
	}

	@Override
	public void visit(ID id) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(Int ind) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(IExpressions Expressions) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(IDExpression Expressions) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(TermExpression Expressions) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(Expressions Expressions) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(Bop op) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
}
