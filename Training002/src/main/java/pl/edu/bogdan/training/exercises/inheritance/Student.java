package pl.edu.bogdan.training.exercises.inheritance;

public class Student {
	private String firstName;
	private String lastName;

	public String getFirstName() {
		return firstName;
	}

	public Student(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
