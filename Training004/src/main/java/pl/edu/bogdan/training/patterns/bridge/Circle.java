package pl.edu.bogdan.training.patterns.bridge;

public class Circle extends Shape {
	public Circle(Renderer renderer) {
		super(renderer);
	}

	@Override
	public void draw() {
		renderer.render(this);
	}
}
