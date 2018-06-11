package tp.agente;

import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

import frsf.cidici.faia.solver.productionsystem.Criteria;
import frsf.cidici.faia.solver.productionsystem.NoDuplication;
import frsf.cidici.faia.solver.productionsystem.Novelty;
import frsf.cidici.faia.solver.productionsystem.Priority;
import frsf.cidici.faia.solver.productionsystem.Random;
import frsf.cidici.faia.solver.productionsystem.Specificity;
import frsf.cidisi.faia.agent.Action;
import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.agent.search.SearchBasedAgent;
import frsf.ia.tp.chatbotagent.solver.productionsystem.ChatbotProductionSystem;

public class Agente extends SearchBasedAgent {

	@Override
	public void see(Perception p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Action selectAction() {
		// TODO Auto-generated method stub
		return null;
	}
	
	  /**
     * Metodo que hace que el agente aprenda.
     * @return La regla que hay que ejecutar o null si no hay ninguna.
     */
    public Action learn(){
    	
		//TODO Aca se deciden los criterios del sistema de produccion
    	LinkedList<Criteria> lista = new LinkedList<Criteria>();
    	
    	//Creacion del criterio Especificidad
    	lista.add(new Specificity());          
        //Creacion del criterio No duplicacion
    	lista.add(new NoDuplication());     	
        //Creacion del criterio Prioridad
    	lista.add(new Priority());         
        //Creacion del criterio Novedad
    	lista.add(new Novelty());         
        //Creacion del criterio Aleatorio
    	lista.add(new Random()); 
                
        //Creacion de un objeto sistema de produccion con los criterios.
    	AgenteState ch = (AgenteState) this.getAgentState();
        ChatbotProductionSystem productionSystemSolver = new ChatbotProductionSystem(lista,ch.getReglas(),ch.getPercepcion());

        //Setea el solver productionSystemSolver.
        this.setSolver(productionSystemSolver);

        //Se le pide al solver la acción a ejecutar si es que existe.
        Action selectedAction = null;
        try 
        {
            selectedAction = this.getSolver().solve(new Object[]{this.getProblem()});
        }
        catch (Exception ex) 
        {
            Logger.getLogger(Agente.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Return the selected action
        return selectedAction;    	

    }

}
