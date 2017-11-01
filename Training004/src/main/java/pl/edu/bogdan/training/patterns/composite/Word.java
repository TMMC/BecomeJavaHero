package pl.edu.bogdan.training.patterns.composite;

public class Word implements Printable {
	private final String message;
	
	public Word(String m) {
		this.message = m;
	}
	
	@Override
	public void print() {
		System.out.print(message);
	}
}
