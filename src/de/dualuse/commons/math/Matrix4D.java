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


	@Override protected Matrix row(int row, double[] values) { return this; }

	
	@Override
	protected Matrix element(int row, int col, double value) {
		switch(row) {
		case 0: switch (col) { case 0: a00=value; break; case 1: a01=value; break; case 2: a02=value; break; case 3: a03=value; break; }
		case 1: switch (col) { case 0: a10=value; break; case 1: a11=value; break; case 2: a12=value; break; case 3: a13=value; break; }
		case 2: switch (col) { case 0: a20=value; break; case 1: a21=value; break; case 2: a22=value; break; case 3: a23=value; break; }
		case 3: switch (col) { case 0: a30=value; break; case 1: a31=value; break; case 2: a32=value; break; case 3: a33=value; break; }
		}
		throw new ArrayIndexOutOfBoundsException("(row, col) must be in [0,4]x[0,4]");
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
	public Matrix4D concatenate(Matrix m) {
		return null;
	}

	@Override
	public Matrix4D concatenation(Matrix a, Matrix b) {
		return null;
	}
	
	@Override
	Matrix transpose(Matrix m) {
		return null;
	}

	
	public Matrix4D() {
		// TODO Auto-generated constructor stub
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
	public Matrix transform(Matrix B) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Matrix solve(Matrix B) {
		// TODO Auto-generated method stub
		return null;
	}
}
