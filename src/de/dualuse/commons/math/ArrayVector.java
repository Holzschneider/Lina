package de.dualuse.commons.math;

public class ArrayVector extends Vector {
	final double[] v;
	
	ArrayVector(double[] values) {
		v = values;
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
	protected int rows() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	protected int cols() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	protected Matrix element(int row, int col, double value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected double element(int row, int col) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	protected Matrix row(int row, double[] values) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Matrix solution(Matrix A, Matrix B) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Matrix clone() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Matrix transform(Matrix v) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Matrix square() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Matrix concatenate(Matrix b) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Matrix solve(Matrix B) {
		// TODO Auto-generated method stub
		return null;
	}
}


