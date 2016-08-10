package de.dualuse.commons.math;

import java.util.Arrays;

public class ArrayMatrix extends Matrix {

	public final double m[][];
	
	ArrayMatrix(double n[][]) {
		m = new double[n.length][];
		for (int i=0,I=m.length;i<I;i++)
			m[i] = n[i].clone();
	}

	@Override
	double v(int row, int col) {
		return m[row][col];
	}

	@Override
	Matrix v(int row, int col, double v) {
		m[row][col] = v;
		return this;
	}
		
	ArrayMatrix concatenation(Matrix a, Matrix b) {
		if (a==this) 
			a.concatenate(b);
		else
		if (b==this) 
			b.preconcatenate(a);
		else
			for (int r=0,R=m.length;r<R;r++) 
				for (int c=0,C=m[r].length;c<C;c++) {
					double sum = 0;
					for (int i=0;i<C;i++)
						sum += a.v(r, i)*b.v(i, c);
					
					this.v(r, c, sum);
				}
			
		return this;
	}
	
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
	ArrayMatrix concatenate(Matrix b) {
		for (int r=0,R=m.length;r<R;r++)
			rows(R,this,r,b,0);
				
		return this;
	}
	
	
	@Override
	ArrayMatrix preconcatenate(Matrix b) {
		for (int r=0,R=m.length;r<R;r++)
			cols(R,b,0,this,r);
				
		return this;
	}
	
	@Override
	public String toString() {
		return "ArrayMatrix"+Arrays.deepToString(m);
	}
	

	
	
}






