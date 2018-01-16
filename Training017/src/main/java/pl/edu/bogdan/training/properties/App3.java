package pl.edu.bogdan.training.properties;

import java.util.Locale;
import java.util.ResourceBundle;

public class App3 {
	public static void main(String[] args) {
		ResourceBundle rb = ResourceBundle.getBundle("pl.edu.bogdan.training.properties.Example3");
		System.out.println(rb.getString("key1"));
		
		rb = ResourceBundle.getBundle("pl.edu.bogdan.training.properties.Example3", Locale.US);
		System.out.println(rb.getString("key1"));
	}
}
