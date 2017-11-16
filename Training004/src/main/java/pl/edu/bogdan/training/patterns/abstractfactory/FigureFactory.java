package pl.edu.bogdan.training.patterns.abstractfactory;

interface Shape {};

public interface FigureFactory {
	Figure createFigure(Shape shape);
}
