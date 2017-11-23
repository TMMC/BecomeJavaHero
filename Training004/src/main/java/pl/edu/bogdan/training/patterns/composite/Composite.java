package pl.edu.bogdan.training.patterns.composite;

import java.util.LinkedList;
import java.util.List;

public class Composite implements Printable {
	private List<Printable> printables;
	
	public Composite() {
		printables = new LinkedList<>();
	}
	
	@Override
	public void print() {
		for (Printable p : printables) {
			p.print();
		}
	}
	
	public void add(Printable p) {
		printables.add(p);
	}
	
	public void remove(Printable p) {
		printables.remove(p);
	}
}
