package pl.edu.bogdan.training.inheritance.example1;

public class Taxi extends Car {
	
	private double priceForMile;
	
	public Taxi(double priceForMile) {
		super("yellow");
		this.priceForMile = priceForMile;
	}
	
	public double costOfCourse(int distance) {
		go(distance);
		return distance*priceForMile;
	}
}
