package instrucciones;

import excepciones.ArrayException;
import programa.Compiler;
import programa.LexicalParser;
import bytecodes.Halt;

public class Return implements Instruction {

	@Override
	/**Comprueba que la instruccion introducida es correcta
	 * @param words. String[].
	 * @param lexParser. LexicalParser.
	 * @return Condition de Return si se ha podido parsear, null si no.
	 * @throws ArrayException*/
	public Instruction lexParse(String[] words, LexicalParser lexParser) {
		if(words.length == 1 && words[0].equalsIgnoreCase("RETURN")){
			lexParser.increaseProgramCounter();
			return new Return();
		}
		else {
			return null;
		}
	}

	@Override
	/** Funcion que compila la instruccion Return. Anade el bytecode HALT.
	 * @param compiler.
	 * @throws ArrayException*/
	public void compile(Compiler compiler) throws ArrayException {
		compiler.addByteCode(new Halt());
	}
}
