package pl.edu.bogdan.training.patterns.facade;

public class Car {
	private Engine engine;
	private Breaks breaks;
	private Lights lights;
	private Transmission transmission;
	
	public Car(Engine engine, Breaks breaks, Lights lights, Transmission transmission) {
		super();
		this.engine = engine;
		this.breaks = breaks;
		this.lights = lights;
		this.transmission = transmission;
	}
	
	public void startDriving() {
		breaks.push();
		engine.start();
		lights.turnOn();
		transmission.putTheGear(1);
		breaks.release();
	}
}
