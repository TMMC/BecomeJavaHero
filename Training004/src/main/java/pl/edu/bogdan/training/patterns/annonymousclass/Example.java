package pl.edu.bogdan.training.patterns.annonymousclass;

import java.util.Comparator;

class StringComparator implements Comparator<String> {

	@Override
	public int compare(String o1, String o2) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}

public class Example {
	public static void main(String [] args) {
		Comparator<String> c1 = new StringComparator();
		if (c1.compare("pawel", "bogdan") > 0) {
			
		}
		
		Comparator<String> c2 = new Comparator<String>() {
			public void foo() {
				
			}
			@Override
			public int compare(String o1, String o2) {
				foo();
				return 0;
			}
		};
	}
}
