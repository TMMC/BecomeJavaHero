package pl.edu.bogdan.training.exercises.abstraction;

abstract class AbstractVehicle implements Vehicle {
	protected int mileage;
	protected double fuel;
	
	public int getMileage() {
		return mileage;
	}
	public void setMileage(int mileage) {
		this.mileage = mileage;
	}
	public double getFuel() {
		if (fuel < 0)
			return 0;
		return fuel;
	}
	public void setFuel(double fuel) {
		this.fuel = fuel;
	}
		
}
