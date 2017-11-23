package pl.edu.bogdan.training.patterns.observer;

import java.util.Observable;
import java.util.Random;

public class EventSource extends Observable implements Runnable {
	private Random random = new Random(System.currentTimeMillis());
	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(random.nextInt(20));
				int a = random.nextInt(1000);
				setChanged();
				notifyObservers(a);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}


class TestThread extends Thread {
	public void run() {
		
	}
}