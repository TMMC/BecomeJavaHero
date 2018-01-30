package pl.edu.bogdan.training.invoice.database.dao.impl.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import pl.edu.bogdan.training.invoice.database.dao.PositionDAO;
import pl.edu.bogdan.training.invoice.database.entities.PositionEntity;

public class PositionDAOImpl implements PositionDAO {

	private DatabaseConnector databaseConnector;

	public List<PositionEntity> findAll() {
		EntityManager em = databaseConnector.createEntityManager();
		List<PositionEntity> result = null;

		try {
			em.getTransaction().begin();
			TypedQuery<PositionEntity> query = em.createQuery("Select a from PositionEntity a", PositionEntity.class);
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

	public List<PositionEntity> findById(int id) {
		EntityManager em = databaseConnector.createEntityManager();
		List<PositionEntity> result = null;

		try {
			em.getTransaction().begin();
			TypedQuery<PositionEntity> query = em.createQuery("Select a from PositionEntity a where a.id = :id",
					PositionEntity.class);
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

	public void persist(PositionEntity position) {
		EntityManager em = databaseConnector.createEntityManager();

		try {
			em.getTransaction().begin();
			em.persist(position);
			em.getTransaction().commit();
		} finally {
			if (em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
			em.close();
		}
	}

	public void delete(PositionEntity position) {
		EntityManager em = databaseConnector.createEntityManager();

		try {
			em.getTransaction().begin();
			em.remove(position);
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
