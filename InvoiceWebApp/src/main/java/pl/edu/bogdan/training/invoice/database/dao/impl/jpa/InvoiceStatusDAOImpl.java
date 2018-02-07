package pl.edu.bogdan.training.invoice.database.dao.impl.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import pl.edu.bogdan.training.invoice.database.dao.InvoiceStatusDAO;
import pl.edu.bogdan.training.invoice.database.entities.InvoiceStatusEntity;

public class InvoiceStatusDAOImpl implements InvoiceStatusDAO {

	private DatabaseConnector databaseConnector;

	public List<InvoiceStatusEntity> findAll() {
		EntityManager em = databaseConnector.createEntityManager();
		List<InvoiceStatusEntity> result = null;

		try {
			em.getTransaction().begin();
			TypedQuery<InvoiceStatusEntity> query = em.createQuery("Select a from InvoiceStatusEntity a",
					InvoiceStatusEntity.class);
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

	public List<InvoiceStatusEntity> findById(int id) {
		EntityManager em = databaseConnector.createEntityManager();
		List<InvoiceStatusEntity> result = null;

		try {
			em.getTransaction().begin();
			TypedQuery<InvoiceStatusEntity> query = em
					.createQuery("Select a from InvoiceStatusEntity a where a.id = :id", InvoiceStatusEntity.class);
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

	public void persist(InvoiceStatusEntity invoiceStatus) {
		EntityManager em = databaseConnector.createEntityManager();

		try {
			em.getTransaction().begin();
			if (em.find(InvoiceStatusEntity.class, invoiceStatus.getId()) == null) { 
				em.persist(invoiceStatus);
			} else {
				em.merge(invoiceStatus);
			}
			em.getTransaction().commit();
		} finally {
			if (em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
			em.close();
		}
	}

	public void delete(InvoiceStatusEntity invoiceStatus) {
		EntityManager em = databaseConnector.createEntityManager();

		try {
			em.getTransaction().begin();
			InvoiceStatusEntity entity = em.find(InvoiceStatusEntity.class, invoiceStatus.getId());
			if (entity != null) {
				em.remove(entity);
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
