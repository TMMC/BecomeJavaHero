package pl.edu.bogdan.training.exercises.encapsulation;

public class Test {

	public static void main(String[] args) {
		Circle c = null;
		ColorfulCircle  cc = null;
		try {
			c = new Circle(2,3,4);
			cc = new ColorfulCircle(4,5,6,"red");
			c.setRadius(77);
			cc.setRadius(77);
		} catch (NegativeRadiusException e) {
			System.out.println("Jestes glupi");
		}
		c.setX(4);
		c.setY(3);
		System.out.println("Promien:" + cc.getRadius());
		System.out.println("X:" + cc.getX());
		System.out.println("Y:" + cc.getY());
	}

}
