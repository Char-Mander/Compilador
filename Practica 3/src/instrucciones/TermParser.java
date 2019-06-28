package instrucciones;

public class TermParser {
	
	/**Inicializa los distintos terminos para parsearlos.*/
	private final static Term[] terms = { new Variable(), new Number()};
			
	/**@param line
	 * @return c (que sera el termino parseado)
	 * Funcion que parsea los terminos.
	 * */
	public static Term parse(String line) {
		boolean encontrado = false;
		int i = 0;
		Term c = null;
		line = line.trim();
		while (i < terms.length && !encontrado){
			c = terms[i].parse(line); 
			if (c != null) encontrado = true;
			else i++;
		}
		return c;
	}
}
