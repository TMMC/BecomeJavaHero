package pl.edu.bogdan.training.prime.faces.db.dao;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import pl.edu.bogdan.training.prime.faces.db.DatabaseConnection;
import pl.edu.bogdan.training.prime.faces.db.entities.AuthorEntity;

@ManagedBean(name="authorDAO", eager=true)
@SessionScoped
public class AuthorDAOImpl implements AuthorDAO {

	@ManagedProperty(value="#{databaseConnection}")
	private DatabaseConnection connection;
	
	public List<AuthorEntity> findAll() {
		EntityManager em = connection.createEntityManager();
		List<AuthorEntity> result;
		
		try {
			em.getTransaction().begin();
			TypedQuery<AuthorEntity> query = em.createQuery("Select a from AuthorEntity a", AuthorEntity.class);
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

	public List<AuthorEntity> findById(int id) {
		EntityManager em = connection.createEntityManager();
		List<AuthorEntity> result;
		
		try {
			em.getTransaction().begin();
			TypedQuery<AuthorEntity> query = em.createQuery("Select a from AuthorEntity a where a.id = :id", AuthorEntity.class);
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
