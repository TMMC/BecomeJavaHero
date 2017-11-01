package pl.edu.bogdan.training.patterns.decorator;

public class ExpressMail extends MailDecorator {
	public ExpressMail(Mail mail) {
		super(mail);
	}
	
	@Override
	public double getPrice() {
		return super.getPrice() * 3;
	}
	
	@Override
	public int deliveryTime() {
		return super.deliveryTime() / 3;
	}
}
