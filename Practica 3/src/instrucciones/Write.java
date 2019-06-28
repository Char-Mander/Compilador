package instrucciones;

import excepciones.ArrayException;
import programa.Compiler;
import programa.LexicalParser;
import bytecodes.Load;
import bytecodes.Out;

public class Write implements Instruction {
	/**Nombre de la variable*/
	private String varName;
	
	public Write() {}
	
	public Write(String name) {
		this.varName = name;
	}
	
	/**@param words
	 * @param lexParser
	 * @return null si el tamano del array no es de 2 palabras. En caso contrario,
	 * devuelve un nuevo Write de la palabra que esta en la segunda posicion.
	 * Incrementa el contador de programa si el array no es de dos palabras, antes de devolver el
	 * new Write.
	 * */
	@Override
	public Instruction lexParse(String[] words, LexicalParser lexParser) {
		if(words.length != 2 || words[1].length() != 1 || 'a' > words[1].charAt(0) || words[1].charAt(0) > 'z')
			return null;
		else {
			lexParser.increaseProgramCounter();
			return new Write(words[1]);
		}
	}

	/** @param write
	 * @throws ArrayException
	 * Funcion que compila el Write. Se le asigna una posicion a la variable (la busca en la tabla de 
	 * las variables, y si existe, devuelve su posicion. Si no, se anade la ultima, y devuelve la posicion).
	 * Despues, se anade al bcProgram un new Load(con la posicion de la variable) y un new Out para que la muestre
	 * por pantalla.
	 * */
	@Override
	public void compile(Compiler compiler) throws ArrayException {
		 int index = compiler.getIndex(this.varName);
		 compiler.addByteCode(new Load(index));
		 compiler.addByteCode(new Out());
	}

}
