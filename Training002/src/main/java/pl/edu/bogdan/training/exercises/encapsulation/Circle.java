package pl.edu.bogdan.training.exercises.encapsulation;

public class Circle {
	/**
	 * X-coordinate of center of the circle
	 */
	private double x;
	
	/**
	 * Y-coordinate of center of the circle
	 */
	private double y;
	
	/**
	 * Radius of the circle
	 */
	private double radius;
	
	public double getX(){
		return x;
	}
	
	public void setX(double x){
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) throws NegativeRadiusException {
		if(radius < 0)
			throw new NegativeRadiusException("Promien nie moze byc ujemny");
		this.radius = radius;
	}
	 
}
