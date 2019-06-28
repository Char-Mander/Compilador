package instrucciones;

import excepciones.ArrayException;
import excepciones.LexicalAnalysisException;
import programa.LexicalParser;

public class ParserInstruction {
	
	/**Inicializa las distintas instrucciones para parsearlos.*/
	private final static Instruction[] instructions = { new SimpleAssignment(), 
			new CompoundAssignment(), new While(), new IfThen(), new Return(), new Write() };
			
	/**@param line
	 * @param lexParser
	 * @throws ArrayException
	 * @throws LexicalAnalysisException
	 * @return c (que sera la instruccion parseada)
	 * Funcion que parsea las instrucciones.
	 * */
	public static Instruction parse(String line, LexicalParser lexParser) throws ArrayException, LexicalAnalysisException {
		boolean encontrado = false;
		int i = 0;
		Instruction c = null;
		line = line.trim();
		while (i < instructions.length && !encontrado){
			c = instructions[i].lexParse(line.split(" +"), lexParser); 
			if (c != null) encontrado = true;
			else i++;
		}
		return c;
	}
}
