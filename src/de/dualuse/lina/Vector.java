package de.dualuse.lina;

public abstract class Vector {
	
	protected abstract int rows();
	protected abstract int cols();
		
//	protected abstract Matrix element(int row, int col, double value);
	protected abstract double element(int row, int col);
	protected abstract double colDotArray(int col, double values[]);
	
	protected abstract double rowAddScaledArray(int row, double scale, double values[]);
	protected abstract double colAddScaledArray(int col, double scale, double values[]);
	
	protected abstract Vector get(int row, double values[]);
	
	///////////////////////////
	
	
//	https://de.wikipedia.org/wiki/Norm_(Mathematik)#Matrixnormen
	public abstract double norm(double p);
	
	public abstract double dot(Vector v); 
	
	public abstract Vector scale(double factor);
//	public abstract Vector mix(double ratio, Vector v);
	public abstract Vector fill(double value);
	
//	public abstract double[] values();
//	public abstract Vector values(double... values);
	public abstract Vector set( Vector v );// { return values( v.values() ); } 
	
	public abstract Vector add(Vector v);// { return mix(.5, v).scale(2); }
	public abstract Vector add(Vector v, double s);// { return mix(.5, v).scale(2); }
	public abstract Vector subtract(Vector v); //{ return scale(-1).add(v).scale(-1); }
	
	protected abstract Vector preconcatenate(Matrix m);
	
//	public Vector transformation(Matrix m, Vector v) { this.concatenation(m, v); return this; }
	
	
	
	
	
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
//	@Override
//	public String toString() {
//		return "Vector("+Arrays.toString(values())+")";
//	}
}







