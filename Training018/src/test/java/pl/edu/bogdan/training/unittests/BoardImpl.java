package pl.edu.bogdan.training.unittests;

public class BoardImpl implements Board {
	
	private double width;
	private double height;
	private int x;
	private int y;
	
	public BoardImpl() {
		
	}
	
	public BoardImpl(int i, int j) throws NegativeException {
		if (i < 0 || j < 0)
			throw new NegativeException();
		this.width = i;
		this.height = j;
	}

	public double getWidth() {
		return this.width;
	}

	public double getHeight() {
		return this.height;
	}

	public int getXOriginCoordinate() {
		return this.x;
	}

	public int getYOriginCoordinate() {
		return this.y;
	}

	public boolean containsPoint(double i, double j) {
		if (i < 0 || i > this.width || j < 0 || j > this.height)
			return false;
	
		return true;
	}

	
}
