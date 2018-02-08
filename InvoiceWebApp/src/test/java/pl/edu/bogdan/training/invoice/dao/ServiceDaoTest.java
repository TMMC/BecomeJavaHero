package pl.edu.bogdan.training.invoice.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import pl.edu.bogdan.training.invoice.database.dao.impl.jpa.DatabaseConnector;
import pl.edu.bogdan.training.invoice.database.dao.impl.jpa.ServiceDAOImpl;
import pl.edu.bogdan.training.invoice.database.dao.impl.jpa.TestingDatabaseConnector;
import pl.edu.bogdan.training.invoice.database.entities.ServiceEntity;

public class ServiceDaoTest {
	private DatabaseConnector databaseConnector;
	private ServiceDAOImpl serviceDao;
	
	@Before
	public void setup() {
		this.databaseConnector = new TestingDatabaseConnector();
		serviceDao = new ServiceDAOImpl();
		serviceDao.setDatabaseConnector(databaseConnector);
	}
	
	@After
	public void clean() {
		databaseConnector.close();
	}
	
	@Test
	public void simpleInsertingTest() {
		ServiceEntity service = new ServiceEntity();
		service.setName("serwis");
		
		serviceDao.persist(service);
		
		List<ServiceEntity> entities = serviceDao.findAll();
		assertEquals(1, entities.size());
		assertEquals(service, entities.get(0));
		
		entities = serviceDao.findById(service.getId());
		assertEquals(1, entities.size());
		assertEquals(service, entities.get(0));
	}
	
	@Test
	public void simpleUpdatingTest() {
		ServiceEntity service = new ServiceEntity();
		service.setName("serwis");
		
		serviceDao.persist(service);
		
		List<ServiceEntity> entities = serviceDao.findAll();
		assertEquals(1, entities.size());
		assertEquals(service, entities.get(0));
		
		service.setName("usługa");
		serviceDao.persist(service);
		
		entities = serviceDao.findById(service.getId());
		assertEquals(1, entities.size());
		assertEquals(service, entities.get(0));
	}
	
	@Test
	public void simpleRemovingTest() {
		ServiceEntity service = new ServiceEntity();
		service.setName("serwis");
		
		serviceDao.persist(service);
		
		List<ServiceEntity> entities = serviceDao.findAll();
		assertEquals(1, entities.size());
		assertEquals(service, entities.get(0));
		
		serviceDao.delete(service);
		entities = serviceDao.findAll();
		assertEquals(0, entities.size());
	}
}
