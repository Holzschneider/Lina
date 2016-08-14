package de.dualuse.commons.math;

public class ArrayVector extends Vector {
	final double[] v;
	
	ArrayVector(double[] values) {
		v = values;
	}

	@Override public double element(int i) {
		return v[i];
	}

	@Override
	public ArrayVector element(int i, double v) {
		this.v[i]=v;
		return this;
	}

	@Override
	public double quadrance(Vector v) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	@Override
	public double dot(double[] vector) {
		double sum = 0;
		for (int i=0,I=vector.length;i<I;i++)
			sum+= v[i]*vector[i];
			
		return sum;
	}
	

	@Override
	public Vector scale(double factor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector mix(double ratio, Vector v) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector fill(double value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double[] values() {
		return v;
	}

	@Override
	public Vector values(double... values) {
		for (int i=0,I=values.length;i<I;i++)
			v[i] = values[i];
		
		return this;
	}

	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	

	@Override
	protected int dimension() {
		return v.length;
	}
}


