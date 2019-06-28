package bytecodes;

import excepciones.StackException;
import principal.CPU;

public class Load extends ByteCodesOneParameter {

	public Load(){}
	
	public Load(int i){super(i);}
		
	@Override
	/** Incrementa el contador de programa, y mete en la pila el elemento que está 
	 * en la posición dada de la memoria
	 * @param cpu
	 * @throws StackException*/
	public void execute(CPU cpu) throws StackException {
		cpu.increaseProgramCounter();
		cpu.push(cpu.read(this.param));
	}
	
	@Override
	/**@param string1
	 * @param string2
	 * @return Si es LOAD la instruccion dada, devuelve un ByteCode. Si no, devuelve null
	 * */
	protected ByteCode parseAux(String string1, String string2) {
		if(string1.equalsIgnoreCase("LOAD"))
			return new Load(Integer.parseInt(string2));
		else return null;
	}

	@Override
	protected String toStringAux() {return "LOAD";}

}
