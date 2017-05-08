package de.dualuse.lina;


public class Vec2 implements Value2, java.io.Serializable, Curvable<Value2>, Mixable<Value2> {
	private static final long serialVersionUID = 1L;
	
	public double x, y;
	
	
	

	
	public Vec2 mix(Value2 a, Value2 b, final double r) {
		return this.set(a.getX()*r+b.getX()*(1-r), a.getY()*r+b.getY()*(1-r));
	}
	
	public Vec2 cubic(Value2 a, Value2 da, Value2 dd, Value2 d, double r) {
		final double omr = 1-r; 
				
		final double p0x = a.getX(), p0y = a.getY();
		final double p3x = d.getX(), p3y = d.getY();
		
		double p1x = (p3x-p0x)/3+p0x, p1y = (p3y-p0y)/3.+p0y;
		double p2x = (p3x-p0x)*2/3+p0x, p2y = (p3y-p0y)*2/3.+p0y;
		
		if (da!=null) { p1x = da.getX(); p1y = da.getY(); }
		if (dd!=null) { p2x = dd.getX(); p2y = dd.getY(); }
		
		double q0x = p0x*r+p1x*omr, q0y = p0y*r+p1y*omr;
		double q1x = p1x*r+p2x*omr, q1y = p1y*r+p2y*omr;
		double q2x = p2x*r+p3x*omr, q2y = p2y*r+p3y*omr;
		
		double r0x = q0x*r+q1x*omr, r0y = q0y*r+q1y*omr;
		double r1x = q1x*r+q2x*omr, r1y = q1y*r+q2y*omr;
		
		this.set( r0x*r+r1x*omr, r0y*r+r1y*omr );
		
		return this;
	}
	
	
	
	public double getX() { return x; }
	public double getY() { return y; }

	public Vec2 set(double x, double y) { this.x=x; this.y=y; return this; }
	public Vec2 get(Variable<Value2> q) { q.set(this); return this; }
	

	public float getFloatX() { return (float) getX(); }
	public float getFloatY() { return (float) getY(); }
	
	public int getIntX() { return (int) getX(); }
	public int getIntY() { return (int) getY(); }
	
	public void setLocation(double x, double y) { set(x,y); }
	public Vec2 set(Value2 v) { set(v.getX(),v.getY()); return this; }
//	public Vec2 set(Vec2 v) { set(v.getX(),v.getY()); return this; }
	
//	public Vec2 add(Vec2 v) { set(getX()+v.getX(),getY()+v.getY()); return this; }
	public Vec2 add(Value2 v) { set(getX()+v.getX(),getY()+v.getY()); return this; }
//	public Vec2 add(Vec2 v, double scale) { set(getX()+v.getX()*scale,getY()+v.getY()*scale); return this; }
	public Vec2 add(Value2 v, double scale) { set(getX()+v.getX()*scale,getY()+v.getY()*scale); return this; }
	
//	public Vec2 sub(Vec2 v) { set(getX()-v.getX(),getY()-v.getY()); return this; }
	public Vec2 sub(Value2 v) { set(getX()-v.getX(),getY()-v.getY()); return this; }
	public Vec2 sub(Value2 v, double scale) { set(getX()-v.getX()*scale,getY()-v.getY()*scale); return this; }

	

	
	public double theta() {
		double dx = getX();
		double dy = getY();
		
		// Calculate angle
		if(dx == 0.0)
		{
			if(dy == 0)
				return 0.0;
			if(dy > 0.0)
				return 0.5 * Math.PI;
			return 1.5 * Math.PI;
		}
		if(dy == 0.0)
		{
			if(dx > 0.0)
				return 0.0;
			return Math.PI;
		}

		double tan = Math.atan(dy / dx);
		if(dx < 0.0)
			return tan + Math.PI;
		if(dy < 0.0)
			return tan + (2.0 * Math.PI);
		return tan;
	}
	
	public Vec2 scale(double s) { set(getX()*s,getY()*s); return this; }
	
	public Vec2 normalize() { return scale(1./length()); }

	
	public double dot(Value2 v) { return getX()*v.getX()+getY()*v.getY(); }

	public double lengthSq() { final double x = getX(), y = getY(); return x*x+y*y; }
	public double length() { final double x = getX(), y = getY(); return Math.sqrt(x*x+y*y); }

	public double distanceSq(Value2 v2) { return Math.hypot(v2.getX()-this.getX(), v2.getY()-this.getY()); }
	
	public Vec2 fromString(String r) { int split = r.indexOf(' '); this.set(java.lang.Double.parseDouble(r.substring(0, split)),java.lang.Double.parseDouble(r.substring(split,r.length()))); return this; }
	public String toString() { return getX()+" "+getY(); };
	
	
	public Vec2 mix( Value2 v, final double r ) { final double omr = 1.-r; this.set(this.getX()*omr+v.getX()*r, this.getY()*omr+v.getY()*r); return this; }

	public Vec2 turn( int quads ) {
		if (quads%2==0)
			this.scale((quads/2)%2==0?1:-1);
		else
			if (quads%2==1)
				this.set(-this.getY(),this.getX()); 
			if (quads%2==-1)
				this.set( this.getY(),-this.getX());
		
		return this; 
	}
	
	@Override
	public Vec2 clone() {
		return new Vec2().set(x,y);
	}

}