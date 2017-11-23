package pl.edu.bogdan.training.exercises.encapsulation;

public class ColourfulCircle extends Circle {
	
	private String colour;
	
	public ColourfulCircle(double x, double y, double radius, String colour) throws NegativeRadiusException {
		super(x,y,radius);
		this.colour  = colour;
	}

	public void setRadius(double radius) {
		System.out.println("Klasa Colorful Circle");
		
	}
	
}
