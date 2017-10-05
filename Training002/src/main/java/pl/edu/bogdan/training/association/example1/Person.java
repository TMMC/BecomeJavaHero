package pl.edu.bogdan.training.association.example1;

public class Person {
	private String name;

	public Person(String name) {
		super();
		this.name = name;
	}
	
	public void travel(Car car, int distance) {
		car.go(distance);
	}
}
