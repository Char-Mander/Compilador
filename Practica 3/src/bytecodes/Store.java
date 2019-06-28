package bytecodes;
import excepciones.ArrayException;
import excepciones.StackException;
import principal.CPU;

public class Store extends ByteCodesOneParameter {
	
	public Store(){}
	
	public Store(int i){super(i);}
	@Override
	/** Incrementa el contador de programa, Y escribe en la memoria en la posición dada, y saca
	 * el elemento de la cima de la pila
	 * @param cpu
	 * @throws ExecutionErrorException*/
	public void execute(CPU cpu) throws StackException, ArrayException {
		cpu.increaseProgramCounter();
		cpu.write(this.param, cpu.pop());
	}
	
	@Override
	/**@param string1
	 * @param string2
	 * @return Si es STORE la instruccion dada, devuelve un ByteCode. Si no, devuelve null
	 * */
	protected ByteCode parseAux(String string1, String string2) {
		if(string1.equalsIgnoreCase("STORE"))
			return new Store(Integer.parseInt(string2));
		else return null;
	}

	@Override
	protected String toStringAux() {return "STORE";}

}
