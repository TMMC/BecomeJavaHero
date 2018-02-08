package pl.edu.bogdan.training.invoice.dao;

import static org.junit.Assert.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.PersistenceException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import pl.edu.bogdan.training.invoice.database.dao.impl.jpa.DatabaseConnector;
import pl.edu.bogdan.training.invoice.database.dao.impl.jpa.InvoiceDAOImpl;
import pl.edu.bogdan.training.invoice.database.dao.impl.jpa.InvoiceStatusDAOImpl;
import pl.edu.bogdan.training.invoice.database.dao.impl.jpa.PositionDAOImpl;
import pl.edu.bogdan.training.invoice.database.dao.impl.jpa.ServiceDAOImpl;
import pl.edu.bogdan.training.invoice.database.dao.impl.jpa.TestingDatabaseConnector;
import pl.edu.bogdan.training.invoice.database.dao.impl.jpa.UserDAOImpl;
import pl.edu.bogdan.training.invoice.database.dao.impl.jpa.UserTypeDAOImpl;
import pl.edu.bogdan.training.invoice.database.entities.InvoiceEntity;
import pl.edu.bogdan.training.invoice.database.entities.InvoiceStatusEntity;
import pl.edu.bogdan.training.invoice.database.entities.PositionEntity;
import pl.edu.bogdan.training.invoice.database.entities.ServiceEntity;
import pl.edu.bogdan.training.invoice.database.entities.UserEntity;
import pl.edu.bogdan.training.invoice.database.entities.UserTypeEntity;

public class InvoiceDaoTest {
	private DatabaseConnector databaseConnector;
	private PositionDAOImpl positionDao;
	private ServiceDAOImpl serviceDao;
	private InvoiceStatusDAOImpl invoiceStatusDao;
	private InvoiceDAOImpl invoiceDao;
	private UserDAOImpl userDao;
	private UserTypeDAOImpl userTypeDao;
	
	@Before
	public void setup() {
		this.databaseConnector = new TestingDatabaseConnector();
		serviceDao = new ServiceDAOImpl();
		serviceDao.setDatabaseConnector(databaseConnector);
		positionDao = new PositionDAOImpl();
		positionDao.setDatabaseConnector(databaseConnector);
		this.invoiceStatusDao = new InvoiceStatusDAOImpl();
		invoiceStatusDao.setDatabaseConnector(databaseConnector);
		invoiceDao = new InvoiceDAOImpl();
		invoiceDao.setDatabaseConnector(databaseConnector);
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
		InvoiceStatusEntity status = new InvoiceStatusEntity();
		status.setName("DONE");
		invoiceStatusDao.persist(status);
		
		ServiceEntity service = new ServiceEntity();
		service.setName("serwis");
		serviceDao.persist(service);
		
		UserTypeEntity type1 = new UserTypeEntity();
		type1.setName("ORDINARY");
		userTypeDao.persist(type1);
		
		UserTypeEntity type2 = new UserTypeEntity();
		type2.setName("SUPER");
		userTypeDao.persist(type2);
		
		UserEntity user1 = new UserEntity();
		user1.setUsername("pawel");
		user1.setUserType(type1);
		userDao.persist(user1);
		
		UserEntity user2 = new UserEntity();
		user2.setUsername("bogdan");
		user2.setUserType(type2);
		userDao.persist(user2);
		
		InvoiceEntity invoice = new InvoiceEntity();
		invoice.setDate(LocalDateTime.now());
		invoice.setNumber("2018/02/07/01");
		invoice.setSeller(user2);
		invoice.setClient(user1);
		invoice.setStatus(status);
		
		PositionEntity position1 = new PositionEntity();
		position1.setAmount(1);
		position1.setService(service);
		position1.setInvoice(invoice);
		
		invoice.setPositions(Arrays.asList(position1));
		invoiceDao.persist(invoice);
		
		List<InvoiceEntity> entities = invoiceDao.findById(invoice.getId());
		assertEquals(1, entities.size());
		assertEquals(invoice, entities.get(0));
	}
	
	@Test(expected=PersistenceException.class)
	public void addPositionWithoutInvoice() {
		ServiceEntity service = new ServiceEntity();
		service.setName("serwis");
		serviceDao.persist(service);
		
		PositionEntity position1 = new PositionEntity();
		position1.setAmount(1);
		position1.setService(service);
		positionDao.persist(position1);
	}
	
	@Test
	public void simpleRemovingTest() {
		InvoiceStatusEntity status = new InvoiceStatusEntity();
		status.setName("DONE");
		invoiceStatusDao.persist(status);
		
		ServiceEntity service = new ServiceEntity();
		service.setName("serwis");
		serviceDao.persist(service);
		
		UserTypeEntity type1 = new UserTypeEntity();
		type1.setName("ORDINARY");
		userTypeDao.persist(type1);
		
		UserTypeEntity type2 = new UserTypeEntity();
		type2.setName("SUPER");
		userTypeDao.persist(type2);
		
		UserEntity user1 = new UserEntity();
		user1.setUsername("pawel");
		user1.setUserType(type1);
		userDao.persist(user1);
		
		UserEntity user2 = new UserEntity();
		user2.setUsername("bogdan");
		user2.setUserType(type2);
		userDao.persist(user2);
		
		InvoiceEntity invoice = new InvoiceEntity();
		invoice.setDate(LocalDateTime.now());
		invoice.setNumber("2018/02/07/01");
		invoice.setSeller(user2);
		invoice.setClient(user1);
		invoice.setStatus(status);
		
		PositionEntity position1 = new PositionEntity();
		position1.setAmount(1);
		position1.setService(service);
		position1.setInvoice(invoice);
		
		invoice.setPositions(Arrays.asList(position1));
		invoiceDao.persist(invoice);
		
		List<InvoiceEntity> entities = invoiceDao.findById(invoice.getId());
		assertEquals(1, entities.size());
		assertEquals(invoice, entities.get(0));
		
		invoiceDao.delete(invoice);
		assertEquals(0, invoiceDao.findAll().size());
		assertEquals(0, positionDao.findAll().size());
	}
	
	@Test
	public void removingOnlyPositionTest() {
		InvoiceStatusEntity status = new InvoiceStatusEntity();
		status.setName("DONE");
		invoiceStatusDao.persist(status);
		
		ServiceEntity service = new ServiceEntity();
		service.setName("serwis");
		serviceDao.persist(service);
		
		UserTypeEntity type1 = new UserTypeEntity();
		type1.setName("ORDINARY");
		userTypeDao.persist(type1);
		
		UserTypeEntity type2 = new UserTypeEntity();
		type2.setName("SUPER");
		userTypeDao.persist(type2);
		
		UserEntity user1 = new UserEntity();
		user1.setUsername("pawel");
		user1.setUserType(type1);
		userDao.persist(user1);
		
		UserEntity user2 = new UserEntity();
		user2.setUsername("bogdan");
		user2.setUserType(type2);
		userDao.persist(user2);
		
		InvoiceEntity invoice = new InvoiceEntity();
		invoice.setDate(LocalDateTime.now());
		invoice.setNumber("2018/02/07/01");
		invoice.setSeller(user2);
		invoice.setClient(user1);
		invoice.setStatus(status);
		
		PositionEntity position1 = new PositionEntity();
		position1.setAmount(1);
		position1.setService(service);
		position1.setInvoice(invoice);
		
		invoice.setPositions(Arrays.asList(position1));
		invoiceDao.persist(invoice);
		
		List<InvoiceEntity> entities = invoiceDao.findById(invoice.getId());
		assertEquals(1, entities.size());
		assertEquals(invoice, entities.get(0));
		assertEquals(1, positionDao.findAll().size());
		assertEquals(position1, positionDao.findAll().get(0));
		
		positionDao.delete(position1);
		assertEquals(1, invoiceDao.findAll().size());
		assertEquals(1, positionDao.findAll().size());
	}
	
	@Test
	public void removingPositionFromInvoiceTest() {
		InvoiceStatusEntity status = new InvoiceStatusEntity();
		status.setName("DONE");
		invoiceStatusDao.persist(status);
		
		ServiceEntity service = new ServiceEntity();
		service.setName("serwis");
		serviceDao.persist(service);
		
		UserTypeEntity type1 = new UserTypeEntity();
		type1.setName("ORDINARY");
		userTypeDao.persist(type1);
		
		UserTypeEntity type2 = new UserTypeEntity();
		type2.setName("SUPER");
		userTypeDao.persist(type2);
		
		UserEntity user1 = new UserEntity();
		user1.setUsername("pawel");
		user1.setUserType(type1);
		userDao.persist(user1);
		
		UserEntity user2 = new UserEntity();
		user2.setUsername("bogdan");
		user2.setUserType(type2);
		userDao.persist(user2);
		
		InvoiceEntity invoice = new InvoiceEntity();
		invoice.setDate(LocalDateTime.now());
		invoice.setNumber("2018/02/07/01");
		invoice.setSeller(user2);
		invoice.setClient(user1);
		invoice.setStatus(status);
		
		PositionEntity position1 = new PositionEntity();
		position1.setAmount(1);
		position1.setService(service);
		position1.setInvoice(invoice);
		
		invoice.setPositions(Arrays.asList(position1));
		invoiceDao.persist(invoice);
		
		List<InvoiceEntity> entities = invoiceDao.findById(invoice.getId());
		assertEquals(1, entities.size());
		assertEquals(invoice, entities.get(0));
		assertEquals(1, positionDao.findAll().size());
		assertEquals(position1, positionDao.findAll().get(0));
		
		invoice.setPositions(new ArrayList<PositionEntity>());
		invoiceDao.persist(invoice);
		assertEquals(1, invoiceDao.findAll().size());
		assertEquals(0, positionDao.findAll().size());
	}
}
