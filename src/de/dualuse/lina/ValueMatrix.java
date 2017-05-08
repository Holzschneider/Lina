package de.dualuse.lina;

public abstract class ValueMatrix {
	protected abstract int rows();
	protected abstract int cols();
		
	protected abstract double element(int row, int col);
	protected abstract double[] row(int row, double[] values);
	
//	protected abstract double rowDotCol(int row, Matrix B, int col);
	
	abstract protected double colDotArray(int col, double vector[]); 

}
