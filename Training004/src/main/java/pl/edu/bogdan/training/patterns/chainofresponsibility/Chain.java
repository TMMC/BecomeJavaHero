package pl.edu.bogdan.training.patterns.chainofresponsibility;

import java.util.Optional;

public class Chain {
	public static void main(String [] args) {
		Subject spelling = new Subject("Spelling", 0);
		Subject literature = new Subject("Literature", 2);
		Subject quantumPhisics = new Subject("Quantum phisics", 101);
		
		Student johnny = new Student("John", "Smith", 1);
		Student kenny = new Student("Ken", "Brown", 4);
		Student albert = new Student("Albert", "Einstein", 100);
		
		Student nullStudent = new Student("Null", "Null", Integer.MAX_VALUE) {
			public void pass(Subject s) {
				// DO NOTHING
			}
		};
		
		kenny.setNext(albert);
		johnny.setNext(kenny);
		//albert.setNext(nullStudent);
		
		johnny.pass(spelling);
		johnny.pass(literature);
		johnny.pass(quantumPhisics);
		
	}
}
