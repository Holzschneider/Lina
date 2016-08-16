package de.dualuse.commons.math;

/**
 * Named according to 
 *    "Computer Vision - Algorithms and Applications" (1st edition), Richard Szeliski, Page 37 
 * 
 * 
 * @author holzschneider
 */
public class Matrix4D extends Matrix {
	
	public double a00, a01, a02, a03;
	public double a10, a11, a12, a13;
	public double a20, a21, a22, a23;
	public double a30, a31, a32, a33;
	
	
	@Override protected int rows() { return 4; }
	@Override protected int cols() { return 4; }


	@Override protected double[] row(int row, double[] values) { 
		switch(row) {
		case 0: values[0] = a00; values[1] = a01; values[2] = a02; values[3] = a03; break;
		case 1: values[0] = a10; values[1] = a11; values[2] = a12; values[3] = a13; break;
		case 2: values[0] = a20; values[1] = a21; values[2] = a22; values[3] = a23; break;
		case 3: values[0] = a30; values[1] = a01; values[2] = a32; values[3] = a33; break;
		}
		
		return values;
	}
	
	@Override
	protected double element(int row, int col) {
		switch(row) {
		case 0: switch (col) { case 0: return a00; case 1: return a01; case 2: return a02; case 3: return a03; }
		case 1: switch (col) { case 0: return a10; case 1: return a11; case 2: return a12; case 3: return a13; }
		case 2: switch (col) { case 0: return a20; case 1: return a21; case 2: return a22; case 3: return a23; }
		case 3: switch (col) { case 0: return a30; case 1: return a31; case 2: return a32; case 3: return a33; }
		}
		throw new ArrayIndexOutOfBoundsException("(row, col) must be in [0,4)x[0,4)");
	}
	
	
	@Override
	public Matrix transform(Matrix B) {
		return null;
	}
	
	@Override
	public Matrix4D concatenate(Matrix m) {
		m.element(0, 0);
		
		return null;
	}

	@Override
	public Matrix4D concatenation(Matrix a, Matrix b) {
		return null;
	}
	
	@Override
	public Matrix4D transpose(Matrix m) {
		return this;
	}

	public Matrix4D() {
	}
	
	@Override
	public Matrix clone() {
		return null;
	}
	
	
	@Override
	public Matrix solution(Matrix A, Matrix B) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Matrix square() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Matrix solve(Matrix B) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Matrix identity() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Matrix magic(int i) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Matrix fill(double value) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Matrix zero() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Matrix transpose() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	protected Matrix preconcatenate(Matrix B) {
		// TODO Auto-generated method stub
		return null;
	}
}
