package principal;
import excepciones.ArrayException;
import excepciones.ExecutionErrorException;
import excepciones.StackException;
import bytecodes.ByteCode;
import bytecodes.ByteCodeProgram;

public class CPU {
	/**Memoria de la CPU.*/
	private Memory memory;
	/**Pila de la CPU.*/
	private OperandStack stack;
	/**Indica la siguiente instruccion a ejecutar*/
	private int programCounter = 0;
	/**Indica si se ha ejecutado la instruccion halt*/
	private boolean halt;
	/**Programa*/
	private ByteCodeProgram bcProgram = new ByteCodeProgram();

	public CPU(ByteCodeProgram program){ 
		this.bcProgram = program;
		this.stack = new OperandStack();
		this.memory = new Memory();
	} 

	/**Convierte el booleano halt a true.*/
	public void setHalt() {this.halt=true;}
	

	/**Accesora del contador de la pila.
	 * @return contador.*/
	public int getSizeStack() {return this.stack.getContador();}

	/**Hace un pop en la pila.
	 * @return numero. El numero de la cima de la pila.
	 * @throws StackException */
	public int pop() throws StackException { return this.stack.pop();} 

	/**Introduce en la pila un valor.
	 * @param i. Valor que se quiere introducir.
	 * @return push(i). Indica si se ha podido introducir.
	 * @throws StackException */
	public void push(int i) throws StackException { stack.push(i); }

	/**Lee de memoria
	 * @param param. Posicion que se quiere leer.
	 * @return memory.read(param). Valor leido de la memoria.*/
	public int read(int param) {return memory.read(param);}

	/**Escribe en memoria
	 * @param param. Posicion en la que se quiere escribir.
	 * @param value. Valor que se quiere introducir.
	 * @return memory.write(param, value). Sera true si la posicion es correcta y false si no.
	 * @throws ArrayException */
	public void write(int param, int value) throws ArrayException {this.memory.write(param, value);} 

	/**Edita el contador del programa.
	 * @param jump. Posicion a la que se quiere saltar.*/
	public void setProgramCounter(int jump) { this.programCounter = jump; } 

	/**Incrementa el contador del programa*/
	public void increaseProgramCounter() { ++this.programCounter; }
	
	/**Resetea la pila y la memoria.*/
	public void reset(){
		this.memory.reset();
		this.stack.reset();
	}

	/**Ejecuta el programa almacenado.
	 * @throws DivByZeroException 
	 * @throws StackException */
	public void run() throws ArrayException, ExecutionErrorException {
		this.programCounter=0;
		this.halt=false;

		while (this.programCounter < bcProgram.getNumeroInstrucciones() && !this.halt) {
			ByteCode bc = bcProgram.getByteCodeProgram(this.programCounter);
			bc.execute(this);
		}
	}
	
	public String toString(){ 
		 String s = System.getProperty("line.separator") +
				 "Estado de la CPU: " + System.getProperty("line.separator") +
				 "Memoria: " + this.memory + System.getProperty("line.separator") + 
				 "Pila: " + this.stack + System.getProperty("line.separator");
		 	return s;
	}

}
