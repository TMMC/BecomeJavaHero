package pl.edu.bogdan.training.properties;

import java.util.Locale;
import java.util.ResourceBundle;

public class App2 {
	public static void main(String[] args) {
		ResourceBundle rb = ResourceBundle.getBundle("example2");
		System.out.println(rb.getString("key1"));
		
		rb = ResourceBundle.getBundle("example2", Locale.GERMAN);
		System.out.println(rb.getString("key1"));
		
		rb = ResourceBundle.getBundle("example2", Locale.US);
		System.out.println(rb.getString("key1"));
		
		rb = ResourceBundle.getBundle("example2", Locale.FRANCE);
		System.out.println(rb.getString("key1"));
		
		Locale.setDefault(Locale.FRANCE);
		rb = ResourceBundle.getBundle("example2");
		System.out.println(rb.getString("key1"));
	}

}
