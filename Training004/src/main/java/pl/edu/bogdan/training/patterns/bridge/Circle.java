package pl.edu.bogdan.training.patterns.bridge;

public class Circle extends Shape {
	
	private int x;
	private int y;
	private int radius;
	
	public Circle(Renderer renderer, int x, int y, int radius) {
		super(renderer);
		this.x = x;
		this.y = y;
		this.radius = radius;
	}

	@Override
	public void draw() {
		renderer.render(this);
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getRadius() {
		return radius;
	}
	
	
}
