package de.dualuse.commons.math;

public abstract class Matrix {
	public static final double EPSILON = 1e-13;
	
	protected abstract int rows();
	protected abstract int cols();
		
	protected abstract Matrix element(int row, int col, double value);
	protected abstract double element(int row, int col);
	
	protected abstract Matrix row(int row, double[] values);
	
	protected double dot(int col, double vector[]) {
		double sum = 0;
		
		for (int i=0,I=vector.length;i<I;i++)
			sum += this.element(i,col)*vector[i];
		
		return sum;
	}
	
	
	/**
	 * Sets *this* NxN Matrix A to the concatenation of A:=A.A 
	 * @return this
	 */	
	public abstract Matrix square();
	
	/**
	 * Sets *this* MxN Matrix A to the concatenation of A:=A.B 
	 * @param B a NxN matrix that is concatenated to it 
	 * @return this
	 */
	public abstract Matrix concatenate(Matrix b);
	
	
	/**
	 * Sets the NxM Matrix B to the concatenation of B:=A.B 
	 * @param B a NxM matrix that is concatenated to *this* NxN matrix A  
	 * @return B
	 */	
	public abstract Matrix transform(Matrix B);

	/*
	 * Helper function. serves as case switch for specific argument combinations 
	 * that need special treatment.
	 */
	private void concatenate(Matrix b, Matrix ab) {
		if (b==this && ab==this) square();
		else if (b==ab) transform(b);
		else concatenate(b);
	}
	
	
	/**
	 * Sets the NxM matrix B to the solution of the matrix product X:=A^-1.B.
	 * @see solution
	 * @param B a NxM matrix that is solved to *this* NxM matrix A
	 * @return
	 */
	public abstract Matrix solve(Matrix B);
	
	/**
	 * Sets this NxM matrix C to the concatenation of C:=A.B
	 * @param A a NxP matrix
	 * @param b a PxM matrix
	 * @return
	 */
	public Matrix concatenation(Matrix A, Matrix B) {
		A.concatenate(B, this);
		return this;
	}
	
	
	
	/**
	 * Sets this MxN matrix to the solution of the the Matrix Product A^-1.B.
	 * Effectively computes the solution x in A.x = b
	 * 
	 * Uses LU-Decomposition and computes exact solution for A being a NxN Matrix and X an Nx1 Matrix
	 * Uses QR-Decomposition and computes least-squares solution for A being a MxN Matrix and X an Nx1 Matrix with M>N
	 * <em>Functionality intentionally mimics the Matlab function mldivide(A,B)</em>
	 * 
	 * @see http://de.mathworks.com/help/matlab/ref/mldivide.html
	 * @param A non-singular matrix of size PxM 
	 * @param B matrix of size PxN
	 * @return this
	 * @throws IllegalArgumentException upon  
	 */
	public abstract Matrix solution(Matrix A, Matrix B);
	
	////////////////////////
	
	public Matrix identity() { zero(); for (int i=0,I=rows();i<I;i++) element(i,i,1); return this; }
	public Matrix zero() { return fill(0); }
	public Matrix fill(double value) {
		for (int r=0,R=rows();r<R;r++)
			for (int c=0,C=cols();c<C;c++)
				element(r,c,value);
		
		return this;
	}

	public Matrix transpose() { transpose(this.rows(),0,this); return this; }
	static private void transpose(int n, int i, Matrix a) {
		int row = i/n, col = i%n;
		double v= a.element(col,row);
		if (i+1<n*n) transpose(n, i+1, a);
		a.element(row, col, v);
	}

	Matrix transpose(Matrix A) {
		Matrix At = this;
		for (int r=0,R=rows();r<R;r++)
			for (int c=0,C=cols();c<C;c++)
				At.element(r,c, A.element(c,r));
		
		return this;
	}
	
	
	/*
	abstract Matrix invert(Matrix m);
	abstract Matrix invert();
	
	protected Matrix decompose(Matrix L, Matrix U) {
		L.zero();
		U.zero();
		
		//Introduction to Algorithms, Cormen et al., page 749
		Matrix A = this;
		int k = 0, i = 0, j=0, n;
		double a_i[], a_k[], u_k[], ukk, l_ik;
		
		for (i=j=k=0,n=A.rows(); k<n;U.row(k,u_k),i=++k) {
			for (u_k=U.row(k),a_k=A.row(k),ukk=u_k[k]=a_k[k];i<n;i++) {
				L.element(i,k, A.element(i,k)/ukk);
				u_k[i] = a_k[i];
			}
			
			for (i=j=k;i<n;A.row(i,a_i),i++)
				for (a_i = A.row(i),l_ik=L.element(i,k),j=k;j<n;j++)
					a_i[j] -= l_ik*u_k[j];
				
		}
		
		return this.concatenation(L, U);
	}
	

	public<VectorType extends Vector> VectorType solve(Matrix L, Matrix U, VectorType x, Vector b) {
		decompose(L, U);
		
	    // Code: Cormen et al., page 745
	    int i, j, n = rows();
	    double sum, l_i[], u_i[];
	    
	    x.set(b);
	    
	    // forward substitution
	    for (i=0; i < n;++i,j=0) {
	        for ( sum = 0, l_i = L.row(i),j=0; j < i; ++j)
	        	sum += l_i[j] * x.element(j);
	        
	        x.element(i, x.element(i)-sum);
	    }
	    
	    // back substitution
	    for ( i = n-1; i >= 0; --i) {
	        for ( sum = 0, j = i+1, u_i = U.row(i); j < n; ++j) 
	        	sum+=u_i[j]*x.element(j);
	        
	        x.element(i, (x.element(i)-sum)/u_i[i]);
	    }
	    
	    this.transform(b.set(x));
		return x; 
	}

	
	protected void swapRows(int r0, int r1) { swapRows(cols(),0,r0,r1,this); }
	private static void swapRows(int cols, int i, int r0, int r1, Matrix a) {
		
		double v=a.element(r0, i);
		double w=a.element(r1, i);
		
		if (i+1<cols) 
			swapRows(cols,i+1,r0,r1,a);
		
		a.element(r1, i, v);
		a.element(r0, i, w);
		
	}
	
	
	protected Matrix decompose(Matrix L, Matrix U, int pivot[]) {
		int N = rows(), M = cols(), minMN = N < M ? N : M;

		for (int j = 0; j < minMN; j++) {

			int jp = j;

			double t = Math.abs(element(j,j));
			for (int i = j + 1; i < M; i++) {
				double ab = Math.abs(element(i,j));
				if (ab > t) {
					jp = i;
					t = ab;
				}
			}

			pivot[j] = jp;

			if (element(jp,j) == 0)
				throw new IllegalArgumentException("Singular Matrix");

			if (jp != j)
				swapRows(j, jp);
			
			if (j < M - 1) {
				double recp = 1.0 / element(j,j);

				for (int k = j + 1; k < M; k++)
					element(k,j, element(k,j)*recp);
			}

			if (j < minMN - 1) {
				for (int ii = j + 1; ii < M; ii++) {
					double AiiJ = element(ii,j);
					for (int jj = j + 1; jj < N; jj++)
						element(ii,jj, element(ii,jj)-AiiJ*element(j,jj));
				}
			}
		}
		
		for (int r=0;r<minMN;r++) {
			for (int c=0;c<M;c++) {
				L.element(r, c, element(r,c) );
				U.element(r, c, 0);
			}

			for (int c=r;c<M;c++) {
				U.element(r, c, element(r,c) );
				L.element(r, c, 0);
			}
			
			L.element(r, r, 1);
		}
		
//		this.concatenation(L, U);
//		for (int r=0;r<minMN;r++)
//			swapRows(r, pivot[r]);
		
		return this;
	}
	

	public void solve(int pvt[], double b[]) {
		int M = rows(), N = cols();
		int ii=0;
		
		for (int i=0;i<M;i++) {
			int ip = pvt[i];
			double sum = b[ip];			
			
			b[ip] = b[i];
			if (ii == 0)
				for (int j = ii; j < i; j++)
					sum -= element(i,j) * b[j];
			else
				if (sum==0.0)
					ii = i;
			
			b[i] = sum;
		}
		
		for (int i = N - 1; i >= 0; i--) {
			double sum = b[i];
			for (int j = i + 1; j < N; j++)
				sum -= element(i,j) * b[j];
			b[i] = sum / element(i,i);
		}
	}
	
	public<VectorType extends Vector> VectorType solve(int pvt[], VectorType v) {
		double[] w = v.values();
		solve(pvt,w);
		v.values(w);
		return v;		
	}
	
	
	public void repair(Matrix L, Matrix U, int[] pivot) {
		int N = rows(), M = cols(), minMN = N < M ? N : M;
		this.concatenation(L, U);
		for (int r=0;r<minMN;r++)
			swapRows(r, pivot[r]);
	}
	
//	public static void solve(double LU[][], int pvt[], double b[]) {
//		int M = LU.length;
//		int N = LU[0].length;
//		int ii = 0;
//	
//		for (int i = 0; i < M; i++) {
//			int ip = pvt[i];
//			double sum = b[ip];
//	
//			b[ip] = b[i];
//			if (ii == 0)
//				for (int j = ii; j < i; j++)
//					sum -= LU[i][j] * b[j];
//			else if (sum == 0.0)
//				ii = i;
//			b[i] = sum;
//		}
//	
//		for (int i = N - 1; i >= 0; i--) {
//			double sum = b[i];
//			for (int j = i + 1; j < N; j++)
//				sum -= LU[i][j] * b[j];
//			b[i] = sum / LU[i][i];
//		}
//	}
	
	
	private void recursiveDots(int rows, int cols, Matrix A, Vector v) {
		int r = rows-1;
		double row[] = A.row(r), sum = 0;
		for (int i=0;i<cols;i++)
			sum += row[i]*v.element(i);
		
		if (r>0) 
			recursiveDots(r, cols, A, v);
		
		v.element(r, sum);
	}
	
	public<VectorType extends Vector> VectorType transform(VectorType v) {
		recursiveDots(rows(),cols(),this,v);
		return v;
	}
	
	public<VectorType extends Vector> VectorType solve(VectorType v) {
		
		throw new UnsupportedOperationException();
//		recursiveDots(rows(),cols(),this,v);
//		return v;
	}
	
	
	
	/////
		
*/	
	@Override public abstract Matrix clone();
	
	public boolean equalsEpsilon(Matrix m) {
		if (m.rows()!=this.rows() || m.cols()!=this.cols()) return false;
		for (int r=0,R=this.rows();r<R;r++)
			for (int c=0,C=this.cols();c<C;c++) {
				double delta = m.element(r,c)-this.element(r, c), deviation = delta*Math.signum(delta);
				if (deviation > EPSILON)
					return false;
			}

		return true;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj==this) return true;
		if (!(obj instanceof Matrix)) return false;
		return equalsEpsilon((Matrix)obj);
	}

	
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
	

	
	
	
}
