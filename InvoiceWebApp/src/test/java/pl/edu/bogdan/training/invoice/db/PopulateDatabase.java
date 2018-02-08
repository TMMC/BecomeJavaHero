package pl.edu.bogdan.training.invoice.db;



import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import pl.edu.bogdan.training.invoice.database.dao.impl.jpa.DatabaseConnector;
import pl.edu.bogdan.training.invoice.database.dao.impl.jpa.InvoiceDAOImpl;
import pl.edu.bogdan.training.invoice.database.dao.impl.jpa.InvoiceStatusDAOImpl;
import pl.edu.bogdan.training.invoice.database.dao.impl.jpa.PositionDAOImpl;
import pl.edu.bogdan.training.invoice.database.dao.impl.jpa.ProductionDatabaseConnector;
import pl.edu.bogdan.training.invoice.database.dao.impl.jpa.ServiceDAOImpl;
import pl.edu.bogdan.training.invoice.database.dao.impl.jpa.UserDAOImpl;
import pl.edu.bogdan.training.invoice.database.dao.impl.jpa.UserTypeDAOImpl;
import pl.edu.bogdan.training.invoice.database.entities.InvoiceEntity;
import pl.edu.bogdan.training.invoice.database.entities.InvoiceStatusEntity;
import pl.edu.bogdan.training.invoice.database.entities.PositionEntity;
import pl.edu.bogdan.training.invoice.database.entities.ServiceEntity;
import pl.edu.bogdan.training.invoice.database.entities.UserEntity;
import pl.edu.bogdan.training.invoice.database.entities.UserTypeEntity;
import pl.edu.bogdan.training.invoice.utils.Hashing;

public class PopulateDatabase {
	public static void main(String[] args) {
		DatabaseConnector databaseConnector = new ProductionDatabaseConnector();
		PositionDAOImpl positionDao = new PositionDAOImpl();
		positionDao.setDatabaseConnector(databaseConnector);
		ServiceDAOImpl serviceDao = new ServiceDAOImpl();
		serviceDao.setDatabaseConnector(databaseConnector);
		InvoiceStatusDAOImpl invoiceStatusDao = new InvoiceStatusDAOImpl();
		invoiceStatusDao.setDatabaseConnector(databaseConnector);
		InvoiceDAOImpl invoiceDao = new InvoiceDAOImpl();
		invoiceDao.setDatabaseConnector(databaseConnector);
		UserDAOImpl userDao = new UserDAOImpl();
		userDao.setDatabaseConnector(databaseConnector);
		UserTypeDAOImpl userTypeDao = new UserTypeDAOImpl();
		userTypeDao.setDatabaseConnector(databaseConnector);
		
		InvoiceStatusEntity statusDone = new InvoiceStatusEntity();
		statusDone.setName("DONE");
		invoiceStatusDao.persist(statusDone);
		
		InvoiceStatusEntity statusDraft = new InvoiceStatusEntity();
		statusDraft.setName("DRAFT");
		invoiceStatusDao.persist(statusDraft);
		
		UserTypeEntity ordinaryUserType = new UserTypeEntity();
		ordinaryUserType.setName("ORDINARY");
		userTypeDao.persist(ordinaryUserType);
		
		UserTypeEntity superUserType = new UserTypeEntity();
		superUserType.setName("SUPER");
		userTypeDao.persist(superUserType);
		
		UserEntity user1 = new UserEntity();
		user1.setName("Paweł Bogdan");
		user1.setAddress("ul. Łojasiewicza 6, 30-348 Kraków");
		user1.setUserType(superUserType);
		user1.setUsername("pawel");
		user1.setPassword(Hashing.hash("pawel"));
		userDao.persist(user1);
		
		UserEntity user2 = new UserEntity();
		user2.setName("Jan Kowalski");
		user2.setAddress("ul. Kościuszki 2, 30-348 Kraków");
		user2.setUserType(ordinaryUserType);
		user2.setUsername("jan");
		user2.setPassword(Hashing.hash("jan"));
		userDao.persist(user2);
		
		UserEntity user3 = new UserEntity();
		user3.setName("Jerzy Nowak");
		user3.setAddress("ul. Konopnickiej 7, 30-348 Kraków");
		user3.setUserType(ordinaryUserType);
		user3.setUsername("jerzy");
		user3.setPassword(Hashing.hash("jerzy"));
		userDao.persist(user3);
		
		ServiceEntity service1 = new ServiceEntity();
		service1.setName("nauka szydełkowania");
		service1.setPriceForUnit(77.99);
		service1.setUnit("godzina");
		serviceDao.persist(service1);
		
		ServiceEntity service2 = new ServiceEntity();
		service2.setName("wypożyczenie taczki");
		service2.setPriceForUnit(19.99);
		service2.setUnit("godzina");
		serviceDao.persist(service2);
		
		ServiceEntity service3 = new ServiceEntity();
		service3.setName("usługi transportowe");
		service3.setPriceForUnit(35.99);
		service3.setUnit("kilometr");
		serviceDao.persist(service3);
		
		ServiceEntity service4 = new ServiceEntity();
		service4.setName("malowanie ściany");
		service4.setPriceForUnit(99.99);
		service4.setUnit("m2");
		serviceDao.persist(service4);
		
		InvoiceEntity invoice1 = new InvoiceEntity();
		invoice1.setDate(LocalDateTime.of(2017, 2, 13, 12, 12));
		invoice1.setNumber("2017/02/13/1");
		invoice1.setStatus(statusDone);
		invoice1.setSeller(user1);
		invoice1.setClient(user2);
		
		InvoiceEntity invoice2 = new InvoiceEntity();
		invoice2.setDate(LocalDateTime.of(2017, 8, 13, 16, 12));
		invoice2.setNumber("2017/08/13/1");
		invoice2.setStatus(statusDone);
		invoice2.setSeller(user1);
		invoice2.setClient(user2);
		
		InvoiceEntity invoice3 = new InvoiceEntity();
		invoice3.setDate(LocalDateTime.of(2018, 1, 30, 9, 12));
		invoice3.setNumber("2018/01/30/1");
		invoice3.setStatus(statusDone);
		invoice3.setSeller(user1);
		invoice3.setClient(user2);
		
		InvoiceEntity invoice4 = new InvoiceEntity();
		invoice4.setDate(LocalDateTime.of(2018, 2, 2, 15, 12));
		invoice4.setNumber("2018/02/02/1");
		invoice4.setStatus(statusDone);
		invoice4.setSeller(user1);
		invoice4.setClient(user3);
		
		List<PositionEntity> positions1 = new ArrayList<>();
		List<PositionEntity> positions2 = new ArrayList<>();
		List<PositionEntity> positions3 = new ArrayList<>();
		List<PositionEntity> positions4 = new ArrayList<>();
		
		PositionEntity position1 = new PositionEntity();
		position1.setAmount(1);
		position1.setService(service1);
		position1.setInvoice(invoice1);
		positions1.add(position1);
		
		PositionEntity position2 = new PositionEntity();
		position2.setAmount(5);
		position2.setService(service4);
		position2.setInvoice(invoice1);
		positions1.add(position2);
		
		PositionEntity position3 = new PositionEntity();
		position3.setAmount(50);
		position3.setService(service2);
		position3.setInvoice(invoice2);
		positions2.add(position3);
		
		PositionEntity position4 = new PositionEntity();
		position4.setAmount(50);
		position4.setService(service3);
		position4.setInvoice(invoice3);
		positions3.add(position4);
		
		PositionEntity position5 = new PositionEntity();
		position5.setAmount(6);
		position5.setService(service1);
		position5.setInvoice(invoice4);
		positions4.add(position5);
		
		PositionEntity position6 = new PositionEntity();
		position6.setAmount(30);
		position6.setService(service2);
		position6.setInvoice(invoice4);
		positions4.add(position6);
		
		invoice1.setPositions(positions1);
		invoice2.setPositions(positions2);
		invoice3.setPositions(positions3);
		invoice4.setPositions(positions4);
		
		invoiceDao.persist(invoice1);
		invoiceDao.persist(invoice2);
		invoiceDao.persist(invoice3);
		invoiceDao.persist(invoice4);
		
		databaseConnector.close();
	}
}
