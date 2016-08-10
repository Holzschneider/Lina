package de.dualuse.commons.math;

public abstract class ArrayVector extends Vector {
	final double[] v;
	
	ArrayVector(double[] values) {
		v = values;
	}

	@Override public double v(int i) {
		return v[i];
	}

	@Override
	public ArrayVector v(int i, double v) {
		this.v[i]=v;
		return this;
	}
	
}
