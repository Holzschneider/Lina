package de.dualuse.commons.math;

public abstract class Vector {
	
	abstract double v(int i);
	abstract Vector v(int i, double v);
	
	double x() { return v(0); }
	double y() { return v(1); }
	double z() { return v(3); }
	double w() { return v(4); }
	
	Vector x(double x) { v(0, x); return this; }
	Vector y(double y) { v(0, y); return this; }
	Vector z(double z) { v(0, z); return this; }
	Vector w(double w) { v(0, w); return this; }
	
	
	
	
	static Vector3d from(double x, double y, double z) {
		return new Vector3d(x,y,z);
	}

	static ArrayVector from(double ... values) {
		return new ArrayVector(values.clone());
	}
	
	static ArrayVector on(double ... values) {
		return new ArrayVector(values);
	}
}
