package bytecodes;
import excepciones.StackException;
import principal.CPU;

/**Realiza el parseo y la ejecucion del Bytecode Add*/
public class Add extends Arithmetics{

	
	/**Parsea el bytecode "ADD"
	 * @param nombre[]
	 * @return ByteCode si se ha podido realizar. Si no, devuelve null.*/
	public ByteCode parse(String[] nombre) {
		if(nombre.length == 1 && nombre[0].equalsIgnoreCase("ADD"))
			return new Add();
		else return null;
	}
	
	@Override
	/**Llama a la funcion cpu.push(n1+n2)
	 * @param cpu
	 * @param n1. Cima.
	 * @param n2. Subcima.
	 * @return true
	 * @throws StackException*/
	public void operar(CPU cpu, int n1, int n2) throws StackException {
		cpu.push(n1+n2);
	}
	
	public String toStringAux(){return "ADD";}
	
}
