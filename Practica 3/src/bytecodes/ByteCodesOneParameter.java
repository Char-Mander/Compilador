package bytecodes;

/**Engloba todos los bytecodes que tienen un parametro*/
public abstract class ByteCodesOneParameter implements ByteCode {
	/**Parametro del ByteCode*/
	protected int param;
	
	public ByteCodesOneParameter(){};
	
	public ByteCodesOneParameter(int p){ this.param = p; }
	
	@Override
	/**Comprueba que el ByteCode introducido tenga parametro
	 * @param nombre[]. Linea introducida para parsear.
	 * @return parseAux. Parseo auxiliar del ByteCode correspondiente. 
	 * Si no existe devuelve null.*/
	public ByteCode parse(String[] nombre) {
		if (nombre.length!=2) return null;
		else return this.parseAux(nombre[0],nombre[1]);
	}
	
	abstract protected ByteCode parseAux(String string1, String string2);
	
	abstract protected String toStringAux();
	
	public String toString(){
		return this.toStringAux() + " " + this.param;
	}
}

