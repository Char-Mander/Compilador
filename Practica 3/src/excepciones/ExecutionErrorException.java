package excepciones;

@SuppressWarnings("serial")
public class ExecutionErrorException extends Exception{
	/**Excepcion que saltara si hay algun error de ejecucion (StackException o DivByZeroException)*/
	public ExecutionErrorException(String e){
		super(e);
	}
}
