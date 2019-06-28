package bytecodes;


public class Ifneq extends ConditionalJumps {
	
	public Ifneq(){}
	
	public Ifneq(int i){
		super(i);
	}
	
	@Override
	/** @param n1
	 * @param n2
	 * @return n1!=n2*/
	protected boolean compare(int n1, int n2) {return n1!=n2;}

	@Override
	/**@param string1
	 * @param string2
	 * @return Si es IFNEQ la instruccion dada, devuelve un ByteCode. Si no, devuelve null
	 * */
	protected ByteCode parseAux(String string1, String string2) {
		if(string1.equalsIgnoreCase("IFNEQ"))
			return new Ifneq(Integer.parseInt(string2));
		else return null;
	}

	@Override
	protected String toStringAux() {return "IFNEQ";}

}
