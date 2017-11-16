package pl.edu.bogdan.training.patterns.bridge;

public class CircleRenderer implements Renderer {
	@Override
	public void render(Object o) {
		Circle circle = (Circle) o;
		System.out.println("I am drawing circle in " 
		+ circle.getX() + ", " + circle.getY());
	}
}
