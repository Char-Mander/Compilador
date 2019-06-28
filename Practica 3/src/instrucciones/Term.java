package instrucciones;

import bytecodes.ByteCode;
import excepciones.ArrayException;
import programa.Compiler;

public interface Term {
	
	Term parse(String term);
	ByteCode compile(Compiler compiler) throws ArrayException;
}
