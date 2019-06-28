package principal;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import bytecodes.ByteCode;
import bytecodes.ByteCodeParser;
import bytecodes.ByteCodeProgram;
import comandos.Command;
import comandos.CommandParser;
import excepciones.*;
import programa.LexicalParser;
import programa.ParsedProgram;
import programa.SourceProgram;
import programa.Compiler;

public class Engine {
	/**Atributo que contiene el programa a ejecutar*/
	private ByteCodeProgram bcProgram;
	/**Atributo que contiene el sourceProgram*/
	private SourceProgram sProgram;
	/**Atributo que contiene el parsedProgram*/
	private ParsedProgram pProgram;
	/**Booleano que indica si se ha ejecutado el comando QUIT*/
	private boolean end;
	private java.util.Scanner sc;
	/**Atributo que representa la cpu*/
	private CPU cpu;
	
	
	/**Constructora del programa*/
	 public Engine(){
		 this.bcProgram = new ByteCodeProgram();
		 this.sProgram = new SourceProgram();
		 this.pProgram = new ParsedProgram();
		 this.cpu = new CPU(this.bcProgram);
	 }
	  
	 /**Esta funcion inicia el programa y pide instrucciones y las ejecuta hasta que se ejecute
		* el comando QUIT. Muestra si ha habido alguna excepcion por pantalla. (Se cogen en esta funcion)
	 * */
	 public void start(){ 
		    this.end = false;
		    String line="";
		    Command comando = null;   
		    sc = new java.util.Scanner(System.in);
		    
		    while(!this.end) {
		      System.out.print("> ");
		      
		      line = sc.nextLine();
		      line = line.trim();
		      comando = CommandParser.parse(line);
		      
		      if(comando == null)
		        System.out.println("Error: Comando incorrecto " + System.getProperty("line.separator"));
		      else {
		        System.out.println("Comienza la ejecucion de " + comando.toString());
		        try {comando.execute(this);} 
		        
		        catch(ArrayException e){	System.out.println(e);	}
		        
		        catch(LexicalAnalysisException e){	System.out.println(e);	}
		        
		        catch(BadFormatByteCodeException e){	System.out.println(e);	}
		        
		        catch(ExecutionErrorException e){	System.out.println(e);	}
		        
		        catch(FileNotFoundException e){	System.out.println("Archivo no encontrado");	}	
		        
		        if(this.sProgram.getNumeroInstrucciones()>0)
		        	System.out.println(this.sProgram);
		        
		        if(this.bcProgram.getNumeroInstrucciones() > 0)
		          System.out.print(this);
		      }
		    }
		    System.out.println(System.getProperty("line.separator") + "Fin de la ejecucion...");
		    sc.close();
		  }
		
	 /**Muestra el menu de ayuda*/
	public static void showHelp(){
		CommandParser.showHelp();
	}
	
	/**@return la funcion que resetea el bcProgram*/
	public void resetProgram(){
		this.bcProgram.inicializar();
	}
	
	/**Ejecuta el programa. Si el bcProgram no tiene ninguna instruccion, lanza una ArrayException.
	 * Si no, llama al cpu.run() y lo muuestra por pantalla. Despues de la ejecucion, resetea la cpu.
	 * @throws ExecutionErrorException 
	 * @throws ArrayException */
	public void runProgram() throws ExecutionErrorException, ArrayException{
	    
	    if(this.bcProgram.getNumeroInstrucciones() == 0){
	      throw new ArrayException("Error. No hay ninguna instruccion.");
	    }
	    else {
	    cpu.run();
	      System.out.println(this.cpu);
	    }
	    this.cpu.reset();
	  }
	
	/**Sale del programa poniendo el end a true*/
	public void quitProgram(){
		this.end = true;
	}

	/**Funcion que usa el replace. Si se usara de manera erronea el array de bcProgram, lanzaria
	 * una ArrayException. Si la instruccion fuera null, lanzaria una BadFormatByteCodeException.
	 * @param pos
	 * @throws ArrayException */
	public void replaceByteCode(int pos) throws ArrayException, BadFormatByteCodeException{
		String aux;
		ByteCode instruction;
		
		if(pos >= 0 && pos < this.bcProgram.getNumeroInstrucciones()){
		    System.out.print("Introduce nueva instruccion: ");
		    aux = sc.nextLine();
		    aux = aux.trim();
		    instruction = ByteCodeParser.parse(aux.toUpperCase());
		    if(instruction != null)
		    	this.bcProgram.instruccionEnPosDada(instruction, pos);
		    else 
		    	throw new BadFormatByteCodeException("Error. Formato erroneo del ByteCode");
		} else 
			throw new ArrayException("Error. Posicion incorrecta del Array.");
	}

	/** Funcion que carga los datos del archivo (nombre) dado. Si no se encontrara el
	 * archivo, lanzaria una FileNotFoundException.
	 * @param nombre
	 * @throws ArrayException
	 * @throws FileNotFoundException
	 * */
	public void loadFich(String nombre) throws ArrayException, FileNotFoundException{
		FileReader fr;
		BufferedReader br;
		
		try {
			fr = new FileReader (nombre);
			br = new BufferedReader(fr);
			String aux;
			
			this.sProgram.inicializar();
			
			while ((aux = br.readLine()) != null)
				this.sProgram.addInst(aux.trim());
			
			br.close();
		} catch (IOException e) {
			throw new FileNotFoundException();
		}
	}


	/** Funcion que inicializa tanto el bcProgram como el pProgram, e inicia el lexicalAnalysis() 
	 * y el generateByteCode().
	 * @throws ArrayException
	 * @throws LexicalAnalysisException
	 * */
	public void compile() throws ArrayException, LexicalAnalysisException {
		
		this.bcProgram.inicializar();
		this.pProgram.inicializar();
		this.lexicalAnalysis();
		this.generateByteCode();
	}
	
	
	/** Funcion que genera el ByteCode: crea un nuevo Compiler (con el bytecodeProgram), y llama 
	 * al compile del compiler (con el parsedProgram)
	 * @throws ArrayException
	 * */
	private void generateByteCode() throws ArrayException {
		Compiler compiler = new Compiler(this.bcProgram);
		compiler.compile(this.pProgram);
	}

	/** Funcion del análisis léxico: crea el LexicalParser(con el sourceProgram) y llama 
	 * al lexicalParser (con el parsedProgram y su centinela del final, "end")
	 * @throws ArrayException
	 * @throws LexicalAnalysisException
	 * */
	private void lexicalAnalysis() throws ArrayException, LexicalAnalysisException {
		LexicalParser lexParser = new LexicalParser(this.sProgram);
		
		lexParser.lexicalParser(this.pProgram, "end");
	}
	
	public String toString(){
		String line="";
		
		line="Programa bytecode almacenado: " + System.getProperty("line.separator");
		for(int i=0; i<this.bcProgram.getNumeroInstrucciones(); i++)
			line += i + ": " + this.bcProgram.getByteCodeProgram(i) + System.getProperty("line.separator");
	
		return line;
	}
}