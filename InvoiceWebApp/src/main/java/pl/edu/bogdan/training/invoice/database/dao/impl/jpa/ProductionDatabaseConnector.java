package pl.edu.bogdan.training.invoice.database.dao.impl.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ProductionDatabaseConnector implements DatabaseConnector {
	private final EntityManagerFactory productionFactory = Persistence.createEntityManagerFactory("production");
	
	public EntityManager createEntityManager() {
		return productionFactory.createEntityManager();
	}
}
