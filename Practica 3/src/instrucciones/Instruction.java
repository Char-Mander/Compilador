package instrucciones;
import excepciones.ArrayException;
import programa.Compiler;
import programa.LexicalParser;

public interface Instruction {
	
	/**@throws ArrayException*/
	Instruction lexParse(String[] words, LexicalParser lexParser) throws ArrayException;
	void compile(Compiler compiler) throws ArrayException;
}

