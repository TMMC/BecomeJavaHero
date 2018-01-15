package pl.edu.bogdan.training.prime.faces.db.dao;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import pl.edu.bogdan.training.prime.faces.db.DatabaseConnection;
import pl.edu.bogdan.training.prime.faces.db.entities.BookEntity;

@ManagedBean(name="bookDAO", eager=true)
@SessionScoped
public class BookDAOImpl implements BookDAO {

	@ManagedProperty(value="#{databaseConnection}")
	private DatabaseConnection connection;
	
	public List<BookEntity> findAll() {
		EntityManager em = connection.createEntityManager();
		List<BookEntity> result;
		
		try {
			em.getTransaction().begin();
			TypedQuery<BookEntity> query = em.createQuery("Select b from BookEntity b", BookEntity.class);
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

	public List<BookEntity> findById(int id) {
		EntityManager em = connection.createEntityManager();
		List<BookEntity> result;
		
		try {
			em.getTransaction().begin();
			TypedQuery<BookEntity> query = em.createQuery("Select b from BookEntity b where b.id = :id", BookEntity.class);
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
