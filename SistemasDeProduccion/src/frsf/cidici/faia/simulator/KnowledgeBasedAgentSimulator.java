package frsf.cidici.faia.simulator;

import java.util.Vector;

import tp.agente.Agente;

import frsf.cidici.faia.solver.productionsystem.ProductionSystemAction;
import frsf.cidisi.faia.agent.Action;
import frsf.cidisi.faia.agent.Agent;
import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.environment.Environment;
import frsf.cidisi.faia.simulator.events.EventType;
import frsf.cidisi.faia.simulator.events.SimulatorEventNotifier;

/**
 * Clase que implementa el simulador de un agente basado en conocimiento.
 * @author Grupo 12: Blas,Mar�a Julia / Diaz Ferreyra,Nicolas/ Sarli, Juan Leonardo.
 */
public class KnowledgeBasedAgentSimulator extends frsf.cidisi.faia.simulator.Simulator {

	/**
	 * Constructor.
	 * @param environment
	 * @param agents
	 */
    public KnowledgeBasedAgentSimulator(Environment environment, Vector<Agent> agents) {
        super(environment,agents);
    }
    
    /**
     * Constructor.
     * @param environment
     * @param agent
     */
    public KnowledgeBasedAgentSimulator(Environment environment, Agent agent) {
   		Vector<Agent> v = new Vector<Agent>();
   		v.add(agent);
    	this.environment = environment;
    	this.agents = v;
    }
	
	@Override
	public void start() {

        System.out.println("----------------------------------------------------");
        System.out.println("--- " + this.getSimulatorName() + " ---");
        System.out.println("----------------------------------------------------");
        System.out.println();

        Perception perception;
        Action action;
        //TODO Futuro: Esta hecho para el ChatBot pero deber�a incluirse el m�todo learn en la clase agente.
        Agente agent;

        agent = (Agente) this.getAgents().firstElement();

        do {

            System.out.println("------------------------------------");

            System.out.println("Sending perception to agent...");
            perception = this.getPercept();
            agent.see(perception);
            System.out.println("Perception: " + perception);

            System.out.println("Agent State: " + agent.getAgentState());
            System.out.println("Environment: " + environment);

            System.out.println("Asking the agent that start the learning process...");
            action = agent.learn();

            if (action == null)
            	System.out.println("\nRule to execute: None");
            else
            {
            	ProductionSystemAction act = (ProductionSystemAction) action;
            	System.out.println("\nRule to execute: " + act.getPeerRuleData().getRule().getId());
            }
            System.out.println();

            this.ruleReturned(agent, action);

        } while (!this.finishForRule(action) && !this.finishForAgentState(agent));

        // Check what happened.
        if (this.finishForRule(action)) {
            System.out.println("The agent has executed the finish rule.");
        } else {
            System.out.println("The agent has finished learning!");
        }

        // Leave a blank line
        System.out.println();

        // This call can be moved to the Simulator class
        this.environment.close();

        // Launch simulationFinished event
        SimulatorEventNotifier.runEventHandlers(EventType.SimulationFinished, null);
		
	}

	protected boolean finishForAgentState(Agent agent) {
		// TODO Futuro: Ver como deber� ser este m�todo
		return false;
	}

	protected boolean finishForRule(Action action) {
		// TODO Futuro: Ver como deber� ser este m�todo
		return false;
	}
	
	public String getSimulatorName() {
        return "Knowledge Based Simulator";
    }

    public void ruleReturned(Agent agent,Action action) {
        if(action!=null)
        {
        	this.updateState(action);
        }
    }
    
    protected void updateState(Action action) {
    	//TODO Futuro: Esta hecho para el ChatBot pero deber�a incluirse en otro lugar el metodo requerido.
        this.getEnvironment().updateState(((Agente) agents.elementAt(0)).getAgentState(), action);
    }
    
}
