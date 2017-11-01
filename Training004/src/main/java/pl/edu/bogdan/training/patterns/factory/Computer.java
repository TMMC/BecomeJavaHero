package pl.edu.bogdan.training.patterns.factory;

public abstract class Computer {
	public IProcessor processor;
	
	public Computer() {
		processor = createProcessor();
	}
	
	abstract protected IProcessor createProcessor();
}
