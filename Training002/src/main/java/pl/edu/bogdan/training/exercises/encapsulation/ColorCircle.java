package pl.edu.bogdan.training.exercises.encapsulation;

public class ColorCircle extends Circle{
	private String colour;

	public ColorCircle(double x, double y, double radius, String colour) throws NegativeRadiusException {
		super(x, y, radius);
		this.colour = colour;
		// TODO Auto-generated constructor stub
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}
	
	
}
 