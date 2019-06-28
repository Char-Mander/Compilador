package excepciones;

@SuppressWarnings("serial")
public class ArrayException extends Exception{
	/**Excepcion que saltara si hay fallos a la hora de acceder a un array:
	 * si algun array esta vacio y se intentan sacar elementos de este, 
	 * si se intenta anadir un nuevo elemento y esta lleno, etc.*/
	public ArrayException(String e){
		super(e);
	}

}
