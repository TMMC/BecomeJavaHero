package pl.edu.bogdan.training.exercises.abstraction;

public class Plane {
	int milage;
	double fuel;
	static double FUEL_CONSUMPTION_PER_100 = 120.0;
	
	void go(int distance) throws UnexpectedVehicleException {
		System.out.println("Plane is going");
		milage += distance;
		fuel -= distance*FUEL_CONSUMPTION_PER_100/100.0;
	}
}
