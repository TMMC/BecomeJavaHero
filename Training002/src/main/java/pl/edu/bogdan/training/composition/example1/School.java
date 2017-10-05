package pl.edu.bogdan.training.composition.example1;

public class School {
	private String name;
	private Course[] courses;
	
	public School(String name) {
		this.name = name;
		this.courses = new Course[4];
		this.courses[0] = new Course("Literature");
		this.courses[0] = new Course("Math");
		this.courses[0] = new Course("Biology");
		this.courses[0] = new Course("History");
	}
}
