package excepciones;

@SuppressWarnings("serial")
public class DivByZeroException extends ExecutionErrorException{
	/**Excepcion que saltara si se intenta dividir un numero por 0*/
	public DivByZeroException(String e){
		super(e);
	}


}