package tp.agente;

import java.util.LinkedList;

import tp.rules.Oracion;
import tp.rules.Regla;

import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;


public class AgenteState extends SearchBasedAgentState {

	private LinkedList<tp.rules.Regla> reglas;
	private Oracion percepcion;

	@Override
	public SearchBasedAgentState clone() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateState(Perception p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void initState() {
		// TODO Auto-generated method stub
		
	}
	
    public LinkedList<Regla> getReglas(){
        return reglas;
     }
    
    public Oracion getPercepcion(){
        return percepcion;
     }

}
