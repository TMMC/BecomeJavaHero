package pl.edu.bogdan.training.jsf.db;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import pl.edu.bogdan.training.jsf.db.entity.Category;
import pl.edu.bogdan.training.jsf.db.entity.Publisher;

@ManagedBean(name="publisherService", eager=true)
@SessionScoped
public class JPAPublisherService implements IPublisherService {

	@Override
	public List<Publisher> getAllPublishers() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pl.edu.bogdan.training.db.entity");
		EntityManager em = entityManagerFactory.createEntityManager();
		
		// begining of transaction
		em.getTransaction().begin();
		Query query = em.createQuery("Select p from Publisher p");
		return query.getResultList();
	}

	@Override
	public Publisher getPublisherById(int id) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pl.edu.bogdan.training.db.entity");
		EntityManager em = entityManagerFactory.createEntityManager();
		
		// begining of transaction
		em.getTransaction().begin();
		
		return em.find(Publisher.class, id);
	}
	
	

}
