package bytecodes;
import excepciones.StackException;
import principal.CPU;

/**Engloba todos los bytecodes condicionales*/
abstract public class ConditionalJumps extends ByteCodesOneParameter { 
	
	
	public ConditionalJumps(){super(0);}
	public ConditionalJumps(int j){super(j);}

	@Override
	/** Saca dos elementos de la pila (si hay más de dos), y hace la comparación que le corresponda.
	 * Si no se cumple la condición de la comparación, iba a la instruccion param. Si se cumple, incrementa
	 * el contador de programa
	 * @param cpu
	 * @throws StackException*/
	public void execute(CPU cpu) throws StackException { 
			int n2, n1;
			n1= cpu.pop();
			n2= cpu.pop();
			if (!compare(n2,n1)) cpu.setProgramCounter(this.param); 
			else cpu.increaseProgramCounter();
	}

	abstract protected boolean compare(int n1, int n2);
	
	public void setN(int n) {
		  this.param = n;
	} 
}

