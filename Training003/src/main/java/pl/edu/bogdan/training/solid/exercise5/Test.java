package pl.edu.bogdan.training.solid.exercise5;

class A {
	void foo() {
		System.out.println("FOO A");
	}
	void bar() {
		foo();
		System.out.println("BAR A");
	}
}

class B extends A {
	@Override
	void foo() {
		System.out.println("FOO B");
	}
	
	void haha() {
		System.out.println("HAHA");
	}
}

public class Test {
	public static void main(String [] args) {
		A b = new B();
		b.bar();
		if (b instanceof B) {
			((B)b).haha();
		}
	}
}
