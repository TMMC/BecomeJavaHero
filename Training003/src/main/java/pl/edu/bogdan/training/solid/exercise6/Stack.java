package pl.edu.bogdan.training.solid.exercise6;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Stack<E> {
	List<E> elements = new ArrayList<E>();
	
	public void add(E e) {
		elements.add(e);
	}
	
	public void addAll(Iterable<? extends E> list) {
		for (E e : list) {
			add(e);
		}
	}
	
	public E pop() {
		E e = elements.get(elements.size() - 1);
		elements.remove(e);
		return e;
	}
	
	public void popAll(Collection<? super E> list) {
		while (elements.size() > 0) {
			list.add(pop());
		}
	}
}
