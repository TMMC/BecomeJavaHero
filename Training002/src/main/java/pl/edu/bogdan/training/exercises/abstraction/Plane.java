package pl.edu.bogdan.training.exercises.abstraction;

public class Plane extends AbstractVehicle{
	
	private final static double FUEL_CONSUMPTION_PER_100 = 120.0;
	
	public static double getFuelConsumptionPer100() {
		return FUEL_CONSUMPTION_PER_100;
	}
	
	Plane (int mileage, double fuel) throws VehicleException {
		if (fuel < 0)
			throw new VehicleException("Fuel level cannot be negative");
		this.mileage = mileage;
		this.fuel = fuel;
	}
	
	public void go(int distance) throws UnexpectedVehicleException {
		System.out.println("Plane is going");
		mileage += distance;
		fuel -= distance*FUEL_CONSUMPTION_PER_100/100.0;
	}
}
