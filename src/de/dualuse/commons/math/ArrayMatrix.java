package de.dualuse.commons.math;

import java.util.Arrays;

public class ArrayMatrix extends Matrix {

	public final double m[][];
	
	ArrayMatrix(double B[][]) {
		this.m = new double[B.length][];
		for (int i=0,I=m.length;i<I;i++)
			this.m[i] = B[i].clone();
	}
	
	public ArrayMatrix(int rows, int cols) {
		this.m = new double[rows][cols];
	}

	public ArrayMatrix(Matrix M) {
		m = new double[M.rows()][M.cols()];
		
		for (int i=0,I=m.length;i<I;i++)
			M.row(i, m[i]);
	}

	@Override
	protected int rows() {
		return m.length;
	}

	@Override
	protected int cols() {
		return m[0].length;
	}
	
	@Override
	protected double element(int row, int col) {
		return m[row][col];
	}

	@Override
	protected double[] row(int row, double[] values) {
		double[] A_row = m[row]; 
		if (values!=A_row)
			for (int i=0,I=A_row.length;i<I;i++)
				values[i]=A_row[i];
			
		return values;
	}
	
	@Override
	protected double rowDotCol(int row, Matrix b, int col) {
		return b.colDotArray(col, m[row]);
	}
	 
	@Override
	protected double colDotArray(int col, double vector[]) {
		double sum = 0;
		
		for (int i=0,I=vector.length;i<I;i++)
			sum +=m[i][col]*vector[i];
		
		return sum;
	}
	
	///////////////////////////////////////////////////////////////
	
	private static void rows(int n, ArrayMatrix a, int row, Matrix b, int col, ArrayMatrix ab) {
		double v = b.colDotArray( col, a.m[row]);
		if (col+1<n) rows(n, a, row, b, col+1, ab);
		ab.m[row][col] = v;
	}
	
	private static void square(int n, int i, ArrayMatrix A) {
		int row = i/n, col = i%n;
		double v= A.colDotArray(col, A.m[row]);
		
		if (i+1<n*n) square(n, i+1, A);
		
		A.m[row][col] = v;
	}
	
	@Override
	public ArrayMatrix square() {
		square(rows(),0,this);
		return this;
	}
	
	@Override
	public ArrayMatrix concatenate(Matrix b) {
		for (int r=0,R=this.rows();r<R;r++)
			rows(R,this,r,b,0, this);
		
		return this;
	}

	private static void cols(int n, ArrayMatrix a, int col, Matrix b, int row) {
		double v = b.rowDotCol(row, a, col);
		if (row+1<n) cols(n, a, col, b, row+1);
		a.m[row][col] = v;
	}

	@Override
	protected ArrayMatrix preconcatenate(Matrix b) {
		for (int c=0,C=this.cols();c<C;c++)
			cols(C,this,c,b,0);
		
		return this;
	}
	
	@Override
	public ArrayMatrix concatenation(Matrix A, Matrix B) {
		if (A==this && B==this) return square();
		else
		if (A==this) return this.concatenate(B);
		else
		if (B==this) return this.preconcatenate(A);
		else 
		for (int r=0,R=rows();r<R;r++)
			for (int c=0,C=cols();c<C;c++)
				m[r][c] = A.rowDotCol(r, B, c);
				
		return this;
	}

	
	@Override public ArrayMatrix clone() {
		double B[][] = m.clone();
		
		for (int i=0,I=B.length;i<I;i++)
			B[i] = B[i].clone();
		
		return new ArrayMatrix(B);
	}
	

	@Override
	public String toString() {
		return "ArrayMatrix"+Arrays.deepToString(m);
	}

	
	@Override
	public Matrix solution(Matrix A, Matrix B) {
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
	public Matrix transpose(Matrix A) {
		// TODO Auto-generated method stub
		return null;
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






