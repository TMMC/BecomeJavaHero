package pl.edu.bogdan.training.patterns.builder.example;

public class Circle {
	private double x;
	private double y;
	private double radius;
	
	private Circle(Builder builder) {
		x = builder.x;
		y = builder.y;
		radius = builder.radius;
	}
	
	public static class Builder {
		private double x;
		private double y;
		private double radius;
		
		public Builder() {
			
		}
		
		public Builder x(double x) {
			this.x = x;
			return this;
		}
		
		public Builder y(double y) {
			this.y = y;
			return this;
		}
		
		public Builder radius(double radius) {
			this.radius = radius;
			return this;
		}
		
		public Circle build() {
			return new Circle(this);
		}
	}
	
	public static void main(String [] args) {
		Circle.Builder builder = new Circle.Builder();
		Circle circle = builder.x(3).y(4).radius(5).build();
		String s = "pawel";
		s.substring(3).toUpperCase().charAt(2);
	}
	
}
