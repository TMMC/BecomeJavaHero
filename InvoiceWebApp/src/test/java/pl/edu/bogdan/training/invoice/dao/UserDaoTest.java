package pl.edu.bogdan.training.invoice.dao;

import static org.junit.Assert.*;

import java.util.List;

import javax.persistence.PersistenceException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import pl.edu.bogdan.training.invoice.database.dao.impl.jpa.DatabaseConnector;
import pl.edu.bogdan.training.invoice.database.dao.impl.jpa.TestingDatabaseConnector;
import pl.edu.bogdan.training.invoice.database.dao.impl.jpa.UserDAOImpl;
import pl.edu.bogdan.training.invoice.database.dao.impl.jpa.UserTypeDAOImpl;
import pl.edu.bogdan.training.invoice.database.entities.UserEntity;
import pl.edu.bogdan.training.invoice.database.entities.UserTypeEntity;

public class UserDaoTest {
	private DatabaseConnector databaseConnector;
	private UserDAOImpl userDao;
	private UserTypeDAOImpl userTypeDao;
	
	@Before
	public void setup() {
		this.databaseConnector = new TestingDatabaseConnector();
		this.userDao = new UserDAOImpl();
		userDao.setDatabaseConnector(databaseConnector);
		this.userTypeDao = new UserTypeDAOImpl();
		userTypeDao.setDatabaseConnector(databaseConnector);
	}
	
	@After
	public void clean() {
		databaseConnector.close();
	}
	
	@Test
	public void simpleInsertingTest() {
		UserTypeEntity type = new UserTypeEntity();
		type.setName("ORDINARY");
		userTypeDao.persist(type);
		UserEntity user = new UserEntity();
		user.setUsername("pawel");
		user.setUserType(type);
		userDao.persist(user);
		List<UserTypeEntity> types = userTypeDao.findAll();
		List<UserEntity> users = userDao.findAll();
		assertEquals(1, types.size());
		assertEquals(1, users.size());
	}
	
	@Test(expected=PersistenceException.class)
	public void simpleInsertingWithoutTypeTest() {
		UserEntity user = new UserEntity();
		user.setUsername("pawel");
		userDao.persist(user);
		List<UserTypeEntity> types = userTypeDao.findAll();
		List<UserEntity> users = userDao.findAll();
		assertEquals(0, types.size());
		assertEquals(1, users.size());
	}
	
	@Test
	public void simpleRemovingTest() {
		UserTypeEntity type = new UserTypeEntity();
		type.setName("ORDINARY");
		userTypeDao.persist(type);
		UserEntity user = new UserEntity();
		user.setUsername("pawel");
		user.setUserType(type);
		userDao.persist(user);
		userDao.delete(user);
		List<UserTypeEntity> types = userTypeDao.findAll();
		List<UserEntity> users = userDao.findAll();
		assertEquals(1, types.size());
		assertEquals(0, users.size());
	}
	
	@Test
	public void simpleUpdatingTest() {
		UserTypeEntity type = new UserTypeEntity();
		type.setName("ORDINARY");
		userTypeDao.persist(type);
		UserEntity user = new UserEntity();
		user.setUsername("pawel");
		user.setUserType(type);
		userDao.persist(user);
		user.setName("bogdan");
		userDao.persist(user);
		List<UserTypeEntity> types = userTypeDao.findAll();
		List<UserEntity> users = userDao.findAll();
		assertEquals(1, types.size());
		assertEquals(1, users.size());
	}
	
	@Test
	public void updatingTypeTest() {
		UserTypeEntity type1 = new UserTypeEntity();
		type1.setName("ORDINARY");
		userTypeDao.persist(type1);
		
		UserTypeEntity type2 = new UserTypeEntity();
		type2.setName("SUPER");
		userTypeDao.persist(type2);
		
		UserEntity user = new UserEntity();
		user.setUsername("pawel");
		user.setUserType(type1);
		userDao.persist(user);
		
		List<UserTypeEntity> types = userTypeDao.findAll();
		List<UserEntity> users = userDao.findAll();
		assertEquals(2, types.size());
		assertEquals(1, users.size());
		assertEquals(type1, users.get(0).getUserType());
		
		user.setUserType(type2);
		userDao.persist(user);
		
		types = userTypeDao.findAll();
		users = userDao.findAll();
		assertEquals(2, types.size());
		assertEquals(1, users.size());
		assertEquals(type2, users.get(0).getUserType());
	}
}
