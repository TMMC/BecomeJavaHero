package pl.edu.bogdan.training.exercises.encapsulation;

public class ColorfulCircle extends Circle{
	
	private String color;
	
	public ColorfulCircle(double x, double y, double radius, String color) throws NegativeRadiusException{
		super (x,y,radius);
		this.color = color;
		
	}
	public void setRadius(double radius) {
		System.out.println("Klasa colorful circle");
	}
}
