package pl.edu.bogdan.training.patterns.observer;

import java.util.Observable;
import java.util.Observer;

public class Test {
	public static void main(String [] args) {
		EventSource eventSource = new EventSource();
		
		eventSource.addObserver(new Observer() {
			@Override
			public void update(Observable o, Object arg) {
				if ((int)arg % 2 == 0) {
					System.out.println("First observer obtained even number: " + arg);
				}
			}
		});
		
		eventSource.addObserver(new Observer() {
			@Override
			public void update(Observable o, Object arg) {
				if ((int)arg % 2 == 1) {
					System.out.println("Second observer obtained odd number: " + arg);
				}
			}
		});
		new Thread(eventSource).start();
	}
}
