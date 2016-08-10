package de.dualuse.commons.math;

public abstract class Matrix {
	
//	abstract int rows();
//	abstract int cols();
		
	abstract Matrix v(int row, int col, double v);
	abstract double v(int row, int col);
	
	abstract Matrix concatenate(Matrix m);
	
	abstract Matrix preconcatenate(Matrix m);
	
	
	
	
	static ArrayMatrix of( double[][] values ) {
		return new ArrayMatrix(values);
	}
	

	
	
	
	
	public static void main(String[] args) {
		
//		new Matrix.Identity(4);
//		new Matrix.Square(4).set(
//				1,2,3,4,
//				5,6,7,8
//				9,10,11,12);
		
		
	}
	
}
