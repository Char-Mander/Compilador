package comandos;
import principal.Engine;

public class Help implements Command{

	/**Ejecuta la funcion que muestra el Help.
	 * @param engine */
	public void execute(Engine engine){
	 Engine.showHelp();
	}
	
	/**@param nombre[]
	 * @return Si nombre[0] es "HELP", devuelve el comando Help. Si no, devuelve null
	 * */
	public Command parse(String[] nombre){
		if(nombre.length == 1 && nombre[0].equalsIgnoreCase("HELP"))	
			return new Help();
		else return null;
	}

	@Override
	public String textHelp() {
	return 	"	HELP: Muestra esta ayuda " + System.getProperty("line.separator");
	}
	
	public String toString(){return "HELP:";}
}
