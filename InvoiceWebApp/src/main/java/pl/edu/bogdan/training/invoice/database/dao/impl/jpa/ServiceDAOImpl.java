package pl.edu.bogdan.training.invoice.database.dao.impl.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import pl.edu.bogdan.training.invoice.database.dao.ServiceDAO;
import pl.edu.bogdan.training.invoice.database.entities.ServiceEntity;

public class ServiceDAOImpl implements ServiceDAO {

	private DatabaseConnector databaseConnector;

	public List<ServiceEntity> findAll() {
		EntityManager em = databaseConnector.createEntityManager();
		List<ServiceEntity> result = null;

		try {
			em.getTransaction().begin();
			TypedQuery<ServiceEntity> query = em.createQuery("Select a from ServiceEntity a", ServiceEntity.class);
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

	public List<ServiceEntity> findById(int id) {
		EntityManager em = databaseConnector.createEntityManager();
		List<ServiceEntity> result = null;

		try {
			em.getTransaction().begin();
			TypedQuery<ServiceEntity> query = em.createQuery("Select a from ServiceEntity a where a.id = :id",
					ServiceEntity.class);
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

	public void persist(ServiceEntity service) {
		EntityManager em = databaseConnector.createEntityManager();

		try {
			em.getTransaction().begin();
			em.persist(service);
			em.getTransaction().commit();
		} finally {
			if (em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
			em.close();
		}
	}

	public void delete(ServiceEntity service) {
		EntityManager em = databaseConnector.createEntityManager();

		try {
			em.getTransaction().begin();
			em.remove(service);
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
