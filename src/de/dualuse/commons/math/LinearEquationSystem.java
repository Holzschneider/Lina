package de.dualuse.commons.math;

import java.util.LinkedList;

import de.dualuse.commons.math.LinearEquationSystem.Sum;

interface Expression {
	Expression times(Matrix m);
	Term plus(Matrix m);
	Term minus(Matrix m);
	
	Term equals();
}


interface Term {
	Term times(Matrix m);
	Term plus(Matrix m);
	
	Term equals();
}

interface Variable<T> {
	
}

public class LinearEquationSystem implements Term {
	
	static class Value {
		Matrix m;
		int row, col;
		
		public Value(Matrix source, int row, int col) {
			this.m = source;
			this.row = row;
			this.col = col;
		}
		
		public boolean same(Value v) {
			return m == v.m && row == v.row && col == v.col;
		}
	}
	
	static class Product extends LinkedList<Value> {
		public Product(Value v) {
			this.add(v);
		}
		public Product(Value a, Value b) {
			this.add(a);
			this.add(b);
		}
	}
	
	static class Sum extends LinkedList<Product> {
		public Sum(Sum s) {
			super(s);
		}

		public Sum(Product p) {
			this.add(p);
		}
		
		public Sum() { }
		
		public Sum times(Value v) {
			for (Product p: this)
				p.add(v);
			
			return this;
		}
		
		public void plus(Sum m) {
			for (Product p: m)
				this.add(p);
		}
	}
	
	Sum equations[][];
	
	public LinearEquationSystem(Matrix seed) {
		equations = new Sum[seed.rows()][seed.cols()];
		
		for (int r=0,R=seed.rows();r<R;r++)
			for (int c=0,C=seed.cols();c<C;c++)
				equations[r][c] = new Sum(new Product(new Value(seed,r,c)));
		
	}
	
	static public Term let(Matrix m) {
		return new LinearEquationSystem(m); 
	}
	
	
	@Override
	public Term times(Matrix m) {

		Sum[][] n = new Sum[equations.length][m.rows()];
		
		for (int r=0,R=n.length;r<R;r++)
			for (int c=0,C=n[r].length;c<C;c++) {
				Sum z = new Sum();
				for (int s=0,S=C;s<S;s++)
					z.plus(new Sum(equations[r][s]).times( new Value(m,s,r) ));
				
				n[r][c] = z;
			}
		return this;
	}
	
	
	
	@Override
	public Term plus(Matrix m) {
		return null;
	}

	@Override
	public Term equals() {
		return null;
	}

	
	
	
	
	
}
