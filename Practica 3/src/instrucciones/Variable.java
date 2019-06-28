package instrucciones;

import bytecodes.ByteCode;
import bytecodes.Load;
import excepciones.ArrayException;
import programa.Compiler;

public class Variable implements Term {
	/**Atributo que indica la variable*/
	private String varName;
	
	public Variable(String term){
		this.varName = term;
	}
	
	public Variable() {}

	@Override
	/**Reconoce el numero de la instruccion
	 * @param term. String.
	 * @return new Variable si la variable es correcta, null si no.*/
	public Term parse(String term) {
		 if (term.length() != 1) return null;
		 else { 
			 char name = term.charAt(0);
			 if ('a' <= name && name <= 'z') 
				 return new Variable(term); 
			 else 
				 return null;
		 }
	}

	@Override
	/**Genera el bytecode que carga la variable
	 * @param compiler
	 * @return new Load*/
	public ByteCode compile(Compiler compiler) throws ArrayException {
		return new Load(compiler.getIndex(this.varName));
	}
}
