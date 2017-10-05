package pl.edu.bogdan.training.inheritance.example1;

public class Car {
	private String color;
	private int mileage;
	
	public Car(String color) {
		super();
		this.color = color;
		this.mileage = 0;
	}
	
	public void go(int numberOfMiles) {
		mileage += numberOfMiles;
	}
}
