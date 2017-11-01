package pl.edu.bogdan.training.patterns.proxy;

public class FileProxy implements File {
	private String filename;
	private User user;
	private RealFile realFile;
	public FileProxy(String filename, User user) {
		super();
		this.filename = filename;
		this.user = user;
	}
	@Override
	public void displayContent() {
		if (user.getRole().equals("root")) {
			if (realFile == null) {
				realFile = new RealFile(filename);
			}
			realFile.displayContent();
		} else {
			System.out.println("You do not permitted to read this file");
		}
	}
}
