package pl.edu.bogdan.training.exercises.enumerator;

public enum Operation {
	ADD {
		public double calc(double a, double b) {
			return a + b;
		}
	}, SUB, MUL, DIV;
//	public abstract double calc(double a, double b);
}
