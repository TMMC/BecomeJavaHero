package pl.edu.bogdan.training.invoice.database.dao.impl.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestingDatabaseConnector implements DatabaseConnector {
	private final EntityManagerFactory testingFactory = Persistence.createEntityManagerFactory("testing");

	public EntityManager createEntityManager() {
		return testingFactory.createEntityManager();
	}

	@Override
	public void close() {
		testingFactory.close();
	}
}
