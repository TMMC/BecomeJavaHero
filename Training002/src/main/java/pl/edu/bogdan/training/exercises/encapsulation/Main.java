package pl.edu.bogdan.training.exercises.encapsulation;

public class Main {

	public static void main(String[] args) {
		Circle circle = new Circle();
		try {
			circle.setRadius(-4);
		} catch (NegativeRadiusException e) {
			e.printStackTrace();
		}

	}

}
