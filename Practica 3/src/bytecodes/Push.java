package bytecodes;
import excepciones.StackException;
import principal.CPU;

public class Push extends ByteCodesOneParameter{
	
	public Push(){}
	
	public Push(int i){super(i);}
	
	
	@Override
	/** Aumenta el contador de programa
	 * @param cpu
	 * @throws StackException*/
	public void execute(CPU cpu) throws StackException {
		cpu.increaseProgramCounter();
		cpu.push(this.param);
	}
	
	@Override
	/**@param string1
	 * @param string2
	 * @return Si es PUSH la instruccion dada, devuelve un ByteCode. Si no, devuelve null
	 * */
	protected ByteCode parseAux(String string1, String string2) {
		if(string1.equalsIgnoreCase("PUSH"))
			return new Push(Integer.parseInt(string2));
		else return null;
	}

	@Override
	protected String toStringAux() {return "PUSH";}

}
