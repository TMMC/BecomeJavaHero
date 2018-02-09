package pl.edu.bogdan.training.invoice.database.dao.impl.jpa;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import pl.edu.bogdan.training.invoice.database.dao.UserDAO;
import pl.edu.bogdan.training.invoice.database.entities.UserEntity;

@ManagedBean(name="userDao")
@SessionScoped
public class UserDAOImpl implements UserDAO {

	@ManagedProperty(value="#{connector}")
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
			if (em.find(UserEntity.class, user.getId()) == null) {
				em.persist(user);
			} else {
				em.merge(user);
			}
			
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
			UserEntity entity = em.find(UserEntity.class, user.getId());
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

	@Override
	public List<UserEntity> findByUsername(String username) {
		EntityManager em = databaseConnector.createEntityManager();
		List<UserEntity> result = null;

		try {
			em.getTransaction().begin();
			TypedQuery<UserEntity> query = em.createQuery("Select distinct a from UserEntity a join fetch a.boughtInvoices inv where a.username = :username",
					UserEntity.class);
			query.setParameter("username", username);
			result = query.getResultList();
			System.out.println("ILOŚĆ REKORDÓW: " + result.size());
			for (UserEntity u : result) {
				System.out.println(u);
			}
//			for (UserEntity e : result) {
//				e.getBoughtInvoices().size();
//			}
			em.getTransaction().commit();
		} finally {
			if (em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
			em.close();
		}
		return result;
	}

}
