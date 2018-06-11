package frsf.cidici.faia.solver.productionsystem;

import java.util.LinkedList;

/**
 * Clase que engloba el comportamiento de los criterios del sistema de produccion.
 * @author Grupo 12: Blas,Mar�a Julia / Diaz Ferreyra,Nicolas/ Sarli, Juan Leonardo.
 */
public abstract class Criteria {	

	public abstract LinkedList<PeerRuleData> apply(LinkedList<PeerRuleData> list);
	public abstract String toString();
	
}
