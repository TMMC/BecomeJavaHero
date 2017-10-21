package pl.edu.bogdan.training.examples.collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Reader {
	public static void main(String [] args) {
		Scanner scanner = new Scanner(System.in);
		
		List<Integer> integers = new LinkedList<>();
		
		int a;
		
		do {
			a = scanner.nextInt();
			integers.add(a);
		} while (a != 0);
		
		for (int i = 0; i < integers.size(); i++) {
			System.out.println(integers.get(i));
		}
		
		for (int b : integers) {
			System.out.println(b);
		}
	}
}
