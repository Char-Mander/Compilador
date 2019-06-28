package instrucciones;

import bytecodes.ConditionalJumps;
import bytecodes.Ifleq;
import programa.LexicalParser;

public class LessEq extends Condition {

	public LessEq() {}
	
	public LessEq(Term t1, Term t2){
		super(t1, t2);
	}
	
	/**Devuelve el ConditionalJumps correspondiente a 
	 * una instruccion while o ifthen. La inicializa en 0
	 * a la espera de ser editada despues
	 * @return Ifle(0)*/
	protected ConditionalJumps compileOp(){
		 return new Ifleq(0);
	}
	
	@Override
	/**Realiza el parseo de la instruccion
	 * @param t1. Term.
	 * @param t2. Term.
	 * @param op. String.
	 * @param parser. LexicalParser
	 * @return null si no coincide con el operando, new Equal si coincide*/
	public Condition parseAux(Term t1, Term t2, String op, LexicalParser parser) {
		if(!op.equalsIgnoreCase("<="))
			return null;
		else {
			parser.increaseProgramCounter();
			return new LessEq(t1, t2);
		}
	}
	
	public String toString(){
		return "LESSEQ";
	}


}
