package comandos;

public class CommandParser { 
	/**Inicializa los distintos Comandos para parsearlos.*/
	private final static Command[] commands = {new Help(), new Quit(),
	new Replacebc(),new Run(), new Load(), new Compile()};
	
	/**Le entra una linea a parsear con todos los Comandos
	 * @param line. Comando introducido por teclado.
	 * @return c. Comando parseado (null si da error).*/
	public static Command parse(String line) {
		boolean found = false;
		int i=0;
		Command c = null;
		line = line.trim();
		while (i < commands.length && !found){
			c = commands[i].parse(line.split(" +")); 
			if (c!=null) found=true;
			else i++;
		}
		return c;
	}
		
	public static void showHelp() {
		for (int i=0; i < CommandParser.commands.length; i++)
		System.out.print(CommandParser.commands[i].textHelp()); 
	}	
}