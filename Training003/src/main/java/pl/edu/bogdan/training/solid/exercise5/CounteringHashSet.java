package pl.edu.bogdan.training.solid.exercise5;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

public class CounteringHashSet<E> extends HashSet<E> {
	int counter = 0;
	
	@Override
	public boolean add(E e) {
		counter++;
		return super.add(e);
	}
	
	@Override
	public boolean addAll(Collection<?extends E> elements) {
		counter+= elements.size();
		return super.addAll(elements);
	}
	
	public static void main(String[] args) {
		CounteringHashSet<String> set = new CounteringHashSet<String>();
		set.addAll(Arrays.asList("a", "b", "c"));
		System.out.println(set.counter);
	}
}

