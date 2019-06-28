package programa;

import excepciones.ArrayException;

public class SourceProgram {
	/**Array del programa fuente*/
	private String[] sProgram;
	/**Contador del programa*/
	private int cont;
	/**Tamano maximo del array*/
	private final int MAX = 100;
	
	public SourceProgram(){
		this.sProgram = new String[this.MAX];
		this.cont = 0;
	}
	
	/**Resetea el programa fuente.*/
	public void inicializar(){
		if(this.cont>0) this.cont=0;
	}
	
	/**Anade una nueva linea de codigo al array
	 * @param ins. String.
	 * @throws ArrayException*/
	public void addInst(String ins) throws ArrayException{
		if(this.cont==MAX)
			throw new ArrayException("Error. No se pueden anadir mas instrucciones.");
		this.sProgram[this.cont] = ins;
		++this.cont;
	}

	/**@return contador.*/
	public int getNumeroInstrucciones() {
		return this.cont;
	}

	/**@param programcounter. Posicion del array.
	 * @return sProgram[programCounter]. Linea del programa
	 *  fuente de la posicion programCounter.*/
	public String getInstruction(int programCounter) {
		return this.sProgram[programCounter];
	}
	
	public String toString(){
		String s = "Programa fuente almacenado: " + System.getProperty("line.separator");
		for(int i = 0; i < this.cont; ++i)
			s += "[" + i + "]: "+ this.sProgram[i] + System.getProperty("line.separator");
		return s;
	}
}
