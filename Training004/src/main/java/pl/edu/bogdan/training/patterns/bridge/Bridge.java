package pl.edu.bogdan.training.patterns.bridge;

public class Bridge {
	public static void main(String [] args) {
		Renderer renderer = new CircleRenderer();
		Shape circle = new Circle(renderer);
		circle.draw();
	}
}
