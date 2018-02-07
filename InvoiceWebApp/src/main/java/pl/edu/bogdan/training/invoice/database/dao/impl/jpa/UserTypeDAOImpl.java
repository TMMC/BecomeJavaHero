package pl.edu.bogdan.training.invoice.database.dao.impl.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import pl.edu.bogdan.training.invoice.database.entities.UserTypeEntity;

public class UserTypeDAOImpl implements pl.edu.bogdan.training.invoice.database.dao.UserTypeDAO {

	private DatabaseConnector databaseConnector;

	public List<UserTypeEntity> findAll() {
		EntityManager em = databaseConnector.createEntityManager();
		List<UserTypeEntity> result = null;

		try {
			em.getTransaction().begin();
			TypedQuery<UserTypeEntity> query = em.createQuery("Select a from UserTypeEntity a", UserTypeEntity.class);
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

	public List<UserTypeEntity> findById(int id) {
		EntityManager em = databaseConnector.createEntityManager();
		List<UserTypeEntity> result = null;

		try {
			em.getTransaction().begin();
			TypedQuery<UserTypeEntity> query = em.createQuery("Select a from UserTypeEntity a where a.id = :id",
					UserTypeEntity.class);
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
	
	public List<UserTypeEntity> findFetchedById(int id) {
		EntityManager em = databaseConnector.createEntityManager();
		List<UserTypeEntity> result = null;

		try {
			em.getTransaction().begin();
			TypedQuery<UserTypeEntity> query = em.createQuery("Select a from UserTypeEntity a join fetch a.users where a.id = :id",
					UserTypeEntity.class);
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

	public void persist(UserTypeEntity userType) {
		EntityManager em = databaseConnector.createEntityManager();

		try {
			em.getTransaction().begin();
			if (em.find(UserTypeEntity.class, userType.getId()) == null) {
				em.persist(userType);
			} else {
				em.merge(userType);
			}
			
			em.getTransaction().commit();
		} finally {
			if (em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
			em.close();
		}
	}

	public void delete(UserTypeEntity userType) {
		EntityManager em = databaseConnector.createEntityManager();

		try {
			em.getTransaction().begin();
			UserTypeEntity type = em.find(UserTypeEntity.class, userType.getId());
			if (type != null) {
				em.remove(type);
			}
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
