package comandos;

import excepciones.ArrayException;
import excepciones.BadFormatByteCodeException;
import principal.Engine;

public class Replacebc implements Command {
	private int pos;
	
	public Replacebc( int pos1){
	this.pos=pos1;
	}
	
	public Replacebc() { }

	/**Funcion que ejecuta el replace
	 * @param engine
	 * @throws ArrayException
	 * @throws BadFormatByteCodeException
	 * */
	public void execute(Engine engine) throws ArrayException, BadFormatByteCodeException{ 
		engine.replaceByteCode(this.pos); 
	}

	/**@param nombre[]
	 * @return Si nombre[0] es "REPLACE", devuelve el comando Replace. Si no, devuelve null
	 * */
	public Command parse(String[] nombre){
		if(nombre.length == 2 && nombre[0].equalsIgnoreCase("REPLACE"))
			return new Replacebc(Integer.parseInt(nombre[1]));
		else return null;		
	}

	@Override
	public String textHelp() {
	return "	REPLACE N: Reemplaza la instruccion N por la solicitada al usuario"+ System.getProperty("line.separator");
		}

	public String toString(){return "REPLACE:";}

}

