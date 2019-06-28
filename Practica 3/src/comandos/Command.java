package comandos;


import java.io.FileNotFoundException;

import excepciones.*;
import principal.Engine;

/**Engloba todas las funciones que puede tener un Comando*/
public interface Command {
	
	/**@throws ExecutionErrorException
	 * @throws ArrayException
	 * @throws LexicalAnalysisException
	 * @throws BadFormatByteCodeException
	 * @throws ExecutionErrorException
	 * @throws FileNotFoundException*/
	abstract public void execute(Engine engine) throws ArrayException, LexicalAnalysisException,
	BadFormatByteCodeException, ExecutionErrorException, FileNotFoundException;

	abstract public Command parse(String[] s);

	abstract public String textHelp();

}
