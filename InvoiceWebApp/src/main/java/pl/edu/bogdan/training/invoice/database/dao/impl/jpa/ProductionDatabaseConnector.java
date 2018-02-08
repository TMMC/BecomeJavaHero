package pl.edu.bogdan.training.invoice.database.dao.impl.jpa;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@ManagedBean(name="connector")
@ApplicationScoped
public class ProductionDatabaseConnector implements DatabaseConnector {
	private final EntityManagerFactory productionFactory = Persistence.createEntityManagerFactory("production");
	
	public EntityManager createEntityManager() {
		return productionFactory.createEntityManager();
	}

	@Override
	public void close() {
		productionFactory.close();
	}
}
