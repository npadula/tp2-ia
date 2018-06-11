import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;

import frsf.cidisi.faia.exceptions.PrologConnectorException;

import tp.agente.AgenteMain;


public class Main {
	public static void main(String[] args) {

        try 
        {
       	 	PrintStream ps = new PrintStream(new BufferedOutputStream(new FileOutputStream(new File("ArchivoDeLog.txt"))), true);
       	 	System.setOut(ps);         
       	 	System.setErr(ps);
       	 	
       	 	
       		AgenteMain main = new AgenteMain();
    		main.comenzar();
    		
           
        } 
        catch (Exception e)
        {
           System.out.println(e.getMessage());
        }
        
	
		
		//new PantallaPpal(main);
				
		//ChatbotAgentMain.probarPreprocesamiento();
		//ChatbotAgentMain.probarBusqueda();
        //ChatbotAgentMain.probarSistemaDeProduccion();
        //ChatbotAgentMain.probarAgente();
	     
	}
}
