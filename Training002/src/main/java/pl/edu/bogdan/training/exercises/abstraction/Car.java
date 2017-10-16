package pl.edu.bogdan.training.exercises.abstraction;

public class Car {
	int milage;
	double fuel;
	static double FUEL_CONSUMPTION_PER_100 = 6.0;
	
	void go(int distance) throws VehicleException {
		System.out.println("Car is going");
		milage += distance;
		fuel -= distance*FUEL_CONSUMPTION_PER_100/100.0;
	}
}
