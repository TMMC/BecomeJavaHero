package pl.edu.bogdan.training.jsf.db;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;


import pl.edu.bogdan.training.jsf.db.entity.Category;

@ManagedBean(name="categoryService", eager=true)
@SessionScoped
public class JPACategoryService implements ICategoryService {
	
	@Override
	public List<Category> getAllCategories() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pl.edu.bogdan.training.db.entity");
		EntityManager em = entityManagerFactory.createEntityManager();
		
		// begining of transaction
		em.getTransaction().begin();
		Query query = em.createQuery("Select c from Category c");
		return query.getResultList();
	}

	@Override
	public Category getCategoryById(int id) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pl.edu.bogdan.training.db.entity");
		EntityManager em = entityManagerFactory.createEntityManager();
		
		// begining of transaction
		em.getTransaction().begin();
		
		return em.find(Category.class, id);
	}

}
