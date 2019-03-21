package func.compiler;

public class Func
{

	public static void main(String[] args) throws Exception{
		String fname = "myprogram.func";
		Parser p = new Parser(fname);
		//p.lextest();
		//p = new Parser(fname);
		Program program=p.Program();
		
		ASTPrinter printer=new ASTPrinter();
		program.accept(printer);
		
	}
}
