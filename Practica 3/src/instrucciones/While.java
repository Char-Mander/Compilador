package instrucciones;

import excepciones.ArrayException;
import excepciones.LexicalAnalysisException;
import programa.Compiler;
import programa.LexicalParser;
import programa.ParsedProgram;
import bytecodes.GoTo;

public class While implements Instruction {
	private Condition condition;
	private ParsedProgram whileBody;
	
	public While() {}
	
	public While(Condition cond, ParsedProgram body) {
		this.condition = cond;
		this.whileBody = body;
	}
	
	/**Comprueba que la instruccion introducida es correcta
	 * @param words. String[].
	 * @param lexParser. LexicalParser.
	 * @return Condition de While si se ha podido parsear, null si no.
	 * @throws ArrayException*/
	public Instruction lexParse(String[] words, LexicalParser lexParser) throws ArrayException{
		 if(words.length == 4 && words[0].equalsIgnoreCase("WHILE")){
			 
			Condition cond = ConditionParser.parse(words[1], words[3], words[2], lexParser);
			ParsedProgram wBody = new ParsedProgram(); 
			
			try {
				lexParser.lexicalParser(wBody, "ENDWHILE");
				lexParser.increaseProgramCounter();
			} catch (LexicalAnalysisException e) {
					return null;
			}  
			return new While(cond, wBody);
		 }
		 else{
			 return null;
		  }
	}
	
	@Override
	/** Funcion que compila la instruccion IfThen. Anade los terminos y la condicion al bcProgram.
	 * Despues compila el cuerpo del While, anade un Goto al inicio del While y al final
	 *  edita el parametro del salto condicional.
	 * @param compiler.
	 * @throws ArrayException*/
	public void compile(Compiler compiler) throws ArrayException {
		int aux = compiler.getProgramCounter();
		 this.condition.compile(compiler);
		 compiler.compile(this.whileBody);
		 compiler.addByteCode(new GoTo(aux));
		 this.condition.setJump(compiler.getProgramCounter());
	}

}
