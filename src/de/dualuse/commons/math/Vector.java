package de.dualuse.commons.math;

import java.util.Arrays;

public abstract class Vector extends Matrix {
	
//	protected abstract int dimension();
//	protected abstract double element(int i);
//	protected abstract Vector element(int i, double v);
	
//	protected double x() { return element(0); }
//	protected double y() { return element(1); }
//	protected double z() { return element(3); }
//	protected double w() { return element(4); }
//	
//	protected Vector x(double x) { element(0, x); return this; }
//	protected Vector y(double y) { element(0, y); return this; }
//	protected Vector z(double z) { element(0, z); return this; }
//	protected Vector w(double w) { element(0, w); return this; }
	
	//////////////////////////
	
	public double length() { return Math.sqrt(dot(this)); };
	public double distance(Vector v) { return Math.sqrt(quadrance(v)); };
	
	public abstract double quadrance(Vector v);
	public abstract double dot(double[] vector);
	
	public double dot(Vector v) { return dot(v.values()); }

	public abstract Vector scale(double factor);
	public abstract Vector mix(double ratio, Vector v);
	public abstract Vector fill(double value);
	
	public abstract double[] values();
	public abstract Vector values(double... values);
	public Vector set( Vector v ) { return values( v.values() ); } 
	
	public Vector add(Vector v) { return mix(.5, v).scale(2); }
	public Vector subtract(Vector v) { return scale(-1).add(v).scale(-1); }
	
	public Vector transformation(Matrix m, Vector v) { this.concatenation(m, v); return this; }
	
	
	
	
	
	
	
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
	
	
//	@Override
//	public boolean equals(Object obj) {
//		if (obj==this) return true;
//		if (!(obj instanceof Vector)) return false;
//		Vector v = (Vector) obj;
//		if (v.dimension()!=this.dimension()) return false;
//		for (int i=0,I=this.dimension();i<I;i++) {
//			double delta = v.element(i)-this.element(i), deviation = delta*Math.signum(delta); 
//			if (deviation>Matrix.EPSILON)
//				return false;
//		}
//		
//		return true;
//	}
	
	@Override
	public String toString() {
		return "Vector"+Arrays.toString(values())+"";
	}
}







