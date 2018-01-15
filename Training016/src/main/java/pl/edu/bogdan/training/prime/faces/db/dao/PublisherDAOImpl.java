package pl.edu.bogdan.training.prime.faces.db.dao;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import pl.edu.bogdan.training.prime.faces.db.DatabaseConnection;
import pl.edu.bogdan.training.prime.faces.db.entities.PublisherEntity;

@ManagedBean(name="publisherDAO", eager=true)
@SessionScoped
public class PublisherDAOImpl implements PublisherDAO {

	@ManagedProperty(value="#{databaseConnection}")
	private DatabaseConnection connection;
	
	public List<PublisherEntity> findAll() {
		EntityManager em = connection.createEntityManager();
		List<PublisherEntity> result;
		
		try {
			em.getTransaction().begin();
			TypedQuery<PublisherEntity> query = em.createQuery("Select p from PublisherEntity p", PublisherEntity.class);
			result = query.getResultList();
			em.getTransaction().commit();
		} finally {
			if (em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
			em.close();
		}
		
		return result;
	}

	public List<PublisherEntity> findById(int id) {
		EntityManager em = connection.createEntityManager();
		List<PublisherEntity> result;
		
		try {
			em.getTransaction().begin();
			TypedQuery<PublisherEntity> query = em.createQuery("Select p from PublisherEntity p where p.id = :id", PublisherEntity.class);
			query.setParameter("id", id);
			result = query.getResultList();
			em.getTransaction().commit();
		} finally {
			if (em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
			em.close();
		}
		
		return result;
	}

	public void setConnection(DatabaseConnection connection) {
		this.connection = connection;
	}
	
}
