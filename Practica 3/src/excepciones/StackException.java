package excepciones;

@SuppressWarnings("serial")
public class StackException extends ExecutionErrorException{
	/**Excepcion que saltara si hay algun error al acceder a la pila:
	 * si se accede a una posicion negativa,
	 * si se intentan meter mas elementos cuando esta llena, etc.*/
	public StackException(String e){
		super(e);
	}
	
}
