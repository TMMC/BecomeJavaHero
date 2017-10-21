package pl.edu.bogdan.training.examples.inner;

class Test {
	public static void main(String [] args) {
		Outer.Nested nested = new Outer.Nested();
		Outer outer1 = new Outer();
		Outer outer2 = new Outer();
		Outer.Inner inner1 = outer1.new Inner();
		Outer.Inner inner2 = outer2.new Inner();
	}
	
}

public class Outer {
	private int field;
	
	class Inner {
		int f() {
			return field;
		}
	}
	
	static class Nested {
		
	}

}
