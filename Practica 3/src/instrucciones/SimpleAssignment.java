package instrucciones;

import excepciones.ArrayException;
import programa.Compiler;
import programa.LexicalParser;
import bytecodes.Store;

public class SimpleAssignment implements Instruction {
	/**Variable que toda instruccion lleva a la izquierda */
	private String varName;
	/**Variable tipo Term de la instruccion (puede ser variable o numero)*/
	private Term rhs;
	
	public SimpleAssignment() {}
	
	public SimpleAssignment(String var, Term term) {
		this.varName = var;
		this.rhs = term;
	}
	
	@Override
	/**@param words
	 * @param lexParser
	 * @return null si el array no contiene 3 palabras (o la primera palabra no es una  variable). 
	 * Devuelve una expresion del tipo SimpleAssignment en caso contrario.
	 * Funcion que parsea la instruccion correspondiente, e incrementa el contador del SourceProgram.
	 * */
	public Instruction lexParse(String[] words, LexicalParser lexParser) {
		if (words.length != 3) return null;
		else { 
			String var = words[0];
			if ('a' <= var.charAt(0) && var.charAt(0) <= 'z' && var.length() == 1) {
				Term term = TermParser.parse(words[2]);
				lexParser.increaseProgramCounter();
				return new SimpleAssignment(var, term);
			}
			else
				return null;
		}
	}

	/**@param compiler
	 * @throws ArrayException 
	 * Funcion que compila la instruccion simple. Anade el termino rhs al bcProgram, y
	 * despues se comprueba si la variable existe o no, (si no existe, se anade al array
	 * de variables), y se anade un nuevo bytecode al bcProgram.
	 * */
	@Override
	public void compile(Compiler compiler) throws ArrayException {
		compiler.addByteCode(this.rhs.compile(compiler));
		compiler.addByteCode(new Store(compiler.getIndex(this.varName)));
	}

	public String toString(){
		return "Asignacion simple";
	}
}
