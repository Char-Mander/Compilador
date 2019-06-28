package excepciones;

@SuppressWarnings("serial")
public class BadFormatByteCodeException extends Exception{
	/**Excepcion que saltara si cualquier ByteCode esta mal escrito */
	public BadFormatByteCodeException(String e){
		super(e);
	}

}
