package excepciones;

@SuppressWarnings("serial")
public class LexicalAnalysisException extends Exception{
	/**Excepcion que saltara si hay alguna instruccion esta a null*/
	public LexicalAnalysisException(String e){
		super(e);
	}

	
}
