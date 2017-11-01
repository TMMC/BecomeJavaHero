package pl.edu.bogdan.training.patterns.abstractfactory;

public class CircleFactory implements FigureFactory {
	@Override
	public Figure createFigure() {
		return new Circle();
	}
}
