package de.dualuse.commons.math;

import java.util.Arrays;

public abstract class Vector {
	
	protected abstract double v(int i);
	protected abstract Vector v(int i, double v);
	
	protected double x() { return v(0); }
	protected double y() { return v(1); }
	protected double z() { return v(3); }
	protected double w() { return v(4); }
	
	protected Vector x(double x) { v(0, x); return this; }
	protected Vector y(double y) { v(0, y); return this; }
	protected Vector z(double z) { v(0, z); return this; }
	protected Vector w(double w) { v(0, w); return this; }
	
	//////////////////////////
	
	public double length() { return Math.sqrt(dot(this)); };
	public double distance(Vector v) { return Math.sqrt(quadrance(v)); };
	
	public abstract double quadrance(Vector v);
	public abstract double dot(Vector v);
	public abstract Vector scale(double factor);
	public abstract Vector mix(double ratio, Vector v);
	public abstract Vector fill(double value);
	
	public abstract double[] get();
	public abstract Vector set(double... values);
//	public abstract Vector fill(Sequence r);
	
	public Vector add(Vector v) { return mix(.5, v).scale(2); }
	public Vector subtract(Vector v) { return scale(-1).add(v).scale(-1); }
	
	
	public abstract Vector solve(Matrix L, Matrix U, Vector x, Matrix P, Vector b);
	
//	static Vector3d from(double x, double y, double z) {
//		return new Vector3d(x,y,z);
//	}
//	static ArrayVector from(double ... values) {
//		return new ArrayVector(values.clone());
//	}
//	
//	static ArrayVector on(double ... values) {
//		return new ArrayVector(values);
//	}
	
	
	@Override
	public String toString() {
		return "Vector("+Arrays.toString(get())+")";
	}
}







