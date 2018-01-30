package pl.edu.bogdan.training.invoice.database.dao.impl.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import pl.edu.bogdan.training.invoice.database.dao.UserDAO;
import pl.edu.bogdan.training.invoice.database.entities.UserEntity;

public class UserDAOImpl implements UserDAO {

	private DatabaseConnector databaseConnector;

	public List<UserEntity> findAll() {
		EntityManager em = databaseConnector.createEntityManager();
		List<UserEntity> result = null;

		try {
			em.getTransaction().begin();
			TypedQuery<UserEntity> query = em.createQuery("Select a from UserEntity a", UserEntity.class);
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

	public List<UserEntity> findById(int id) {
		EntityManager em = databaseConnector.createEntityManager();
		List<UserEntity> result = null;

		try {
			em.getTransaction().begin();
			TypedQuery<UserEntity> query = em.createQuery("Select a from UserEntity a where a.id = :id",
					UserEntity.class);
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

	public void persist(UserEntity user) {
		EntityManager em = databaseConnector.createEntityManager();

		try {
			em.getTransaction().begin();
			em.persist(user);
			em.getTransaction().commit();
		} finally {
			if (em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
			em.close();
		}
	}

	public void delete(UserEntity user) {
		EntityManager em = databaseConnector.createEntityManager();

		try {
			em.getTransaction().begin();
			em.remove(user);
			em.getTransaction().commit();
		} finally {
			if (em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
			em.close();
		}
	}

	public void setDatabaseConnector(DatabaseConnector databaseConnector) {
		this.databaseConnector = databaseConnector;
	}

}
