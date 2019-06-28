package comandos;
import excepciones.ArrayException;
import excepciones.ExecutionErrorException;
import principal.Engine;

public class Run implements Command{
	
	/**Funcion que ejecuta el run.
	 * @param engine
	 * @throws ExecutionErrorException
	 * @throws ArrayException 
	 * */
	public void execute(Engine engine) throws ExecutionErrorException, ArrayException{
		engine.runProgram();
	}
	
	/**@param nombre[]
	 * @return Si nombre[0] es "RUN", devuelve el comando Run. Si no, devuelve null
	 * */
	public Command parse(String[] nombre){
		if(nombre.length == 1 && nombre[0].equalsIgnoreCase("RUN"))
			return new Run();
		else return null;		
	}

	@Override
	public String textHelp() {
		return "	RUN: Ejecuta el programa " + System.getProperty("line.separator");				
	}

	public String toString(){return "RUN:";}

}
