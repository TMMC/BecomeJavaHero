package pl.edu.bogdan.training.patterns.prototype;

import java.util.Date;

public class Circle implements Cloneable {
	private String color;
	private int radius;
	private int x;
	private int y;
	private Date date;
	public Circle(String color, int radius, int x, int y, Date date) {
		super();
		this.color = color;
		this.radius = radius;
		this.x = x;
		this.y = y;
		this.date = date;
	}
	public void setX(int x) {
		this.x = x;
	}
	public void setY(int y) {
		this.y = y;
	}
	public Circle clone() {
		return new Circle(new String(color), radius, x, y, (Date) date.clone());
	}
	public Date getDate() {
		return date;
	}
	public static void main(String [] args) {
		Circle c1 = new Circle("blue", 4, 0, 0, new Date(System.currentTimeMillis()));
		Circle c2 = c1.clone();
		
		System.out.println(c1.getDate().toLocaleString());
		System.out.println(c2.getDate().toLocaleString());
		
		c1.date.setHours(10);
		
		System.out.println(c1.getDate().toLocaleString());
		System.out.println(c2.getDate().toLocaleString());
	}
	
}
