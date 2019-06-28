package programa;

import excepciones.ArrayException;
import instrucciones.Instruction;

public class ParsedProgram {
	/**Array de instrucciones del parsedProgram*/
	private Instruction[] pProgram;
	/**Contador de elementos*/
	private int cont;
	/**Tamano maximo del array del ParsedProgram*/
	private final int MAX = 100;

	public ParsedProgram(){
		this.pProgram = new Instruction[this.MAX];
		this.cont = 0;
	}
	
	/**Funcion que inicializa el array del parsedProgram, poniendo el contador a 0, si no lo estaba ya.*/
	public void inicializar(){
		if(this.cont > 0) this.cont = 0;
	}
	
	/**@param instruction
	 * @throws ArrayException
	 * Funcion que, si el contador del array es igual que el tamano de este, crea una ArrayExcepcion.
	 * Si no, anade la instruccion que le entra como parametro al programa (en la posicion donde esta el 
	 * contador), y aumenta el contador.
	 * */
	public void anadirInstruccion(Instruction instruction) throws ArrayException{
		if(this.cont == MAX) throw new ArrayException("Error. No se pueden anadir mas instrucciones.");
		else{
			this.pProgram[this.cont] = instruction;
			this.cont++;
		}
	}

	
	/**@return this.cont
	 * Funcion que devuelve el contador del parsedProgram*/
	public int getNumeroInstrucciones() { return this.cont; }

	/**@param i
	 * @return this.pProgram[i]
	 * Funcion que, recibiendo una posicion, devuelve el elemento del parsedProgram que esta
	 * en dicha posicion.
	 * */
	public Instruction getInstruction(int i) { return this.pProgram[i]; }
}
