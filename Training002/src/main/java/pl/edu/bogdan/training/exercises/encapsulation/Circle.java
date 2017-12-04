package pl.edu.bogdan.training.exercises.encapsulation;

public class Circle {
	
	class Inner {
		
	}
	
	static class Nested {
		
	}
	
	/**
	 * X-coordinate of center of the circle
	 */
	private final double x;
	
	/**
	 * Y-coordinate of center of the circle
	 */
	private final double y;
	
	/**
	 * Radius of the circle
	 */
	private final double radius;
	
	public Circle(double x, double y, double radius) throws NegativeRadiusException {
		if (radius < 0) {
			throw new NegativeRadiusException();
		}
		this.x = x;
		this.y = y;
		this.radius = radius;
	}
	
	public double getRadius() {
		return radius;
	}
	
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
	
//	public final void setRadius(double radius) throws NegativeRadiusException {
//		System.out.println("Klasa Circle");
//		if (radius < 0) {
//			throw new NegativeRadiusException();
//		}
//		this.radius = radius;
//	}
//	
//	public void setX(double x) {
//		this.x = x;
//	}
//	
//	public void setY(double y) {
//		this.y = y;
//	}
}
