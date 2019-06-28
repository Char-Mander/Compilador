package principal;

import excepciones.StackException;

public class OperandStack {	
	/**Tamanyo maximo de la pila */
	final static int TAMANO_PILA = 100; 
	/**Array de la pila*/ 
	private int[] stack; 
	/**Contador de elementos de la pila*/
	private int contador;
	
	/** En esta constructora se crea el array de la pila de tamano TAMANO_PILA
	y se pone el contador de elementos a 0*/
	public OperandStack(){
		this.stack=new int[TAMANO_PILA];
		this.contador=0;
	}
	
	/** Esta funcion realiza la tarea del push*/
	 /**Comprueba si esta llena, y si no, introduce el entero */
	/**que pasa como parámetro en la función en la última posición del array
	 * @param elemento
	 * @throws StackException*/
	public void push(int elemento) throws StackException{
		if(TAMANO_PILA == this.contador){				
			 throw new StackException("Error. La pila esta llena.");  
		}
		else {
			this.stack[this.contador] = elemento;
			this.contador++;
		}
	}
	
	/**Esta funcion realiza la tarea del POP, que quita un elemento de la cima de la pila (si tiene elementos
	 * @return elemento de la cima de la pila
	 * @throws StackException*/
	public int pop()throws StackException{
		if(this.contador==0) throw new StackException("Error. No hay elementos en la pila.");  
		this.contador--;
		return this.stack[this.contador];
	}
	
	/** Resetea la pila*/
	public void reset(){
		this.contador = 0;
	}
	
	
	/**Accesora que devuelve el contador de la pila
	 * @return contador */
	public int getContador(){ return this.contador; } 
	
	public String toString(){
		if(this.contador == 0)
			return "<vacia>";
		else{
			String s = "";
		
			for(int i = 0; i < this.contador; i++)
				s += this.stack[i] + " "; 
			return s;
		}
	}
}

