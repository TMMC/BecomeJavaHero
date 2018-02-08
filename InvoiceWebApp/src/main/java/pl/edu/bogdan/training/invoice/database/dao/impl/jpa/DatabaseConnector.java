package pl.edu.bogdan.training.invoice.database.dao.impl.jpa;

import javax.persistence.EntityManager;

public interface DatabaseConnector {
	EntityManager createEntityManager();
	void close();
}
