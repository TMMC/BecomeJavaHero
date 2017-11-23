package pl.edu.bogdan.training.patterns.bridge;

public abstract class Shape {
	protected Renderer renderer;

	public Shape(Renderer renderer) {
		super();
		this.renderer = renderer;
	}
	
	public abstract void draw();
}
