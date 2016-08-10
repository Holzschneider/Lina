package de.dualuse.commons.math;

public class ArrayVector extends Vector {
	final double[] v;
	
	ArrayVector(double[] values) {
		v = values;
	}

	@Override public double v(int i) {
		return v[i];
	}

	@Override
	ArrayVector v(int i, double v) {
		this.v[i]=v;
		return this;
	}
	
}
