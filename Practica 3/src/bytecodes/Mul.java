package bytecodes;
import excepciones.StackException;
import principal.CPU;

/**Realiza el parseo y la ejecucion del Bytecode Mul*/
public class Mul extends Arithmetics{
	
	/**Llama a la funcion cpu.push(n1*n2)
	 * @param cpu
	 * @param n1. Cima.
	 * @param n2. Subcima.
	 * @return true
	 * @throws StackException */
	public void operar(CPU cpu, int n1, int n2) throws StackException {
		cpu.push(n1*n2);
	}
	
	@Override
	/**Parsea el bytecode "MUL"
	 * @param nombre[]
	 * @return ByteCode si se ha podido realizar. Si no, devuelve null.*/
	public ByteCode parse(String[] nombre) {
		if(nombre.length == 1 && nombre[0].equalsIgnoreCase("MUL"))
			return new Mul();
		else return null;

	}
	
	public String toStringAux(){return "MUL";}
}
