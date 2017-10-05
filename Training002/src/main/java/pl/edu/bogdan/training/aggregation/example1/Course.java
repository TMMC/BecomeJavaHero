package pl.edu.bogdan.training.aggregation.example1;

public class Course {
	private String name;
	private Student[] students;
	private int amountOdStudents;
	
	public Course(String name, int size) {
		this.name = name;
		this.students = new Student[size];
		this.amountOdStudents = 0;
	}
	
	public void addStudent(Student s) {
		if (amountOdStudents + 1 < students.length) {
			students[amountOdStudents] = s;
			amountOdStudents++;
		}
	}
	
}
