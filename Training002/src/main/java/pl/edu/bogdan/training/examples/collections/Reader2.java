package pl.edu.bogdan.training.examples.collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class Reader2 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Map<Character, Integer> counter = new HashMap<>();
		
		String line = scanner.nextLine();
		
		for (int i = 0; i < line.length(); i++) {
			char a = line.charAt(i);
			if (counter.containsKey(a)) {
				int w = counter.get(a);
				counter.put(a, w+1);
			} else {
				counter.put(a, 1);
			}
		}
		
		for (Entry<Character, Integer> entry : counter.entrySet()) {
			System.out.println(entry.getKey() + " => " + entry.getValue());
		}
		
	}

}
