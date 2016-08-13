package de.dualuse.commons.math;

import javax.sound.midi.Sequence;

public abstract class Matrix {
	
	protected abstract int rows();
	protected abstract int cols();
		
	protected abstract Matrix v(int row, int col, double v);
	protected abstract double v(int row, int col);
	
	public abstract Matrix concatenate(Matrix m);
	public abstract Matrix preConcatenate(Matrix m);
	public abstract ArrayMatrix concatenation(Matrix a, Matrix b);
	
	abstract Vector transform(Vector v);
	
	abstract Matrix transpose(Matrix m);
	
	abstract Matrix invert(Matrix m);
	abstract Matrix invert();
	
	public abstract Vector fill(Sequence r);
	
	public abstract Matrix decompose(Matrix L, Matrix U);
	
//	public abstract Matrix solve(Matrix L, Matrix U, Vector x, Matrix P, Vector b);
	
//	public static Matrix identity( int size ) 
//	public static Matrix zero( int rows, int cols) 
	
//	public static ArrayMatrix from( double[][] values ) {
//		return new ArrayMatrix(values);
//	}

//	public static ArrayMatrix on( double[][] values ) {
//	return new ArrayMatrix(values);
//}

//	public static ArrayMatrix on( Vector v ) {
//	return new ArrayMatrix(values);
//}
	

	
	
	
	
	public static void main(String[] args) {
		
//		new Matrix.Identity(4);
//		new Matrix.Square(4).set(
//				1,2,3,4,
//				5,6,7,8
//				9,10,11,12);
		
		
	}
	
}
