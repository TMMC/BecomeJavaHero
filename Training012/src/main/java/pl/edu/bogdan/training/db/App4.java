package pl.edu.bogdan.training.db;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import pl.edu.bogdan.training.db.entity.Role;

public class App4 {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pl.edu.bogdan.training.db.entity");
		EntityManager em = entityManagerFactory.createEntityManager();
		
		// begining of transaction
		em.getTransaction().begin();
		
		// Creating query in the way very similar to SQL
		Query query = em.createQuery("Select r from Role r");
		
		// We obtaining result as a list of entities
		List<Role> roles = query.getResultList();
		
		for (Role role : roles) {
			System.out.println(role.getName());
		}
		
		em.getTransaction().commit();
		em.close();
		entityManagerFactory.close();
	}
}
