package de.dualuse.lina;

public interface Mixable<Q> extends Variable<Q> {
	
	Mixable<Q> mix(Q a, Q b, double r);
	
}
