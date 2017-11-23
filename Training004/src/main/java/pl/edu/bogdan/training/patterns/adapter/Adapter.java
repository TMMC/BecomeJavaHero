package pl.edu.bogdan.training.patterns.adapter;

public class Adapter implements IDOM {
	private final ISAX sax;
	
	public Adapter(final ISAX sax) {
		this.sax = sax;
	}
	
	// methods of IDOM implemented using sax field
}
