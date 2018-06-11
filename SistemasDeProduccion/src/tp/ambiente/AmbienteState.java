package tp.ambiente;

import tp.agente.AgenteState;
import frsf.cidici.faia.solver.productionsystem.PeerRuleData;
import frsf.cidisi.faia.state.AgentState;
import frsf.cidisi.faia.state.EnvironmentState;

public class AmbienteState extends EnvironmentState {

	@Override
	public void initState() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}
	
    
    /**
     * Metodo que actualiza el estado del ambiente.
     */
    public void update(AgentState ag,PeerRuleData r){
    	/*Regla reg = (Regla) ((PeerRuleData) r).getRule();
    	AgenteState ch = (AgenteState) ag;
    	actualizar(reg.getRespuesta(),!ch.seDespidio());*/
    }

}
