package de.dualuse.commons.math;

public interface Equation {
	Equation set(Matrix m);
	Equation concat(Matrix m);
	Equation transform(Vector v);
	Equation equals(Matrix m);
	
	Vector solve(Vector x);
}
