package pl.edu.bogdan.training.invoice.dao;

import static org.junit.Assert.*;

import java.util.List;

import javax.persistence.RollbackException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import pl.edu.bogdan.training.invoice.database.dao.impl.jpa.DatabaseConnector;
import pl.edu.bogdan.training.invoice.database.dao.impl.jpa.InvoiceStatusDAOImpl;
import pl.edu.bogdan.training.invoice.database.dao.impl.jpa.TestingDatabaseConnector;
import pl.edu.bogdan.training.invoice.database.entities.InvoiceStatusEntity;

public class InvoiceStatusDaoTest {
	private DatabaseConnector databaseConnector;
	private InvoiceStatusDAOImpl invoiceStatusDao;
	
	@Before
	public void setup() {
		this.databaseConnector = new TestingDatabaseConnector();
		this.invoiceStatusDao = new InvoiceStatusDAOImpl();
		invoiceStatusDao.setDatabaseConnector(databaseConnector);
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
		List<InvoiceStatusEntity> statuses = invoiceStatusDao.findAll();
		assertEquals(1, statuses.size());
		assertEquals(status, statuses.get(0));
		statuses = invoiceStatusDao.findById(status.getId());
		assertEquals(1, statuses.size());
		assertEquals(status, statuses.get(0));
	}
	
	@Test(expected=RollbackException.class)
	public void simpleInsertingTwoTest() {
		InvoiceStatusEntity status = new InvoiceStatusEntity();
		status.setName("DONE");
		invoiceStatusDao.persist(status);
		status = new InvoiceStatusEntity();
		status.setName("DONE");
		invoiceStatusDao.persist(status);
		
	}
	
	@Test
	public void simpleUpdatingTest() {
		InvoiceStatusEntity status = new InvoiceStatusEntity();
		status.setName("DONE");
		invoiceStatusDao.persist(status);
		List<InvoiceStatusEntity> statuses = invoiceStatusDao.findAll();
		assertEquals(1, statuses.size());
		assertEquals(status, statuses.get(0));
		
		status.setName("REJECTED");
		invoiceStatusDao.persist(status);
		
		statuses = invoiceStatusDao.findById(status.getId());
		assertEquals(1, statuses.size());
		assertEquals(status, statuses.get(0));
	}
	
	@Test
	public void simpleRemovingTest() {
		InvoiceStatusEntity status = new InvoiceStatusEntity();
		status.setName("DONE");
		invoiceStatusDao.persist(status);
		List<InvoiceStatusEntity> statuses = invoiceStatusDao.findAll();
		assertEquals(1, statuses.size());
		assertEquals(status, statuses.get(0));
		
		invoiceStatusDao.delete(status);
		
		statuses = invoiceStatusDao.findById(status.getId());
		assertEquals(0, statuses.size());
	}
}
