package bytecodes;
import excepciones.StackException;
import principal.CPU;

public class Out implements ByteCode {
	
	/**Incrementa el contador de programa, y muestra la cima.
	 * @param cpu
	 * @throws StackException */
	@Override
	public void execute(CPU cpu) throws StackException {
		cpu.increaseProgramCounter();
		System.out.println("Consola: " + cpu.pop());
	}

	@Override
	/**@param nombre[]
	 * @return Si nombre[0] es "OUT", devuelve la ejecución el Halt. Si no, devuelve null
	 * */
	public ByteCode parse(String[] nombre) {
		if(nombre.length==1 && nombre[0].equalsIgnoreCase("OUT"))
			return new Out();
		else	return null;
	}
	
	public String toString(){ return "OUT"; }

}
