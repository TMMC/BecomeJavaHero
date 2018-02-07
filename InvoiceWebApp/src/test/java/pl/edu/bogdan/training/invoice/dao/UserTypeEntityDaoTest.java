package pl.edu.bogdan.training.invoice.dao;

import static org.junit.Assert.*;

import java.util.List;

import javax.persistence.RollbackException;

import org.junit.Before;
import org.junit.Test;

import pl.edu.bogdan.training.invoice.database.dao.impl.jpa.DatabaseConnector;
import pl.edu.bogdan.training.invoice.database.dao.impl.jpa.TestingDatabaseConnector;
import pl.edu.bogdan.training.invoice.database.dao.impl.jpa.UserTypeDAOImpl;
import pl.edu.bogdan.training.invoice.database.entities.UserTypeEntity;

public class UserTypeEntityDaoTest {
	private DatabaseConnector databaseConnector;
	private UserTypeDAOImpl userTypeDao;
	@Before
	public void setup() {
		this.databaseConnector = new TestingDatabaseConnector();
		this.userTypeDao = new UserTypeDAOImpl();
		userTypeDao.setDatabaseConnector(databaseConnector);
	}
	
	@Test
	public void simpleInsertingTest() {
		UserTypeEntity type = new UserTypeEntity();
		type.setName("ORDINARY");
		userTypeDao.persist(type);
		List<UserTypeEntity> entities = userTypeDao.findAll();
		assertEquals(1, entities.size());
		assertEquals(type, entities.get(0));
	}
	
	@Test
	public void simpleInserting2Test() {
		UserTypeEntity type = new UserTypeEntity();
		type.setName("ORDINARY");
		userTypeDao.persist(type);
		
		type = new UserTypeEntity();
		type.setName("ADMIN");
		userTypeDao.persist(type);
		
		List<UserTypeEntity> entities = userTypeDao.findAll();
		assertEquals(2, entities.size());
	}
	
	@Test(expected=RollbackException.class)
	public void insertingTwoSameRolesTest() {
		UserTypeEntity type = new UserTypeEntity();
		type.setName("ORDINARY");
		userTypeDao.persist(type);
		
		type = new UserTypeEntity();
		type.setName("ORDINARY");
		userTypeDao.persist(type);
	}
	
	@Test
	public void updatingInsertedTest() {
		UserTypeEntity type = new UserTypeEntity();
		type.setName("ORDINARY");
		userTypeDao.persist(type);
		int id = type.getId();
		type.setName("CHANGED");
		userTypeDao.persist(type);
		List<UserTypeEntity> entities = userTypeDao.findById(id);
		assertEquals(1, entities.size());
		assertEquals("CHANGED", entities.get(0).getName());
	}
	
	@Test
	public void removingTest() {
		UserTypeEntity type = new UserTypeEntity();
		type.setName("ORDINARY");
		userTypeDao.persist(type);
		userTypeDao.delete(type);
		List<UserTypeEntity> entities = userTypeDao.findAll();
		assertEquals(0, entities.size());
	}
	
	@Test
	public void searchUnexistingType() {
		List<UserTypeEntity> entities = userTypeDao.findById(1111);
		assertEquals(0, entities.size());
		entities = userTypeDao.findAll();
		assertEquals(0, entities.size());
	}
	
}
