package pl.edu.bogdan.training.unittests;

public interface Board {
	double getWidth();
	double getHeight();
	int getXOriginCoordinate();
	int getYOriginCoordinate();
	boolean containsPoint(double x, double y);
}
