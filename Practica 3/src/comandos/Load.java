package comandos;

import java.io.FileNotFoundException;

import excepciones.ArrayException;
import principal.Engine;

public class Load implements Command{
	private String nombre;
	public Load() {}
	
	public Load(String nombre1){
		this.nombre = nombre1;
	}
	
	@Override
	/**Ejecuta la funcion que carga el fichero de texto.
	 * @param engine 
	 * @throws ArrayException
	 * @throw FileNotFoundException*/
	public void execute(Engine engine) throws ArrayException, FileNotFoundException{
		engine.loadFich(this.nombre);
	}

	@Override
	/**@param nombre[]
	 * @return Si nombre[0] es "LOAD", devuelve el comando Load. Si no, devuelve null
	 * */
	public Command parse(String[] nombre) {
		if(nombre.length == 2 && nombre[0].equalsIgnoreCase("LOAD"))
			return new Load(nombre[1]);
		else return null;	
	}

	@Override
	public String textHelp() {
		return "	LOAD FICH: carga el fichero de nombre FICH como programa fuente."
				+ " No realiza ningun tipo de comprobacion sintactica." + System.getProperty("line.separator");
	}
	
	public String toString(){
		return "LOAD" + " " + this.nombre;
	}
}
