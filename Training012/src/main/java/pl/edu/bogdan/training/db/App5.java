package pl.edu.bogdan.training.db;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import pl.edu.bogdan.training.db.entity.Role;

public class App5 {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence
				.createEntityManagerFactory("pl.edu.bogdan.training.db.entity");
		EntityManager em = entityManagerFactory.createEntityManager();

		// begining of transaction
		em.getTransaction().begin();

		// Object used to create more sophisticated conditions
		CriteriaBuilder cb = em.getCriteriaBuilder();
		
		// this object is used to create query object
		CriteriaQuery<Role> cq = cb.createQuery(Role.class);
		
		// We set the root of query (we will use this root to getting values of columns)
		Root<Role> from = cq.from(Role.class);
		
		// we composing query using cb object
		cq.where(cb.equal(from.get("name"), "ordinary"));
		
		// creating query and executing it
		TypedQuery<Role> tq = em.createQuery(cq);
		List<Role> roles = tq.getResultList();
		
		
		for (Role role : roles) {
			System.out.println(role.getName());
		}

		em.getTransaction().commit();
		em.close();
		entityManagerFactory.close();
	}
}
