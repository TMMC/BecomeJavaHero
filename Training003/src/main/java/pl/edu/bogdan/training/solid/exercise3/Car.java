package pl.edu.bogdan.training.solid.exercise3;

interface Person {
	
}

interface Case {
	
}

interface LuggageCarrier {
	void addCase(Case suitcase);
	void removeCase();
}

interface PassangerCarrier {
	void addCase(Case suitcase);
	void removeCase();
}

interface Driveable {
	void addDriver(Person person);
	void removeDriver();
}

public interface Car extends LuggageCarrier, PassangerCarrier, Driveable {
	void startEngine();
	void stopEngine();
	void addFuel(int liters);
	void useFuel(int liters);
	void replaceOil();
	void blowWheels();
	
	
}
