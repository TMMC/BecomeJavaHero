package pl.edu.bogdan.training.patterns.chainofresponsibility;

public class Student {
	private final String firstName;
	private final String lastName;
	private final int level;
	private Student next;
	public Student(String firstName, String lastName, int level) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.level = level;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public int getLevel() {
		return level;
	}
	public void setNext(Student student) {
		next = student;
	}
	public void pass(Subject subject) {
		if (subject.getDifficultyLevel() <= level) {
			System.out.println(subject.getName() + " is passed by " + this);
		} else {
			next.pass(subject);
		}
	}
	@Override
	public String toString() {
		return "Student [firstName=" + firstName + ", lastName=" + lastName + ", level=" + level + "]";
	}
}
