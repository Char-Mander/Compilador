package instrucciones;

import excepciones.ArrayException;
import programa.Compiler;
import programa.LexicalParser;
import bytecodes.ConditionalJumps;

public abstract class Condition {
	/**Terminos t1 y t2 de la clase Term. (Pueden ser variables o numeros)*/
	 private Term t1;
	 private Term t2;
	 /**Condicion del tipo ConditionalJumps. Sirve exclusivamente para la compilacion.*/
	 private ConditionalJumps condition; 
	  
	 public Condition() {}
	 
	 public Condition(Term term1, Term term2){
		 this.t1 = term1;
		 this.t2 = term2;
	 }
	 
	 /** @param t1
	  * @param op
	  * @param t2
	  * @param parser
	  * @return this.parseAux(term1, term2, op, parser);
	  * Funcion que anade los dos terminos al array de Terminos.
	  * */
	 public Condition parse(String t1, String op, String t2, LexicalParser parser){
		 Term term1, term2;
		 term1 = TermParser.parse(t1);
		 term2 = TermParser.parse(t2);
		 return this.parseAux(term1, term2, op, parser);
	 }    
	 
	 /**@param compiler
	  * @throws ArrayException
	  * Funcion que compila la condicion.
	  * Anade los terminos t1 y t2 al array de bcProgram(lo que ha devuelto el termino 
	  * (que esta en pProgram).
	  * Después anade la condicion (del tipo ConditionalJumps) al bcProgram
	  * 
	  * */
	public void compile(Compiler compiler) throws ArrayException {
		compiler.addByteCode(this.t1.compile(compiler));
		compiler.addByteCode(this.t2.compile(compiler));
		this.condition = this.compileOp();
		compiler.addByteCode(this.condition);
	}
	 
	protected abstract ConditionalJumps compileOp();

	public abstract Condition parseAux(Term t1, Term t2, String op, LexicalParser parser);

	/**@param programCounter
	 * Funcion que, con el contador del programa, salta a otra condicion*/
	public void setJump(int programCounter) {
		this.condition.setN(programCounter);
	}

}
