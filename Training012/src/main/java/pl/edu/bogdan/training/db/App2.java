package pl.edu.bogdan.training.db;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import pl.edu.bogdan.training.db.entity.User;

public class App2 {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pl.edu.bogdan.training.db.entity");
		EntityManager em = entityManagerFactory.createEntityManager();
		
		em.getTransaction().begin();
		
		User user = new User("Paweł", "Bogdan", 28, null);
		em.persist(user);
		em.getTransaction().commit();
		em.close();
		entityManagerFactory.close();
	}
}
