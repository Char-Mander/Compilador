package bytecodes;


/**Parsea un ByteCode introducido*/
public class ByteCodeParser {
	
	/**Inicializa los distintos ByteCodes para parsearlos.*/
	private final static ByteCode[] bytecodes = {new Add(), new Sub(), new Mul(), 
		new Load(), new Store(), new Div(), new Halt(), new Push(), new GoTo(), 
		new Ifeq(), new Ifneq(), new Ifle(), new Ifleq(), new Out()};
		
	/**Le entra una linea a parsear con todos los ByteCodes
	 * @param line. Bytecode introducido por teclado.
	 * @return c. ByteCode parseado (null si da error).*/
	public static ByteCode parse(String line) {
		boolean found = false;
		int i=0;
		ByteCode c = null;
		line = line.trim();
			while (i < bytecodes.length && !found){
				try{
				c = bytecodes[i].parse(line.split(" +")); 
				}catch (NumberFormatException e){
					return null;
				}
				if (c!=null) found=true;
				else i++;
		}
		return c; 
	}
	
}
