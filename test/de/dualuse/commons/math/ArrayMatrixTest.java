package de.dualuse.commons.math;

public class ArrayMatrixTest {
	public static void main(String[] args) {

		double[][] A ={	{ 1, 2, 3 },
						{ 4, 5, 6 },
						{ 7, 8, 9 } };

		double[][] B ={	{ 10, 11, 12 },
						{ 13, 14, 15 },
						{ 16, 17, 18 } };
		
//		ArrayMatrix m = new ArrayMatrix(A).preconcatenate(new ArrayMatrix(B));
		ArrayMatrix m = new ArrayMatrix(new double[3][3]).concatenation( new ArrayMatrix(B), new ArrayMatrix(A) );
		
		System.out.println(m);
		
	}
}
