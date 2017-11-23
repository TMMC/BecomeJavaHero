package pl.edu.bogdan.training.patterns.decorator;

public abstract class MailDecorator implements Mail {
	private final Mail mail;
	
	public MailDecorator(Mail mail) {
		this.mail = mail;
	}
	
	@Override
	public double getPrice() {
		return mail.getPrice();
	}
	
	public int deliveryTime() {
		return mail.deliveryTime();
	}
}
