package pl.edu.bogdan.training.patterns.proxy;

public class RealFile implements File {
	private String filename;
	
	public RealFile(String filename) {
		this.filename = filename;
		loadContent();
	}
	
	public void loadContent() {
		System.out.println("Reading content");
	}
	
	public void displayContent() {
		System.out.println("This is content");
	}
}
