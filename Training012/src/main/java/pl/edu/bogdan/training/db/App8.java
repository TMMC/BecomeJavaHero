package pl.edu.bogdan.training.db;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;

import pl.edu.bogdan.training.db.entity.Role;
import pl.edu.bogdan.training.db.entity.User;

public class App8 {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence
				.createEntityManagerFactory("pl.edu.bogdan.training.db.entity");
		EntityManager em = entityManagerFactory.createEntityManager();

		em.getTransaction().begin();
		
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<User> cq = cb.createQuery(User.class);
		Root<User> from = cq.from(User.class);
		Join<User, Role> join = from.join("role", JoinType.LEFT);
		cq.where(cb.equal(join.get("name"), "ordinary"));
		TypedQuery<User> tq = em.createQuery(cq);
		List<User> users = tq.getResultList();
		for (User u : users) {
			System.out.println(u.getLastName());
		}
		
		em.getTransaction().commit();
		em.close();
		entityManagerFactory.close();
	}

}
