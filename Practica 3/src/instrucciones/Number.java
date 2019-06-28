package instrucciones;

import bytecodes.ByteCode;
import bytecodes.Push;
import programa.Compiler;

public class Number implements Term {
	/**Atributo que indica el numero*/
	private int term;
	
	public Number(int num) {
		this.term = num;
	}
	
	public Number() {}

	@Override
	/**Reconoce el numero de la instruccion
	 * @param term. String.
	 * @return new Number. Traduciendo el string a int.*/
	public Term parse(String term) {
		return new Number(Integer.parseInt(term));
	}
	
	@Override
	/**Genera el bytecode que introduce el numero
	 * @param compiler
	 * @return new Push*/
	public ByteCode compile(Compiler compiler) {
		return new Push(this.term);
	}
	


}
