package bytecodes;
import principal.CPU;

public class Halt implements ByteCode {

	@Override
	/**Incrementa el contador de programa, e introduce la instruccion "Halt" (que hará que no
	 * se ejecuten mas instrucciones en el programa).
	 * @param cpu*/
	public void execute(CPU cpu) {
		cpu.increaseProgramCounter();
		cpu.setHalt();
	}

	@Override
	/**@param nombre[]
	 * @return Si nombre[0] es "HALT", devuelve la ejecución el Halt. Si no, devuelve null
	 * */
	public ByteCode parse(String[] nombre) {
		if(nombre.length==1 && nombre[0].equalsIgnoreCase("HALT"))
			return new Halt();
		else	return null;
	}
	
	public String toString(){ return "HALT"; }

}
