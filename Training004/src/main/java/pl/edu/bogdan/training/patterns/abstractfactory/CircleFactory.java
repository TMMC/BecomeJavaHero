package pl.edu.bogdan.training.patterns.abstractfactory;

class CircleShape implements Shape {
	double radius;
	
}

public class CircleFactory implements FigureFactory {
	@Override
	public Figure createFigure(Shape shape) {
		CircleShape s = (CircleShape) shape;
		return new Circle(s.radius);
	}
}
