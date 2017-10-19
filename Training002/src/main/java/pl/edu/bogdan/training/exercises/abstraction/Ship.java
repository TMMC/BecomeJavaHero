package pl.edu.bogdan.training.exercises.abstraction;

public class Ship extends AbstractVehicle {
	
	private final static double FUEL_CONSUMPTION_PER_100 = 55.0;
	
	public static double getFuelConsumptionPer100() {
		return FUEL_CONSUMPTION_PER_100;
	}
	
	Ship(int mileage, double fuel) throws VehicleException {
		if (fuel < 0)
			throw new VehicleException("Fuel level cannot be negative");
		this.mileage = mileage;
		this.fuel = fuel;
	}
	
	@Override
	public void go(int distance) {
		System.out.println("Ship is going");
		mileage += distance;
		fuel -= distance * FUEL_CONSUMPTION_PER_100/100.0;
	}
	
}
