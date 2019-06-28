package programa;

import excepciones.ArrayException;
import instrucciones.Instruction;
import bytecodes.ByteCodeProgram;
import bytecodes.ByteCode;

public class Compiler {
	 private ByteCodeProgram bcProgram;
	 private String[] varTable;
	 private int numVars;
	 private final int MAX = 100;
	 
	 public Compiler(ByteCodeProgram bcP){
		 this.bcProgram = bcP;
		 this.varTable = new String[this.MAX];
		 this.numVars = 0;
	 }
	  
	 /** Ejecuta una a una la compilacion de las instrucciones
	  * @param pProgram. Programa parseado.
	  * @throws ArrayException*/
	 public void compile(ParsedProgram pProgram) throws ArrayException {
		 int i = 0;
		 while (i < pProgram.getNumeroInstrucciones()){ 
			 Instruction inst = pProgram.getInstruction(i); 
			 inst.compile(this); 
			 i++;      
		 }    
	 }
	  
	 /** Llama a la funcion que anyade un bytecode al ByteCodeProgram
	  * @param b. Bytecode a introducir
	  * @throws ArrayException*/
	 public void addByteCode(ByteCode b) throws ArrayException {
		 this.bcProgram.anadirByteCode(b);
	 }
	 
	 /**Anyade una nueva variable al vector
	  * @param varName. Variable que se quiere introducir
	 * @throws ArrayException */
	 public void addVariable(String varName) throws ArrayException{
		 if(this.numVars == this.MAX)
			 throw new ArrayException("Error: no se pueden anadir mas variables al programa.");
		 this.varTable[this.numVars]=varName;
		 this.numVars++;
	 }
	  
	 /**Busca la posicion de la variable indicada. Si no la 
	  * encuentra la anyade al vector de variables
	  * @param varName. Nombre de la variable.
	  * @return i. Posicion de la variable en el vector.
	 * @throws ArrayException */
	 public int getIndex(String varName) throws ArrayException{
		 int i = 0;
		 boolean encontrado = false;
		 while(i < this.numVars && !encontrado){
			 if(this.varTable[i].equalsIgnoreCase(varName))
				encontrado = true;
			 else
				++i;
		 }
		 if (!encontrado)
			 this.addVariable(varName);
		 
		 return i;
	 }

	 public int getProgramCounter() { return this.bcProgram.getNumeroInstrucciones(); }
	

}
