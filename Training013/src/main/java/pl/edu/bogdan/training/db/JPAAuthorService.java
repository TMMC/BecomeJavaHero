package pl.edu.bogdan.training.db;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Service;

import pl.edu.bogdan.training.db.entity.Author;

@Service
public class JPAAuthorService implements IAuthorService {

	public List<Author> getAllAuthors() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pl.edu.bogdan.training.db.entity");
		EntityManager em = entityManagerFactory.createEntityManager();
		
		// begining of transaction
		em.getTransaction().begin();
		Query query = em.createQuery("Select a from Author a");
		return query.getResultList();
	}

	@Override
	public void addAuthor(Author author) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pl.edu.bogdan.training.db.entity");
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
//		Query query = em.createQuery("SELECT Max(a.id) FROM Author a");
//		Integer i = (Integer) query.getSingleResult();
//		author.setId(i+1);
		em.persist(author);
		em.getTransaction().commit();
	}

}
