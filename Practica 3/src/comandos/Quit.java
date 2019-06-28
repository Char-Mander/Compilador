package comandos;
import principal.Engine;

public class Quit implements Command {
	
	public Quit(){
		super();
	}
	
	/**Termina la ejecucion de la maquina virtual
	 * @param engine*/
	public void execute(Engine engine){
		engine.quitProgram();
	}
	
	/**@param nombre[]
	 * @return Si nombre[0] es "QUIT", devuelve el comando Quit. Si no, devuelve null
	 * */
	public Command parse(String[] nombre){
		if(nombre.length == 1 && nombre[0].equalsIgnoreCase("QUIT"))
			return new Quit();
		else return null;		
	}

	@Override
	public String textHelp() {
		return "	QUIT: Cierra la aplicacion " + System.getProperty("line.separator");
			}

	public String toString(){return "QUIT:";}

}
