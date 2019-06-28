package bytecodes;
import principal.CPU;

public class GoTo extends ByteCodesOneParameter {

	public GoTo(){}
	
	public GoTo(int i){super(i);}	
	
	@Override
	/** Pasa a ejecutarse la instruccion que está en la posicion param
	 * @param cpu*/
	public void execute(CPU cpu) {
		cpu.setProgramCounter(this.param);
	}
	
	@Override
	/**@param string1
	 * @param string2
	 * @return Si es GOTO la instruccion dada, devuelve un ByteCode. Si no, devuelve null
	 */
	protected ByteCode parseAux(String string1, String string2) {
		if(string1.equalsIgnoreCase("GOTO"))
			return new GoTo(Integer.parseInt(string2));
		else return null;
	}

	@Override
	protected String toStringAux() {
	 return "GOTO";
	}
}
