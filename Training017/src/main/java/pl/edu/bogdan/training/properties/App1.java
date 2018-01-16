package pl.edu.bogdan.training.properties;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class App1 {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		Properties p1 = new Properties();
		p1.load(new FileInputStream("src/main/resources/example1.properties"));
		System.out.println(p1.getProperty("property1", "default value"));
		System.out.println(p1.getProperty("property2", "default value"));
		System.out.println(p1.getProperty("property3", "default value"));
		System.out.println(p1.getProperty("property3"));
	}
}
