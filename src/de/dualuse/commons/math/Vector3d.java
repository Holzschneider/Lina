package de.dualuse.commons.math;

public class Vector3d extends Vector {

	public double x, y, z;
	
	Vector3d(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	@Override
	double v(int i) {
		switch (i) {
		case 0: return x;
		case 1: return y;
		case 2: return z;
		default: throw new ArrayIndexOutOfBoundsException(i);
		}
	}

	@Override
	Vector3d v(int i, double v) {
		switch (i) {
		case 0: x=v; break;
		case 1: y=v; break;
		case 2: z=v; break;
		default: throw new ArrayIndexOutOfBoundsException(i);
		}
		return this;
	}

}
