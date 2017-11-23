package pl.edu.bogdan.training.exercises.enumerator;

public class TestEnum {
	public static void main(String [] args) {
		Operation op = Operation.ADD;
		
		for (Operation o : Operation.values()) {
			System.out.println(o.name());
			System.out.println(o.ordinal());
		}
	}
}
