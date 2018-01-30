package pl.edu.bogdan.training.invoice.database.dao.impl.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import pl.edu.bogdan.training.invoice.database.dao.InvoiceDAO;
import pl.edu.bogdan.training.invoice.database.entities.InvoiceEntity;

public class InvoiceDAOImpl implements InvoiceDAO {

	private DatabaseConnector databaseConnector;

	public List<InvoiceEntity> findAll() {
		EntityManager em = databaseConnector.createEntityManager();
		List<InvoiceEntity> result = null;

		try {
			em.getTransaction().begin();
			TypedQuery<InvoiceEntity> query = em.createQuery("Select a from InvoiceEntity a", InvoiceEntity.class);
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

	public List<InvoiceEntity> findById(int id) {
		EntityManager em = databaseConnector.createEntityManager();
		List<InvoiceEntity> result = null;

		try {
			em.getTransaction().begin();
			TypedQuery<InvoiceEntity> query = em.createQuery("Select a from InvoiceEntity a join fetch a.positions where a.id = :id",
					InvoiceEntity.class);
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

	public void persist(InvoiceEntity invoice) {
		EntityManager em = databaseConnector.createEntityManager();

		try {
			em.getTransaction().begin();
			em.persist(invoice);
			em.getTransaction().commit();
		} finally {
			if (em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
			em.close();
		}
	}

	public void delete(InvoiceEntity invoice) {
		EntityManager em = databaseConnector.createEntityManager();

		try {
			em.getTransaction().begin();
			em.remove(invoice);
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
