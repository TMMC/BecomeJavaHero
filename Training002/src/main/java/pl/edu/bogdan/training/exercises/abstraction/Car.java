package pl.edu.bogdan.training.exercises.abstraction;

public class Car extends AbstractVehicle{
	
	private final static double FUEL_CONSUMPTION_PER_100 = 6.0;
	
	Car(int mileage, double fuel) throws VehicleException {
		if (fuel < 0)
			throw new VehicleException("Fuel level cannot be negative");
		this.mileage = mileage;
		this.fuel = fuel;
	}
	
	public static double getFuelConsumptionPer100() {
		return FUEL_CONSUMPTION_PER_100;
	}
	
	public void go(int distance) throws VehicleException {
		System.out.println("Car is going");
		mileage += distance;
		fuel -= distance * FUEL_CONSUMPTION_PER_100 / 100.0;
	}
}
