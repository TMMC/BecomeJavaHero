package pl.edu.bogdan.training.patterns.nullobjectpattern;

import pl.edu.bogdan.training.patterns.chainofresponsibility.Subject;

public class NullStudent extends Student {

	public NullStudent(String firstName, String lastName, int level) {
		super(firstName, lastName, level);
	}
	public void pass(Subject subject) {
		System.out.println("There is no student to pass " + subject.getName());
	}
}
