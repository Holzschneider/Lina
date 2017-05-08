package de.dualuse.lina;

public abstract class Vector {

//	https://de.wikipedia.org/wiki/Norm_(Mathematik)#Matrixnormen
	public abstract double norm(double p);
	
	public abstract double quadrance(Vector v);
//	public abstract double dot(double[] vector);
	
	public abstract double dot(Vector v); 
	
	public abstract Vector scale(double factor);
	public abstract Vector mix(double ratio, Vector v);
	public abstract Vector fill(double value);
	
//	public abstract double[] values();
//	public abstract Vector values(double... values);
//	public Vector set( Vector v ) { return values( v.values() ); } 
	
	public Vector add(Vector v) { return mix(.5, v).scale(2); }
	public Vector subtract(Vector v) { return scale(-1).add(v).scale(-1); }
	
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







