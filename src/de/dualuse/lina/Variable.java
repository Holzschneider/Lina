package de.dualuse.lina;


public interface Variable<Q> extends Value {
	
	public Variable<Q> set(Q q);
	public Variable<Q> get(Variable<Q> q);
	
}
