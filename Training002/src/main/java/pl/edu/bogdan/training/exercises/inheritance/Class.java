package pl.edu.bogdan.training.exercises.inheritance;

import java.util.ArrayList;

public class Class extends ArrayList<Student> {
	private String name;
	
	public Class(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void addStudent(Student student) {
		add(student);
	}
	
}
