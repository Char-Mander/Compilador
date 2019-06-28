package bytecodes;

import excepciones.ArrayException;
import excepciones.ExecutionErrorException;
import principal.CPU;

/**Engloba todas las funciones que puede tener un ByteCode*/
public interface ByteCode {
	
	/**@throws ExecutionErrorException
	 * @throws ArrayException
	 * */
	abstract public void execute(CPU cpu) throws ExecutionErrorException, ArrayException;
	
	abstract public ByteCode parse(String[] words);
}




