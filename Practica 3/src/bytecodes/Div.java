package bytecodes;
import excepciones.DivByZeroException;
import excepciones.ExecutionErrorException;
import principal.CPU;

/**Realiza el parseo y la ejecucion del Bytecode Div*/
public class Div extends Arithmetics{

	@Override
	/**Parsea el bytecode "DIV"
	 * @param nombre[]
	 * @return ByteCode si se ha podido realizar. Si no, devuelve null.*/
	public ByteCode parse(String[] nombre) {
		if(nombre.length == 1 && nombre[0].equalsIgnoreCase("DIV"))
			return new Div();
		else return null;
	}

	/**Llama a la funcion cpu.push(n2/n1) si n1!=0
	 * @param cpu
	 * @param n1. Cima.
	 * @param n2. Subcima.
	 * @throws ExecutionErrorException */
	public void operar(CPU cpu, int n1, int n2) throws ExecutionErrorException {
	    if(n1==0)
	    	throw new DivByZeroException("Error. No puede dividir por 0.");  
	    cpu.push(n2/n1);
	}



	public String toStringAux(){
		return "DIV";
	}
}
