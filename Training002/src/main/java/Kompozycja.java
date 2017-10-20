import java.util.List;

public class Kompozycja {

}
public class Person {
	private String firstName;
	private String lastName;
	private final String PESEL;
	public String getFirstName() {
		return firstName;
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
public class Teacher extends Person {
	private List<School> schools;
	
	public Teacher(String first Name, String lastName, String PESEL) {
	super(firstName, lastName, PESEL);
	schools = new LinkedList<>();
	}	
	public void addSchool(School school) {
		if (schools.size() >=3) {
	
		}
	}
	
}

public class School {
	private String name;
	private List<Teacher> teachers;
	
	public School(String name) {
		this.name = name;
		teachers = new LinkedList<>();
		classess = Array.asList(new Class("Math"),new Class("Biology"), new Class("Computer Science"));
	}
	
	public void addTeacher(Teacher teacher) {
		if (teachers.size()>=50) {
			throw new IllegalArgumentException("You cannot add more teachers");
		}
		techer.addSchool(this);
		teachers.add(teacher);
	}
	public static void hireTeacherToSchol (School school, Teacher teacher) {
		school.addTeacher(teacher);
		try {
			teacher.addSchool(school);
		} catch (IllegalArgumentException e) {
			school.removeTeacher(teacher);
			throw e;
		}
	}
}
public class Class {
	String name;
	public Class (String name) {
		this.name = name;
	}
}