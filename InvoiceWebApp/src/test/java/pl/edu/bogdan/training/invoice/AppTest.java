package pl.edu.bogdan.training.invoice;

import static org.junit.Assert.*;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.Test;

import pl.edu.bogdan.training.invoice.database.dao.impl.jpa.DatabaseConnector;
import pl.edu.bogdan.training.invoice.database.dao.impl.jpa.InvoiceDAOImpl;
import pl.edu.bogdan.training.invoice.database.dao.impl.jpa.InvoiceStatusDAOImpl;
import pl.edu.bogdan.training.invoice.database.dao.impl.jpa.PositionDAOImpl;
import pl.edu.bogdan.training.invoice.database.dao.impl.jpa.ProductionDatabaseConnector;
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

public class AppTest {
	@Test
	public void simpleTest() {
		new ProductionDatabaseConnector();
	}
	
	@Test
	public void simpleTestUsingTestingDatabase() {
		DatabaseConnector connector = new TestingDatabaseConnector();
		
		UserTypeDAOImpl userTypeDAO = new UserTypeDAOImpl();
		userTypeDAO.setDatabaseConnector(connector);
		
		UserDAOImpl userDAO = new UserDAOImpl();
		userDAO.setDatabaseConnector(connector);
		
		InvoiceStatusDAOImpl invoiceStatusDAO = new InvoiceStatusDAOImpl();
		invoiceStatusDAO.setDatabaseConnector(connector);
		
		ServiceDAOImpl serviceDAO = new ServiceDAOImpl();
		serviceDAO.setDatabaseConnector(connector);
		
		PositionDAOImpl positionDAO = new PositionDAOImpl();
		positionDAO.setDatabaseConnector(connector);
		
		InvoiceDAOImpl invoiceDAO = new InvoiceDAOImpl();
		invoiceDAO.setDatabaseConnector(connector);
		
		
		UserTypeEntity clientType = new UserTypeEntity();
		clientType.setName("CLIENT");
		
		UserTypeEntity sellerType = new UserTypeEntity();
		sellerType.setName("SELLER");
		
		userTypeDAO.persist(clientType);
		userTypeDAO.persist(sellerType);
		
		UserEntity sellerUser = new UserEntity();
		sellerUser.setAddress("Adres sprzedawc");
		sellerUser.setName("Dobry sprzedawca");
		sellerUser.setUsername("sprzedawca");
		sellerUser.setPassword("tajne_haslo");
		sellerUser.setUserType(sellerType);
		
		UserEntity clientUser = new UserEntity();
		clientUser.setAddress("Adres klienta");
		clientUser.setName("Dobry klient");
		clientUser.setUsername("klient");
		clientUser.setPassword("tajne_haslo");
		clientUser.setUserType(clientType);
		
		userDAO.persist(sellerUser);
		userDAO.persist(clientUser);
		
		InvoiceStatusEntity invoiceDraft = new InvoiceStatusEntity();
		invoiceDraft.setName("DRAFT");
		
		InvoiceStatusEntity invoiceAccepted = new InvoiceStatusEntity();
		invoiceAccepted.setName("ACCEPTED");
		
		invoiceStatusDAO.persist(invoiceDraft);
		invoiceStatusDAO.persist(invoiceAccepted);
		
		ServiceEntity stuff = new ServiceEntity();
		stuff.setName("wygłupy");
		stuff.setUnit("godzina");
		stuff.setPriceForUnit(85);
		
		serviceDAO.persist(stuff);
		
		InvoiceEntity invoice = new InvoiceEntity();
		invoice.setClient(clientUser);
		invoice.setSeller(sellerUser);
		invoice.setNumber("2018/01/30-1");
		invoice.setStatus(invoiceDraft);
		invoice.setDate(LocalDateTime.now());
		
		invoiceDAO.persist(invoice);
		
		PositionEntity position = new PositionEntity();
		position.setService(stuff);
		position.setAmount(5);
		position.setInvoice(invoice);
		
		positionDAO.persist(position);
		
		List<UserTypeEntity> userTypes = userTypeDAO.findAll();
		List<UserEntity> users = userDAO.findAll();
		
		assertEquals(2, userTypes.size());
		assertTrue(userTypes.contains(clientType));
		assertTrue(userTypes.contains(sellerType));
		
		assertEquals(2, users.size());
		assertTrue(users.contains(sellerUser));
		assertTrue(users.contains(clientUser));
		
		clientType = userTypeDAO.findFetchedById(clientType.getId()).get(0);
		sellerType = userTypeDAO.findFetchedById(sellerType.getId()).get(0);
		
		assertEquals(1, clientType.getUsers().size());
		assertEquals(clientUser, clientType.getUsers().get(0));
		assertEquals(1, sellerType.getUsers().size());
		assertEquals(sellerUser, sellerType.getUsers().get(0));
		
		InvoiceEntity invoiceFromDB = invoiceDAO.findById(invoice.getId()).get(0);
		assertEquals(1, invoiceFromDB.getPositions().size());
		System.out.println(invoiceFromDB);
	}
}
