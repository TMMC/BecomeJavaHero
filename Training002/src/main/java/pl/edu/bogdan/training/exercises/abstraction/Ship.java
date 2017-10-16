package pl.edu.bogdan.training.exercises.abstraction;

public class Ship {
	int milage;
	double fuel;
	static double FUEL_CONSUMPTION_PER_100 = 55.0;
	
	void go(int distance) {
		System.out.println("Ship is going");
		milage += distance;
		fuel -= distance*FUEL_CONSUMPTION_PER_100/100.0;
	}
}
