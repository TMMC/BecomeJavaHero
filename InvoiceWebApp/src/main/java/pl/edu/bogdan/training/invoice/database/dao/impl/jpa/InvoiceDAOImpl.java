package pl.edu.bogdan.training.invoice.database.dao.impl.jpa;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import pl.edu.bogdan.training.invoice.database.dao.InvoiceDAO;
import pl.edu.bogdan.training.invoice.database.entities.InvoiceEntity;

@ManagedBean(name="invoiceDao")
@SessionScoped
public class InvoiceDAOImpl implements InvoiceDAO {
	@ManagedProperty(value="#{connector}")
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
			if (em.find(InvoiceEntity.class, invoice.getId()) == null) {
				em.persist(invoice);
			} else {
				em.merge(invoice);
			}
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
			InvoiceEntity entity = em.find(InvoiceEntity.class, invoice.getId());
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
