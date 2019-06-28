package instrucciones;

import excepciones.ArrayException;
import excepciones.LexicalAnalysisException;
import programa.Compiler;
import programa.LexicalParser;
import programa.ParsedProgram;

public class IfThen implements Instruction {
	/**Condicion del if*/
	private Condition condition;
	/**Cuerpo del if*/
	private ParsedProgram ifBody;

	public IfThen() {}
	
	public IfThen(Condition cond, ParsedProgram body) {
		this.condition = cond;
		this.ifBody = body;
	}
	
	/**Comprueba que la instruccion introducida es correcta
	 * @param words. String[].
	 * @param lexParser. LexicalParser.
	 * @return Condition de Ifthen si se ha podido parsear, null si no.
	 * @throws ArrayException*/
	public Instruction lexParse(String[] words, LexicalParser lexParser) throws ArrayException{
		if(words.length == 4 && words[0].equalsIgnoreCase("IF"))
		{
			Condition cond = ConditionParser.parse(words[1], words[3], words[2], lexParser);
			ParsedProgram ifBody = new ParsedProgram();
			
		 	try {
				lexParser.lexicalParser(ifBody, "ENDIF");
			 	lexParser.increaseProgramCounter();
			} catch (LexicalAnalysisException e) {
				return null;
			}
		 	return new IfThen(cond, ifBody);
		}  
				
			else
				return null;
	 }      
	 
	/** Funcion que compila la instruccion IfThen. Anade los terminos y la condicion al bcProgram.
	 * Despues compila el cuerpo del IfThen y al final edita el parametro del salto condicional.
	 * @param compiler.
	 * @throws ArrayException*/
	 public void compile(Compiler compiler) throws ArrayException {
		 
		 this.condition.compile(compiler);
		 compiler.compile(this.ifBody);
		 this.condition.setJump(compiler.getProgramCounter());
	 }

	 public String toString(){
		 return "IFTHEN";
	 }
	 
}
