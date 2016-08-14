package de.dualuse.commons.math;

import java.util.Arrays;

public class ArrayMatrix extends Matrix {

	public final double A[][];
	
	ArrayMatrix(double B[][]) {
		this.A = new double[B.length][];
		for (int i=0,I=A.length;i<I;i++)
			this.A[i] = B[i].clone();
	}
	
	public ArrayMatrix(int rows, int cols) {
		this.A = new double[rows][cols];
	}


	@Override
	protected int rows() {
		return A.length;
	}

	@Override
	protected int cols() {
		return A[0].length;
	}
	
	@Override
	protected double element(int row, int col) {
		return A[row][col];
	}

	@Override
	protected Matrix element(int row, int col, double value) {
		A[row][col] = value;
		return this;
	}

	@Override
	protected double[] row(int row) {
//		return A[row].clone();
		return A[row];
	}
	
	@Override
	protected Matrix row(int row, double[] values) {
		double[] A_row = A[row]; 
		if (values!=A_row)
			for (int i=0,I=A_row.length;i<I;i++)
				A_row[i]=values[i];
			
		return this;
	}
	
	@Override
	protected double dot(int col, double vector[]) {
		double sum = 0;
		
		for (int i=0,I=vector.length;i<I;i++)
			sum +=A[i][col]*vector[i];
		
		return sum;
	}
	
	@Override
	public ArrayMatrix concatenation(Matrix a, Matrix b) {
		super.concatenation(a, b);
		return this;
	}
	
	////////// Solving
	
//	public ArrayMatrix decompose(Matrix L, Matrix U) {
//		// Code: Cormen et al., page 756
//		Matrix A = this;
//	    int i, j, k, n = A.rows();
//	    for ( k = 0; k < n; ++k) {
//	        U.element( k, k, A.element( k, k));
//	        for ( i = k; i < n; ++i) {
//	            L.element( i, k, A.element( i, k) / U.element( k, k ));
//	            U.element( k, i, A.element( k, i) );
//	        }
//	        for( i = k; i < n; ++i) 
//	            for( j = k+1; j < n; ++j) 
//	                A.element(i,j, A.element( i, j) - L.element( i, k)*U.element( k, j));
//	    }
//		
//	    return this.concatenation(L, U);
//	}

////	 decompose
//	protected static void decompose(int n, double[][] M, double[][] L, double[][] U) {
//		
//	    // Code: Cormen et al., page 756
//	    int i, j, k;
//	    for ( k = 0; k < n; ++k) {
//	        U[ k][ k] = M[ k][ k];
//	        for ( i = k+1; i < n; ++i) {
//	            L[ i][ k] = M[ i][ k] / U[ k][ k];
//	            U[ k][ i] = M[ k][ i];
//	        }
//	        for( i = k+1; i < n; ++i) {
//	            for( j = k+1; j < n; ++j) {
//	                M[ i][ j] = M[ i][ j] - L[ i][ k]*U[ k][ j];
//	            }
//	        }
//	    }
//	}
//
//	// solve
//	protected static void solve(int n, double[][] L, double[][] U, double[] y, double[] x) {
//		
//	    // Code: Cormen et al., page 756
////	    double[] y = b;//new double[n];
//	    int i, j;
//
//	    // forward substitution
//	    for ( i = 0; i < n; ++i) {
////	        y[ i] = b[ i];
//	        for ( j = 0; j < i; ++j) {
//	            y[ i] -= L[ i][ j] * y[ j];
//	        }
//	    }
//
//	    // back substitution
//	    for ( i = n-1; i >= 0; --i) {
//	        x[ i] = y[ i];
//	        for ( j = i+1; j < n; ++j) {
//	            x[ i] -= U[ i][ j] * x[ j];
//	        }
//	        x[ i] /= U[ i][ i];
//	    }
//	}
//	

	@Override
	public String toString() {
		return "ArrayMatrix"+Arrays.deepToString(A);
	}


	@Override
	Matrix transpose(Matrix m) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	Matrix invert(Matrix m) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	Matrix invert() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	@Override public ArrayMatrix clone() {
		double B[][] = A.clone();
		
		for (int i=0,I=B.length;i<I;i++)
			B[i] = B[i].clone();
		
		return new ArrayMatrix(B);
	}

	
	
	
	
//	protected static void decompose(int n, double[][] A, double[][] L, double[][] U){
//		for (int k = 0, i = 0, j=0; k<n;i=++k) {
//			for (double u[]=U[k],a[]=A[k],v=u[k]=A[k][k];i<n;u[i] = a[i],i++)
//				L[i][k] = A[i][k]/v;
//
//			for (i=j=k;i<n;i++,j=k)
//				for (double a[]=A[i],u[]=U[k],l=L[i][k];j<n;j++)
//					a[j]-= l*u[j];
//			
//		}
//		
//		for (int r=0,c=0,i=0;r<n;r++,c=i=0)
//			for (double sum=0;c<n;A[r][c]=sum,c++,i=0,sum=0)
//				for (double l[]=L[r];i<n;i++)
//					sum += l[i]*U[i][c];
//		
//	}
//
//	// solve
//	protected static void solve(int n, double[][] L, double[][] U, double[] y, double[] x) {
//		
//	    // Code: Cormen et al., page 756
//	    // forward substitution
//	    for ( int i = 0,j=0; i < n; ++i,j=0)  
//	        for ( double[] l=L[i]; j < i; ++j) 
//	        	y[ i] -= l[ j] * y[ j];
//	    
//	    // back substitution
//	    for ( int i = n-1; i >= 0; --i) {
//	        x[ i] = y[ i];
//	        final double[] u = U[i];
//	        for ( int j = i+1; j < n; ++j) 
//	            x[ i] -= u[ j] * x[ j];
//	        
//	        x[ i] /= U[ i][ i];
//	    }
//	}

	
}






