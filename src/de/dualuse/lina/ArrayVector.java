//package de.dualuse.lina;
//
//public class ArrayVector extends Vector {
//	final double[] v;
//	
//	ArrayVector(double[] values) {
//		v = values;
//	}
//
//	@Override
//	public double quadrance(Vector v) {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//
//	
//	@Override
//	public double dot(double[] vector) {
//		double sum = 0;
//		for (int i=0,I=vector.length;i<I;i++)
//			sum+= v[i]*vector[i];
//			
//		return sum;
//	}
//	
//
//	@Override
//	public Vector scale(double factor) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public Vector mix(double ratio, Vector v) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public Vector fill(double value) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public double[] values() {
//		return v;
//	}
//
//	@Override
//	public Vector values(double... values) {
//		for (int i=0,I=values.length;i<I;i++)
//			v[i] = values[i];
//		
//		return this;
//	}
//
//	
//	@Override
//	public String toString() {
//		// TODO Auto-generated method stub
//		return super.toString();
//	}
//	
//
//
//	@Override
//	protected int rows() {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//
//	@Override
//	protected int cols() {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//
//
//	@Override
//	protected double element(int row, int col) {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//
//	@Override
//	protected double[] row(int row, double[] values) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public Matrix solution(Matrix A, Matrix B) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public Matrix clone() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public Matrix transform(Matrix v) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public Matrix square() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public Matrix concatenate(Matrix b) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public Matrix solve(Matrix B) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public Matrix identity() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public Matrix magic(int i) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public Matrix zero() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public Matrix transpose() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public Matrix transpose(Matrix A) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	protected Matrix preconcatenate(Matrix B) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public Matrix concatenation(Matrix A, Matrix B) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//}
//
//
