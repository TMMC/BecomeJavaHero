package pl.edu.bogdan.training.unittests;

public interface Board {
	double getWidth();
	double getHeight();
	double getXOriginCoordinate();
	double getYOriginCoordinate();
	boolean containsPoint(double x, double y);
}
