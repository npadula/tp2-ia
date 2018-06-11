package tp.agente;

import java.util.Iterator;
import java.util.LinkedList;

import tp.ambiente.Ambiente;

import frsf.cidici.faia.simulator.KnowledgeBasedAgentSimulator;
import frsf.cidisi.faia.exceptions.PrologConnectorException;


public class AgenteMain {

	private String entrada;
	private Ambiente ambiente;
	private Agente agente; 

	/**
	 * Constructor.
	 */
	public AgenteMain(){
		entrada = "";
		ambiente = new Ambiente();
		agente = new Agente();
	}
	
	/**
	 * Metodo que comienza la interaccion.
	 * @param args
	 * @throws PrologConnectorException
	 */
    public String comenzar() throws PrologConnectorException {       
  
    	ambiente.init(entrada);

    	KnowledgeBasedAgentSimulator simuladorSP = new KnowledgeBasedAgentSimulator(ambiente,agente);
   		simuladorSP.start();
   		
   		return ambiente.getRespuesta();
   		
    }
    
    /**
     * Metodo que almacena el log de la conversación.
     */
    public void guardarLog(){
    	
    	/*ArchivoOutput archivo = new ArchivoOutput("Log.txt");
		LinkedList<String> log = ambiente.getlog();    	
    	for(Iterator<String> i = log.iterator();i.hasNext();)
    		archivo.agregarRespuesta(i.next());
    	archivo.grabar();*/
    	
    }
/*
    
     // Metodo que prueba el preprocesamiento de las oraciones.
   
	public static void probarPreprocesamiento(){
		
		int numero = 1;
		Preprocesamiento preprocesamiento = new Preprocesamiento();
		ArchivoInput preguntas = new ArchivoInput("Preguntas.txt");
		ArchivoOutput respuestas = new ArchivoOutput("SalidaPreprocesamiento.txt");
		while(!preguntas.estaVacia())
		{
			String respuesta = numero + ") ";
			Oracion o = preprocesamiento.start(preguntas.getLinea());
			if(o == null) respuesta = respuesta.concat("NO BUSCAR");
			else respuesta = respuesta.concat(o.toString() + "BUSCAR");
			respuestas.agregarRespuesta(respuesta);
			numero++;
		}
		respuestas.grabar();
	}*/
	
	
	 // Metodo que prueba la busqueda de las oraciones.
	/*
	public static void probarBusqueda(){
		
		int numero = 1;
    	ArchivoInput aI = new ArchivoInput("Preguntas.txt");
    	ArchivoOutput aO = new ArchivoOutput("SalidaBusqueda.txt");
    	ChatbotEnvironment ambiente = new ChatbotEnvironment();
    	ChatbotAgent agente = new ChatbotAgent();
    	while(!aI.estaVacia())
    	{
    		String entrada = aI.getLinea();
           	ambiente.init(entrada);
           	ChatbotSearchSimulator simulator = new ChatbotSearchSimulator(ambiente,agente);           		
       		simulator.start();   
       		ChatbotState ag = (ChatbotState) agente.getAgentState();
       		aO.agregarRespuesta(numero + ") ENTRADA: " + entrada + " - PERCEPCION: " + ag.getpercepcion().toString() + " - REGLAS: " + ag.getStringRtas());
    		numero++;
    	}
    	aO.grabar();
	}*/
	
	
	 //Metodo que prueba el sistema de producción.
	/*
	public static void probarSistemaDeProduccion(){
		
		int numero = 1;
    	ArchivoInput aI = new ArchivoInput("Preguntas.txt");
    	ArchivoOutput aO = new ArchivoOutput("SalidaSistemasDeProduccion.txt");
    	ChatbotEnvironment ambiente = new ChatbotEnvironment();
    	ChatbotAgent agente = new ChatbotAgent();
    	while(!aI.estaVacia())
    	{
    		String entrada = aI.getLinea();
           	ambiente.init(entrada);
           	ChatbotSearchSimulator simulator = new ChatbotSearchSimulator(ambiente,agente);           		
       		simulator.start();
       		if(agente.debeDecidir())
       		{
       			ChatbotKnowlodgeSimulator simuladorSP = new ChatbotKnowlodgeSimulator(ambiente,agente);
       			simuladorSP.start();
       		}     		
       		ChatbotState ag = (ChatbotState) agente.getAgentState();
       		aO.agregarRespuesta(numero + ") ENTRADA: " + entrada + " - PERCEPCION: " + ag.getpercepcion().toString() + " - RESPUESTA: " + ambiente.getRespuesta());
    		numero++;
    	}
    	aO.grabar();
	}	*/
	
	
	 // Metodo que prueba al agente.
	/*
	public static void probarAgente(){
		
		int numero = 1;
    	ArchivoInput aI = new ArchivoInput("Preguntas.txt");
    	ArchivoOutput aO = new ArchivoOutput("SalidaAgente.txt");
    	ChatbotEnvironment ambiente = new ChatbotEnvironment();
    	ChatbotAgent agente = new ChatbotAgent();
    	while(!aI.estaVacia())
    	{
    		String entrada = aI.getLinea();
    		for(int j=0;j<4;j++)
    		{
    			ambiente.init(entrada);
    			ChatbotSearchSimulator simulator = new ChatbotSearchSimulator(ambiente,agente);           		
    			simulator.start();
    			if(agente.debeDecidir())
    			{
    				ChatbotKnowlodgeSimulator simuladorSP = new ChatbotKnowlodgeSimulator(ambiente,agente);
    				simuladorSP.start();
    			}     		
    			aO.agregarRespuesta(numero + ") PREGUNTA: " + entrada + " - RESPUESTA: " + ambiente.getRespuesta());
    		}
    		numero++;
    	}
    	aO.grabar();
	}	*/
	
    /**
     * Metodo para configurar el texto ingresado
     * al chatbot.
     * @param input
     */
    public void setEntrada(String input){
    	entrada = input;
    }

}
