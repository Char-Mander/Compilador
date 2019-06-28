package principal;

import excepciones.ArrayException;

public class Memory {
	/**Indica el numero de posiciones posibles de la memoria (se puede redimesionar)*/
	private int dimension;
	/**Array que contiene los valores de la memoria*/
	private Integer[] memory;
	/**Cuenta el numero de elementos introducidos en la memoria*/
	private Integer contadorElementos; 
	/**Dimension maxima de la memoria*/
	private final static int DIMENSION = 100;
	
	/**Constructora que inicializa la memoria*/
	public Memory(){
		this.dimension = Memory.DIMENSION;
		this.memory = new Integer[this.dimension];
		this.contadorElementos = 0;
	
	}
	
	/**Si la posicion introducida es correcta (pos >= 0), introducira el valor en memoria*/
	/**Si la posicion es mayor que la dimension se redimensionara el array
	 * @param pos 
	 * @param value*/
	public void write(int pos, int value)throws ArrayException{
		if(pos < 0){
			throw new ArrayException("Error. La memoria esta vacia.");
		} 
		else {
			if(pos > this.dimension)
				redimensionar(pos);
			if(this.memory[pos] == null) 
				this.contadorElementos++;
			this.memory[pos]=value;
		}
	}
	
	/**Si la posición no esta en la memoria, redimensiona la memoria. Si no, devuelve lo que hay en pos
	 * @param pos
	 * @return el elemento de la posición dada. Si no existe dicha posición, devuelve 0*/
	public int read(int pos){		
		if(pos > this.dimension)
			redimensionar(pos);
		if(this.memory[pos] != null)
			return this.memory[pos];
		else 
			return 0;
	}
	
	/**Redimensiona el array al doble de la posicion introducida
	 * @param pos*/
	public void redimensionar(int pos){
		Integer[] aux = new Integer[pos * 2];
		
		for(int i=0; i < this.dimension; i++)
			aux[i]=this.memory[i];
		this.dimension = pos * 2;
		this.memory=aux;
	}
	
	/**Resetea la memoria*/
	public void reset(){
		Integer[] aux = new Integer[Memory.DIMENSION];
		this.dimension = Memory.DIMENSION;
		this.memory=aux;
		this.contadorElementos=0;
	}
	
	/**Accesora que devuelve la cantidad de elementos introducidos en memoria
	 * @return contadorElementos*/
	public Integer getCont(){ return this.contadorElementos;} 
	
	/**Accesora que devuelve la dimension de la memoria
	 * @return dimension*/
	public int getDimension(){return this.dimension; }
	
	public String toString(){
		if(this.contadorElementos == 0)
			return "<vacia>";
		else{
			String s = "";
			for(int i = 0; i < this.dimension; i++)
				if(this.memory[i] != null)
					s+= " [" + i + "]: " + this.memory[i];
			return s;
		}
	}
} 
