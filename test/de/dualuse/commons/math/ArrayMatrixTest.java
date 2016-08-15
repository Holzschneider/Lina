package de.dualuse.commons.math;

public class ArrayMatrixTest {
	public static void main(String[] args) {
		
		
//		Equation e = Equation.let(A).concat(b).transform(x).equal( b );
//		Equation e = Equation.let(A).mul(B).mul(x).equal( b );
//		e.solve(x);
//		
//		Matrix A = ...;
//		Vector b = ...;
//		Variable<Vector> x = ...;
//		Vector result = Equation.let(A).times(x).equal(b).solve();
//		
//		Equation.let(a).times(x1).plus( 
		
		double[][] A ={
			{ 3.5,     12,     3,    13 },
			{ 5,     11,    10,     8 },
			{ 9,      7,     6,    12 },
			{ 4,     14,    15,     1 }
		};
		
		
		double[][] L_ = new double[4][4];
		double[][] U_ = new double[4][4];
		
//		decompose(4, A, L_, U_);
		
		ArrayMatrix M = new ArrayMatrix(A);
		ArrayMatrix L = new ArrayMatrix(L_), U = new ArrayMatrix(U_);
		
//		M.decompose(L, U);
		
		
		System.out.println(toString(M));
		System.out.println();
		System.out.println(toString(L));
		System.out.println(toString(U));
		

//		double[][] A ={	{ 1, 2, 3 },
//						{ 4, 5, 6 },
//						{ 7, 8, 9 } };
//		
//		double[][] B ={	{ 10, 11, 12 },
//						{ 13, 14, 15 },
//						{ 16, 17, 18 } };
//
//		ArrayMatrix m = new ArrayMatrix(A).preconcatenate(new ArrayMatrix(B));
//		ArrayMatrix m = new ArrayMatrix(new double[3][3]).concatenation( new ArrayMatrix(B), new ArrayMatrix(A) );
		
//		System.out.println(m);
		
	}
	
	static public String toString(Matrix m) {
		return m.toString().replaceAll("\\[([^\\[])", "\n[$1").replaceAll(" -", "-");
	}



	

//	 decompose
	protected static void decompose(int n, double[][] A, double[][] L, double[][] U){
		for (int k = 0, i = 0, j=0; k<n;i=++k) {
			for (double u[]=U[k],a[]=A[k],v=u[k]=A[k][k];i<n;u[i] = a[i],i++)
				L[i][k] = A[i][k]/v;

			for (i=j=k;i<n;i++,j=k)
				for (double a[]=A[i],u[]=U[k],l=L[i][k];j<n;j++)
					a[j]-= l*u[j];
			
		}
		
		for (int r=0,c=0,i=0;r<n;r++,c=i=0)
			for (double sum=0;c<n;A[r][c]=sum,c++,i=0,sum=0)
				for (double l[]=L[r];i<n;i++)
					sum += l[i]*U[i][c];
		
	}

	// solve
	protected static void solve(int n, double[][] L, double[][] U, double[] y, double[] x) {
		
	    // Code: Cormen et al., page 756
	    // forward substitution
	    for ( int i = 0,j=0; i < n; ++i,j=0)  
	        for ( double[] l=L[i]; j < i; ++j) 
	        	y[ i] -= l[ j] * y[ j];
	    
	    // back substitution
	    for ( int i = n-1; i >= 0; --i) {
	        x[ i] = y[ i];
	        final double[] u = U[i];
	        for ( int j = i+1; j < n; ++j) 
	            x[ i] -= u[ j] * x[ j];
	        
	        x[ i] /= U[ i][ i];
	    }
	}
	

}


