package pl.edu.bogdan.training.properties;

import java.util.Locale;
import java.util.ResourceBundle;

public class App3 {
	public static void main(String[] args) {
		ResourceBundle rb = ResourceBundle
				.getBundle("pl.edu.bogdan.training.properties.Example3", 
				new Locale("pl", "PL"),
				ResourceBundle.Control.getControl(ResourceBundle.Control.FORMAT_PROPERTIES));
		System.out.println(rb.getString("key3"));
		
//		rb = ResourceBundle.getBundle("pl.edu.bogdan.training.properties.Example3", Locale.US);
//		System.out.println(rb.getString("key1"));
	}
}
