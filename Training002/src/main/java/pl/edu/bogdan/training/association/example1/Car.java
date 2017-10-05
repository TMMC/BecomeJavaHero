package pl.edu.bogdan.training.association.example1;

public class Car {
	private String color;
	private int mileage;
	
	public Car(String color, int mileage) {
		super();
		this.color = color;
		this.mileage = mileage;
	}
	
	public void go(int numberOfMiles) {
		mileage += numberOfMiles;
	}
}
