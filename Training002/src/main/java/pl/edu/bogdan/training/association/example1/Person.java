package pl.edu.bogdan.training.association.example1;

public class Person {
	private String name;
	public int pole;

	public Person(String name) {
		this.name = name;
	}
	
	public void travel(Car car, int distance1) {
		car.go(distance1);
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
}
