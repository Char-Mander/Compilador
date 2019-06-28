package instrucciones;

import excepciones.ArrayException;
import programa.Compiler;
import programa.LexicalParser;
import bytecodes.Add;
import bytecodes.Div;
import bytecodes.Mul;
import bytecodes.Store;
import bytecodes.Sub;

public class CompoundAssignment implements Instruction {
	/**Variable que toda instruccion tiene a la izquierda*/
	private String varName;
	/**Operador de la instruccion*/
	private String operator;
	/**Terminos t1, y t2 del tipo Term (pueden ser variables o numeros)*/
	private Term t1;
	private Term t2;
	
	public CompoundAssignment() {}

	public CompoundAssignment(String var, String op, Term term1, Term term2) {
		this.varName = var;
		this.operator = op;
		this.t1 = term1;
		this.t2 = term2;
	}
	
	/**@param words
	 * @param lexParser
	 * @return null si el array no contiene 5 palabras (o la primera palabra no es una variable).
	 * Devuelve una expresion del tipo CompoundAssignment en caso contrario.
	 * Funcion que parsea la instruccion correspondiente, e incrementa el contador del SourceProgram.
	 * */
	@Override
	public Instruction lexParse(String[] words, LexicalParser lexParser) {
		
		if (words.length != 5) return null;
		else {
			String var = words[0];
			if ('a' <= var.charAt(0) && var.charAt(0) <= 'z' && var.length() == 1) {
				String op = words[3];
				Term term1 = TermParser.parse(words[2]);
				Term term2 = TermParser.parse(words[4]);
				if(!op.equalsIgnoreCase("+") && !op.equalsIgnoreCase("-") &&
						!op.equalsIgnoreCase("*") && !op.equalsIgnoreCase("/"))
					return null;
				lexParser.increaseProgramCounter();
				return new CompoundAssignment(var, op, term1, term2);
			}
			else
				return null;
		}
	}
	/**@param compiler
	 * @throws ArrayException
	 * Funcion que compila la instruccion compuesta. Anade los terminos t1 y t2 al bcProgram, y comprueba
	 *  que tipo de operador aparece en la instruccion (y lo anade tambien al bcProgram).
	 * Despues se comprueba si la variable existe o no, (si no existe, se anade al array de variables),
	 * y se anade un nuevo bytecode al bcProgram.
	 * */
	@Override
	public void compile(Compiler compiler) throws ArrayException {
		compiler.addByteCode(this.t1.compile(compiler));
		compiler.addByteCode(this.t2.compile(compiler));
		switch(this.operator){
			case "+": compiler.addByteCode(new Add()); break;
			case "-": compiler.addByteCode(new Sub()); break;
			case "*": compiler.addByteCode(new Mul()); break;
			case "/": compiler.addByteCode(new Div()); break;
		}
		compiler.addByteCode(new Store(compiler.getIndex(this.varName)));
	}
	
	public String toString(){
		return "Asignacion compuesta";
	}

}
