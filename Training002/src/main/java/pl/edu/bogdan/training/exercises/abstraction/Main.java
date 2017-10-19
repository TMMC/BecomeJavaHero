package pl.edu.bogdan.training.exercises.abstraction;

public class Main {

	public static void main(String[] args) throws VehicleException{
		
		AbstractVehicle car = new Car(4000, 38.0);
		System.out.println("Car consumption per 100 = " + Car.getFuelConsumptionPer100());
		AbstractVehicle plane = new Plane(18_000, 400.0);
		System.out.println("Plane consumption per 100 = " + Plane.getFuelConsumptionPer100());
		AbstractVehicle ship = new Ship(70_000, 1234.56);
		System.out.println("Ship consumption per 100 = " + Ship.getFuelConsumptionPer100() + "\n");

		System.out.println("Car's mileage = " + car.getMileage() + ", fuel = " + car.getFuel());
		car.go(72);
		System.out.println("After go(): Car's mileage = " + car.getMileage() + ", fuel = " + car.getFuel() + "\n");
		
		System.out.println("Plane's mileage = " + plane.getMileage() + ", fuel = " + plane.getFuel());
		plane.go(876);
		System.out.println("After go(): Plane's mileage = " + plane.getMileage() + ", fuel = " + plane.getFuel() + "\n");

		ship.go(3850);
	}

}
