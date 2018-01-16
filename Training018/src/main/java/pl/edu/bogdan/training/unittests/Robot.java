package pl.edu.bogdan.training.unittests;

public class Robot {
	private Board board;
	private double x;
	private double y;
	public Robot(Board board, double x, double y) {
		super();
		this.board = board;
		this.x = x;
		this.y = y;
	}
	public Robot(Board board) {
		this(board, board.getXOriginCoordinate(), board.getYOriginCoordinate());
	}
	public Board getBoard() {
		return board;
	}
	public void setBoard(Board board) {
		this.board = board;
	}
	public double getX() {
		return x;
	}
	public void setX(double x) throws RobotException {
		if (!board.containsPoint(x, y)) {
			throw new RobotException();
		}
		this.x = x;
	}
	public double getY() {
		return y;
	}
	public void setY(double y) throws RobotException {
		if (!board.containsPoint(x, y)) {
			throw new RobotException();
		}
		this.y = y;
	}
	public void move(double velocity, double time, double direction) throws RobotException {
		double d = velocity*time;
		double dx = Math.abs(d*Math.cos(direction));
		double dy = Math.abs(d*Math.sin(direction));
		double newX = 0.0;
		double newY = 0.0;
		if (direction >= 0 && direction < Math.PI/2.0) {
			newX = x + dx;
			newY = y + dy;
		} else if (direction >= Math.PI/2.0 && direction < Math.PI) {
			newX = x - dx;
			newY = y + dy;
		} else if (direction >= Math.PI && direction < 3.0*Math.PI/2.0) {
			newX = x - dx;
			newY = y - dy;
		} else if (direction >= 3.0*Math.PI/2.0 && direction < 2.0 * Math.PI) {
			newX = x + dx;
			newY = y - dy;
		}
		if (!board.containsPoint(newX, newY)) {
			throw new RobotException();
		} else {
			x = newX;
			y = newY;
		}
	}
	
}
