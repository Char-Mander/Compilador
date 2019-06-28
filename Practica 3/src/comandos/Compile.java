package comandos;

import excepciones.ArrayException;
import excepciones.LexicalAnalysisException;
import principal.Engine;

public class Compile implements Command {

	@Override
	/**Ejecuta la funcion que compila el programa.
	 * @param engine 
	 * @throws ArrayException
	 * @throws LexicalAnalysisException*/
	public void execute(Engine engine) throws ArrayException, LexicalAnalysisException {
		engine.compile();
	}

	/**@param nombre[]
	 * @return Si nombre[0] es "COMPILE", devuelve el comando Compile. Si no, devuelve null
	 * */
	@Override
	public Command parse(String[] nombre) {
		if(nombre.length == 1 && nombre[0].equalsIgnoreCase("COMPILE"))
			return new Compile();
		else return null;
	}

	@Override
	public String textHelp() {
		return "	COMPILE: realiza el analisis lexico del programa fuente, generando"
				+ " un nuevo programa parseado y, posteriormente," +System.getProperty("line.separator")
				+  "	a partir del programa parseado, genera un programa bytecode. " + System.getProperty("line.separator");
	}
	
	public String toString(){
		return "COMPILE: ";
	}

}
