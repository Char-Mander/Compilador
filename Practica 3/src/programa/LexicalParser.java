package programa;

import excepciones.ArrayException;
import excepciones.LexicalAnalysisException;
import instrucciones.Instruction;
import instrucciones.ParserInstruction;

public class LexicalParser {
	/**Programa fuente*/
	private SourceProgram sProgram; 
	/**Contador del programa fuente*/
	private int programCounter;
		
	public LexicalParser(SourceProgram sP) {
		this.sProgram = sP;
		this.programCounter = 0;
	}
	
	/**Se encarga de la generacion del programa parseado.
	 * @param pProgram. Programa parseado.
	 * @param stopkey. Palabra que indica el fin de la generacion del programa.
	 * @throws ArrayException
	 * @throws LexicalAnalysisException*/
	public void lexicalParser(ParsedProgram pProgram, String stopKey) throws ArrayException, LexicalAnalysisException{
		boolean stop = false;
		
		while (this.programCounter < sProgram.getNumeroInstrucciones() && !stop){
			String instr = this.sProgram.getInstruction(this.programCounter);
			if (instr.equalsIgnoreCase(stopKey)){
				stop = true;
			}    
			else {      
				Instruction instruction = ParserInstruction.parse(instr,this);
				if(instruction==null)
					throw new LexicalAnalysisException("Error. La instruccion no es correcta.");
				pProgram.anadirInstruccion(instruction);
			}
		}
	}
	
	/**Incrementa el contador del programa*/
	public void increaseProgramCounter(){   
		this.programCounter++; 
	} 
	
}