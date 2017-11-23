package pl.edu.bogdan.training.patterns.composite;

public class CompositeExample {
	public static void main(String[] args) {
		Word w1 = new Word("a");
		Word w2 = new Word("b");
		Word w3 = new Word("c");
		Word w4 = new Word("d");
		Word w5 = new Word("e");
		
		Composite c1 = new Composite();
		Composite c2 = new Composite();
		Composite c3 = new Composite();
		
		c1.add(w1);
		c1.add(w2);
		c1.add(w3);
		
		c2.add(w4);
		c2.add(w5);
		
		c3.add(c1);
		c3.add(c2);
		
		c3.print();
	}
}
