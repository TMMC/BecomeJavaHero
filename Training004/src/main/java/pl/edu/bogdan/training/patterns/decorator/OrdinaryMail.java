package pl.edu.bogdan.training.patterns.decorator;

public class OrdinaryMail implements Mail {
	@Override
	public double getPrice() {
		return 2.0;
	}

	@Override
	public int deliveryTime() {
		return 7;
	}
}
