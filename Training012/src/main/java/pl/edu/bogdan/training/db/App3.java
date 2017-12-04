package pl.edu.bogdan.training.db;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import pl.edu.bogdan.training.db.entity.Role;
import pl.edu.bogdan.training.db.entity.User;

public class App3 {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pl.edu.bogdan.training.db.entity");
		EntityManager em = entityManagerFactory.createEntityManager();
		
		em.getTransaction().begin();
		
		Role r1 = new Role("ordinary");
		Role r2 = new Role("super");
		em.persist(r1);
		em.persist(r2);
		
		User user = new User("Paweł", "Bogdan", 28, r1);
		em.persist(user);
		
		user = new User("Adam", "Mickiewicz", 44, r2);
		em.persist(user);
		
		user = new User("Juliusz", "Słowacki", 33, r1);
		em.persist(user);
		
		user = new User("Jan", "Kowalski", 55, r2);
		em.persist(user);
		
		em.getTransaction().commit();
		em.close();
		entityManagerFactory.close();
	}
}
