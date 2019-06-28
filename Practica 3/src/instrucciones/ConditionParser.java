package instrucciones;

import programa.LexicalParser;

public class ConditionParser {
	/**Inicializa las distintas condiciones para parsearlas.*/
	private final static Condition[] conditions = { new Equal(), new Less(), new LessEq(), new NotEqual() };
			
	/**@param t1
	 * @param t2
	 * @param op
	 * @param lexParser
	 * @return c (que sera la condicion parseada)
	 * Funcion que parsea las condiciones
	 * */
	public static Condition parse(String t1, String t2, String op, LexicalParser lexParser) {
		boolean encontrado = false;
		int i = 0;
		Condition c = null;
		while (i < conditions.length && !encontrado){
			c = conditions[i].parse(t1, op, t2, lexParser); 
			if (c != null) encontrado = true;
			else i++;
		}
		return c;
	}
}
