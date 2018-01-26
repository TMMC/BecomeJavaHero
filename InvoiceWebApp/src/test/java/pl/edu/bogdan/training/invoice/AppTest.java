package pl.edu.bogdan.training.invoice;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;

public class AppTest {
	@Test
	public void simpleTest() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("invoice");
		
	}
}
