package bytecodes;

import excepciones.ExecutionErrorException;
import principal.CPU;

/**Engloba todas las operaciones aritmeticas*/
public abstract class Arithmetics implements ByteCode {

	public abstract ByteCode parse (String[] words);
	
	/**Extrae los operandos de la pila y llama a la operacion necesaria
	 * @param cpu
	 * @throws DivByZeroException
	 * @throws StackException*/
	public  void execute(CPU cpu) throws ExecutionErrorException{
		int n1, n2;
		n1 = cpu.pop();
		n2 = cpu.pop();
		cpu.increaseProgramCounter();
		this.operar(cpu,n1,n2);
	}
	
	/**@throws ExecutionErrorException*/
	abstract protected void operar(CPU cpu, int n1, int n2) throws ExecutionErrorException;

	abstract protected String toStringAux();
	
	public String toString(){return this.toStringAux();}

}
