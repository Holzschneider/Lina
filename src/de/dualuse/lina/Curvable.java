package de.dualuse.lina;

public interface Curvable<Q> extends Variable<Q> {
	
	public Curvable<Q> cubic(Q a, Q da, Q dd, Q d, double r);
	
}
