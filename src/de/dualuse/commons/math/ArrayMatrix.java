package de.dualuse.commons.math;

import java.util.Arrays;

import javax.sound.midi.Sequence;

public class ArrayMatrix extends Matrix {

	public final double m[][];
	
	ArrayMatrix(double n[][]) {
		m = new double[n.length][];
		for (int i=0,I=m.length;i<I;i++)
			m[i] = n[i].clone();
	}

	public ArrayMatrix(int rows, int cols) {
		this.m = new double[rows][cols];
	}

	@Override
	protected double v(int row, int col) {
		return m[row][col];
	}

	@Override
	protected Matrix v(int row, int col, double v) {
		m[row][col] = v;
		return this;
	}
	
	
	////////// Basic Matrix Operations

	private double inner(int n, Matrix a, int row, Matrix b, int col) {
		double sum = 0;
		
		for (int i=0;i<n;i++)
			sum += a.v(row,i)*b.v(i,col);
		
		return sum;
	}
	
	private void rows(int n, Matrix a, int row, Matrix b, int col) {
		double v = inner(n, a, row, b, col);
		if (col+1<n) rows(n, a, row, b, col+1);
		a.v(row, col,v);
	}
	
	private void cols(int n, Matrix a, int row, Matrix b, int col) {
		double v = inner(n, a, row, b, col);
		if (row+1<n) cols(n, a, row+1, b, col);
		b.v(row, col,v);
	}
	

	@Override
	public ArrayMatrix concatenate(Matrix b) {
		for (int r=0,R=m.length;r<R;r++)
			rows(R,this,r,b,0);
				
		return this;
	}
	
	
	@Override
	public ArrayMatrix preConcatenate(Matrix b) {
		for (int r=0,R=m.length;r<R;r++)
			cols(R,b,0,this,r);
				
		return this;
	}
	
	@Override
	public ArrayMatrix concatenation(Matrix a, Matrix b) {
		if (a.equals(b))
			throw new IllegalArgumentException();
		else
		if (a==this) 
			a.concatenate(b);
		else
		if (b==this) 
			b.preConcatenate(a);
		else
			for (int r=0,c=0,i=0,R=m.length,C=R;r<R;r++,c=i=0)
				for (double sum=C=m[r].length;c<C;m[r][c]=sum,c++)
					for (sum=0,i=0;i<R;i++)
						sum += a.v(r,i)*b.v(i,c);

		return this;
	}
	

	////////// Solving
	
//	public abstract Matrix decompose(Matrix L, Matrix U);
	
	public ArrayMatrix decompose(Matrix L, Matrix U) {

		// Code: Cormen et al., page 756
	    int i, j, k, n = m.length;
	    for ( k = 0; k < n; ++k) {
	        U.v( k, k, m[ k][ k]);
	        for ( i = k; i < n; ++i) {
	            L.v( i, k, m[ i][ k] / U.v( k, k ));
	            U.v( k, i, m[ k][ i]);
	        }
	        for( i = k; i < n; ++i) 
	            for( j = k+1; j < n; ++j) 
	                m[ i][ j] = m[ i][ j] - L.v( i, k)*U.v( k, j);
	    }
		
	    return this.concatenation(L, U);
	}

//	public ArrayMatrix decompose(Matrix L, Matrix U) {
//		for (int k = 0, i = 0, j=0,n=m.length; k<n;i=++k) {
//			for (double v=u[k]=A[k][k];i<n;u[i] = a[i],i++)
//				L[i][k] = A[i][k]/v;
////	
////			for (i=j=k;i<n;i++,j=k)
////				for (double a[]=A[i],u[]=U[k],l=L[i][k];j<n;j++)
////					a[j]-= l*u[j];
////			
//		}
//		
//		// Code: Cormen et al., page 756
////	    int i, j, k, n = m.length;
////	    for ( k = 0; k < n; ++k) {
////	        U.v( k, k, v( k, k));
////	        for ( i = k; i < n; ++i) {
////	            L.v( i, k, v( i, k) / U.v( k, k ));
////	            U.v( k, i, v( k, i) );
////	        }
////	        for( i = k; i < n; ++i) 
////	            for( j = k+1; j < n; ++j) 
////	                m[ i][ j] = m[ i][ j] - L.v( i, k)*U.v( k, j);
////	    }
//		
//	    return this.concatenation(L, U);
//	}


//	 decompose
	protected static void decompose(int n, double[][] M, double[][] L, double[][] U) {
		
	    // Code: Cormen et al., page 756
	    int i, j, k;
	    for ( k = 0; k < n; ++k) {
	        U[ k][ k] = M[ k][ k];
	        for ( i = k+1; i < n; ++i) {
	            L[ i][ k] = M[ i][ k] / U[ k][ k];
	            U[ k][ i] = M[ k][ i];
	        }
	        for( i = k+1; i < n; ++i) {
	            for( j = k+1; j < n; ++j) {
	                M[ i][ j] = M[ i][ j] - L[ i][ k]*U[ k][ j];
	            }
	        }
	    }
	}

	// solve
	protected static void solve(int n, double[][] L, double[][] U, double[] y, double[] x) {
		
	    // Code: Cormen et al., page 756
//	    double[] y = b;//new double[n];
	    int i, j;

	    // forward substitution
	    for ( i = 0; i < n; ++i) {
//	        y[ i] = b[ i];
	        for ( j = 0; j < i; ++j) {
	            y[ i] -= L[ i][ j] * y[ j];
	        }
	    }

	    // back substitution
	    for ( i = n-1; i >= 0; --i) {
	        x[ i] = y[ i];
	        for ( j = i+1; j < n; ++j) {
	            x[ i] -= U[ i][ j] * x[ j];
	        }
	        x[ i] /= U[ i][ i];
	    }
	}
	

	
	
	
	
	
	
	@Override
	public String toString() {
		return "ArrayMatrix"+Arrays.deepToString(m);
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
	Vector transform(Vector v) {
		// TODO Auto-generated method stub
		return null;
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

	@Override
	public Vector fill(Sequence r) {
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






