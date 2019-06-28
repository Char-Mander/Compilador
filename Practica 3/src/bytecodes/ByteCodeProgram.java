package bytecodes;

import excepciones.ArrayException;


public class ByteCodeProgram { 
	/**Atributo que contiene los ByteCodes a ejecutar*/
	private ByteCode[] program;
	/**Controla el numero de instrucciones que tiene el programa*/
	private Integer contador;
	/**Maximo de instrucciones que se pueden escribir*/
	private final static int MAX_INSTRUCTIONS = 100;

	/**Constructora que inicializa los atributos del programa*/
	public ByteCodeProgram(){
		this.program = new ByteCode[MAX_INSTRUCTIONS];
		this.contador = 0;
	}
	
	/**Inicializa el contador y el tamano para el comando RESET*/
	public void inicializar(){
		if(this.contador > 0)	
			this.contador = 0;	
	}
	
	/**Introduce una nueva instruccion ByteCode.
	 * @param instruction. ByteCode que se quiere anadir.
	 * @throws ArrayException*/
	public void anadirByteCode(ByteCode instruction) throws ArrayException{
		if(this.contador == MAX_INSTRUCTIONS){
			throw new ArrayException("Error. No se pueden anadir mas instrucciones");
		}
		else{
			this.program[this.contador] = instruction;
			this.contador++;
		}
	}
	
	/**Si la posicion introducida es correcta, se cambiara la instruccion antigua por la nueva
	 * @param instruction. Nueva instruccion a introducir.
	 * @param pos. Posicion en la que se quiere introducir.
	 * @throws ArrayException*/
	public void instruccionEnPosDada(ByteCode instruction, int pos)throws ArrayException{
		if(pos >= 0 && pos < this.contador) 
			this.program[pos] = instruction;
		else 
			this.anadirByteCode(instruction);
	}
	
	/**Accesora que devuelve lo que hay en pos
	 * @param pos. Posicion de la instruccion que se quiere adquirir.
	 * @return program[pos]. Bytecode de la posicion dada.*/
	public ByteCode getByteCodeProgram(int pos){ return this.program[pos]; }
	
	/**Accesora del contador del programa.
	 * @return contador.*/
	public Integer getNumeroInstrucciones(){return this.contador;}
		
	public String toString(int pos){
		String s = "";
		
		s += "El estado de la maquina tras ejecutar el bytecode " + this.program[pos] + " es: ";
		return s;
	}
}


