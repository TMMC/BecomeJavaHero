package pl.edu.bogdan.training.exercises.encapsulation;

public class Test {

	public static void main(String[] args) {
		Circle c = null;
		Circle cc = null;
		try {
			c = new Circle(2,3,4);
			cc = new ColourfulCircle(4, 5, 6, "red");
//			c.setRadius(77);
//			cc.setRadius(77);
		} catch (NegativeRadiusException e) {
			
		}
		
		
		
		System.out.println("Promien: " + c.getRadius());
		System.out.println("Promien: " + cc.getRadius());
		System.out.println("X: " + c.getX());
		System.out.println("Y: " + c.getY());

	}

}
