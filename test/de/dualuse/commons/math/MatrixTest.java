package de.dualuse.commons.math;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class MatrixTest {
	
	@Test
	public void concatenationTest() {
		double[][] a = {
			{ 1, 2, 3},
			{ 4, 5, 6},
			{ 7, 8, 9}
		};
		
		double[][] b = {
			{10,11,12},
			{13,14,15},
			{16,17,18}
		};
		
		double[][] ab = {
			{ 84, 90, 96},
			{201,216,231},
			{318,342,366}
		};
		
		double[][] ba = {
			{138,171,204},
			{174,216,258},
			{210,261,312}
		};
		
		double[][] aa = {
			{ 30, 36, 42},
			{ 66, 81, 96},
			{102,126,150}
		};
		
		
		ArrayMatrix A1 = new ArrayMatrix(a).clone(), B1 = new ArrayMatrix(b).clone();
		ArrayMatrix A2 = new ArrayMatrix(a).clone(), B2 = new ArrayMatrix(b).clone();
		
		System.out.println( A1.concatenation(A1,B1) );
		System.out.println( A2.concatenation(B2, A2) );
		
		
//		System.out.println(  new ArrayMatrix(3,3). concatenation( new ArrayMatrix(a), new ArrayMatrix(b) ) );
//		System.out.println( new ArrayMatrix(3,3).concatenation( new ArrayMatrix(b), new ArrayMatrix(a) ) );

//		assertEquals(new ArrayMatrix(a).clone().concatenate( new ArrayMatrix(b) ), new ArrayMatrix(ab));
//		assertEquals(new ArrayMatrix(a).clone().preConcatenate( new ArrayMatrix(b) ), new ArrayMatrix(ba));

		ArrayMatrix A = new ArrayMatrix(a), B = new ArrayMatrix(b);
		assertEquals(A.concatenation( A, B), new ArrayMatrix(ab));

		ArrayMatrix A_ = new ArrayMatrix(a), B_ = new ArrayMatrix(b);
		assertEquals(A_.concatenation( B_, A_), new ArrayMatrix(ba));
		
//		assertEquals(new ArrayMatrix(3,3).concatenation( new ArrayMatrix(a), new ArrayMatrix(b) ), new ArrayMatrix(ab));
//		assertEquals(new ArrayMatrix(3,3).concatenation( new ArrayMatrix(b), new ArrayMatrix(a) ), new ArrayMatrix(ba));
//		
//		
//		ArrayMatrix A__ = new ArrayMatrix(a);
//		assertEquals(A__.concatenation(A__, A__), new ArrayMatrix(aa));
		
	}
	
	
	@Test
	public void decomposeTest() {
//		double[][] a ={
//				{ 3.5,   12,     3,    13 },
//				{ 5,     11,    10,     8 },
//				{ 9,      7,     6,    12 },
//				{ 4,     14,    15,     1 }
//			};
//			
//		double[][] l_ = { 
//				{ 1.0, 0.0, 0.0, 0.0 }, 
//				{ 1.4285714285714286, 1.0, 0.0, 0.0 },
//				{ 2.5714285714285716, 3.8837209302325593, 1.0, 0.0 },
//				{ 1.1428571428571428, -0.046511627906976875, -0.49513618677042787, 1.0 } };		
//		
//		double[][] u_ =  {
//				{3.5, 12.0, 3.0, 13.0}, 
//				{0.0,-6.142857142857142, 5.714285714285714,-10.571428571428573}, 
//				{0.0, 0.0,-23.906976744186053, 19.6279069767442}, 
//				{0.0, 0.0, 0.0,-4.630350194552525} };
//		
//
//		double[][] l = new double[4][4], u = new double[4][4];
//		
//		ArrayMatrix A = new ArrayMatrix(a), A_ = A.clone();
//		ArrayMatrix L = new ArrayMatrix(l), L_ = new ArrayMatrix(l_);
//		ArrayMatrix U = new ArrayMatrix(u), U_ = new ArrayMatrix(u_);
//		
//		A.decompose(L, U);
//		
//		assertEquals( A, A_ );
//		
//		assertEquals( L, L_);
//		assertEquals( U, U_);
	}
	
	@Test
	public void lupDecomposeTest() {
//		double[][] a ={
//				{ 3.5,   12,     3,    13 },
//				{ 5,     11,    10,     8 },
//				{ 9,      7,     6,    12 },
//				{ 4,     14,    15,     1 }
//			};
//			
//		double[][] l_ = { 
//				{ 1.0, 0.0, 0.0, 0.0 }, 
//				{ 1.4285714285714286, 1.0, 0.0, 0.0 },
//				{ 2.5714285714285716, 3.8837209302325593, 1.0, 0.0 },
//				{ 1.1428571428571428, -0.046511627906976875, -0.49513618677042787, 1.0 } };		
//		
//		double[][] u_ =  {
//				{3.5, 12.0, 3.0, 13.0}, 
//				{0.0,-6.142857142857142, 5.714285714285714,-10.571428571428573}, 
//				{0.0, 0.0,-23.906976744186053, 19.6279069767442}, 
//				{0.0, 0.0, 0.0,-4.630350194552525} };
//		
//
//		double[] x = {3, 1, 8, 2};
//		double[] b = {72.5, 122, 106, 148};
//
//		double[][] l = new double[4][4], u = new double[4][4];
//		
//		ArrayMatrix A = new ArrayMatrix(a), A_ = A.clone();
//		ArrayMatrix L = new ArrayMatrix(l), L_ = new ArrayMatrix(l_);
//		ArrayMatrix U = new ArrayMatrix(u), U_ = new ArrayMatrix(u_);
//		
//		ArrayVector B = new ArrayVector(b);
//		
//		int[] p = new int[4];
//		
//		A.decompose(L, U, p);
//		A.solve(p, B);
//		A.repair(L, U, p);
//		
//		System.out.println(B);
//		System.out.println();
//		System.out.println( L );
//		System.out.println( U );
//		System.out.println( Arrays.toString(p) );
//		System.out.println( A );
	}
	
	
	@Test
	public void solveTest() {
//		double[][] a ={
//				{ 3.5,   12,     3,    13 },
//				{ 5,     11,    10,     8 },
//				{ 9,      7,     6,    12 },
//				{ 4,     14,    15,     1 }
//			};
//		
//		double[] x = {3, 1, 8, 2};
//		double[] b = {72.5, 122, 106, 148};
//		
//		Vector v = new ArrayMatrix(a).solve(new ArrayMatrix(4, 4), new ArrayMatrix(4,4), new ArrayVector(new double[4]), new ArrayVector(b));
//		
////		System.out.println(new ArrayVector(b));
////		System.out.println(v);
//		
//		assertEquals(v, new ArrayVector(x));
	}

	@Test
	public void transformTest() {

//		double[][] coefficients = new double[][] {
//			{  1, 2, 3, 4 },
//			{  5, 6, 7, 8 },
//			{  9,10,11,12 },
//			{ 13,14,15,16 }
//		};
//		
//		double[] values = { 1,2,3,4 };
//		double[] result = {30, 70, 110, 150};
//		
//		assertEquals(
//				new ArrayMatrix(coefficients).transform(new ArrayVector(values)), 
//				new ArrayVector(result)
//			);
		
	}


	public static void main(String[] args) {
		
		new MatrixTest().concatenationTest();
//		double[][] coefficients = new double[][] {
//			{  1, 2, 3, 4 },
//			{  5, 6, 7, 8 },
//			{  9,10,11,12 },
//			{ 13,14,15,16 }
//		};
//		
//		double[] values = { 1,2,3,4 };
//
//		ArrayVector v = new ArrayMatrix(coefficients).transform(new ArrayVector(values));
//		
//		System.out.println(v);
		
	}
}
