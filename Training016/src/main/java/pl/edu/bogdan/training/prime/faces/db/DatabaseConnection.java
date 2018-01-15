package pl.edu.bogdan.training.prime.faces.db;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@ManagedBean(name="databaseConnection", eager=true)
@ApplicationScoped
public class DatabaseConnection {
	private final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pl.edu.bogdan.training.db.entity");
	
	public EntityManager createEntityManager() {
		return entityManagerFactory.createEntityManager();
	}
}
