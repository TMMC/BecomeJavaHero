package pl.edu.bogdan.training.solid.exercise6;

import java.util.List;
import java.util.ArrayList;

public class Test {
	public static void main(String [] args) {
		Stack<Number> stack = new Stack<Number>();
		Number n = 3;
		stack.add(n);
		Integer i = 5;
		stack.add(i);
		List<Integer> numbers = new ArrayList<Integer>();
		numbers.add(4);
		numbers.add(5);
		numbers.add(6);
		stack.addAll(numbers);
		
		
		Stack<Integer> s1 = new Stack<Integer>();
		s1.add(4);
		s1.add(5);
//		List<Integer> l = new ArrayList<Integer>();
//		s1.popAll(l);
		Stack<Double> s2 = new Stack<Double>();
		s2.add(4.5);
		s2.add(6.7);
		List<Number> l = new ArrayList<Number>();
		s1.popAll(l);
		s2.popAll(l);
		
		
	}
}
