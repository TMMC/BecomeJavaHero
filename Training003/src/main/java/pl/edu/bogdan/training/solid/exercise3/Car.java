package pl.edu.bogdan.training.solid.exercise3;

interface Person {
	
}

interface Case {
	
}

public interface Car {
	void startEngine();
	void stopEngine();
	void addFuel(int liters);
	void useFuel(int liters);
	void replaceOil();
	void blowWheels();
	void addDriver(Person person);
	void removeDriver();
	void addPassanger(Person person);
	void removePassanger();
	void addCase(Case suitcase);
	void removeCase();
}
