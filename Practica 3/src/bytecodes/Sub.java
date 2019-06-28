package bytecodes;
import excepciones.StackException;
import principal.CPU;

public class Sub extends Arithmetics{

	@Override
	/**Llama a la funcion cpu.push(n2-n1)
	 * @param cpu
	 * @param n1. Cima.
	 * @param n2. Subcima.
	 * @throws StackException*/
	public void operar(CPU cpu, int n1, int n2) throws StackException {
		cpu.push(n2-n1);
	}
	
	@Override
	/**Parsea el bytecode "SUB"
	 * @param nombre[]
	 * @return ByteCode si se ha podido realizar. Si no, devuelve null.*/
	public ByteCode parse(String[] nombre) {
		if(nombre.length == 1 && nombre[0].equalsIgnoreCase("SUB"))
			return new Sub();
		else return null;

	}
	
	public String toStringAux(){return "SUB";}

}
