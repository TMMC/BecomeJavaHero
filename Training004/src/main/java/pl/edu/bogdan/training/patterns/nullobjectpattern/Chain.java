package pl.edu.bogdan.training.patterns.nullobjectpattern;

public class Chain {
	public static void main(String [] args) {
		Subject spelling = new Subject("Spelling", 0);
		Subject literature = new Subject("Literature", 2);
		Subject quantumPhisics = new Subject("Quantum phisics", 10);
		
		Student johnny = new Student("John", "Smith", 1);
		Student kenny = new Student("Ken", "Brown", 4);
		Student albert = new Student("Albert", "Einstein", 100);
		
		kenny.setNext(albert);
		johnny.setNext(kenny);
		
		johnny.pass(spelling);
		johnny.pass(literature);
		johnny.pass(quantumPhisics);
	}
}
