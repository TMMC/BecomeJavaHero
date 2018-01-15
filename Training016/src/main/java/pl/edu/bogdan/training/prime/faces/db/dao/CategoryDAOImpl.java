package pl.edu.bogdan.training.prime.faces.db.dao;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;


import pl.edu.bogdan.training.prime.faces.db.DatabaseConnection;
import pl.edu.bogdan.training.prime.faces.db.entities.CategoryEntity;

@ManagedBean(name="categoryDAO", eager=true)
@SessionScoped
public class CategoryDAOImpl implements CategoryDAO {

	@ManagedProperty(value="#{databaseConnection}")
	private DatabaseConnection connection;
	
	public List<CategoryEntity> findAll() {
		EntityManager em = connection.createEntityManager();
		List<CategoryEntity> result;
		
		try {
			em.getTransaction().begin();
			TypedQuery<CategoryEntity> query = em.createQuery("Select c from CategoryEntity c", CategoryEntity.class);
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

	public List<CategoryEntity> findById(int id) {
		EntityManager em = connection.createEntityManager();
		List<CategoryEntity> result;
		
		try {
			em.getTransaction().begin();
			TypedQuery<CategoryEntity> query = em.createQuery("Select c from CategoryEntity c where c.id = :id", CategoryEntity.class);
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
