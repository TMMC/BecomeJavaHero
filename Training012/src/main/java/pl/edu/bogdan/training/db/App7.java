package pl.edu.bogdan.training.db;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import pl.edu.bogdan.training.db.entity.Role;
import pl.edu.bogdan.training.db.entity.User;

public class App7 {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pl.edu.bogdan.training.db.entity");
		EntityManager em = entityManagerFactory.createEntityManager();
		
		em.getTransaction().begin();
		
		Query query = em
				.createQuery("Select user from User user join user.role role where role.name = :name");
		query.setParameter("name", "ordinary");
		List<User> users = query.getResultList();
		
		for (User user : users) {
			System.out.println(user.getFirstName() + "   " + user.getRole().getName());
		}
		
		em.getTransaction().commit();
		em.close();
		entityManagerFactory.close();
	}

}
