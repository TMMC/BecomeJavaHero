package pl.edu.bogdan.training.invoice.db;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import org.junit.Test;

import pl.edu.bogdan.training.invoice.database.dao.impl.jpa.ProductionDatabaseConnector;
import pl.edu.bogdan.training.invoice.database.dao.impl.jpa.UserDAOImpl;
import pl.edu.bogdan.training.invoice.database.dao.impl.jpa.UserTypeDAOImpl;
import pl.edu.bogdan.training.invoice.database.entities.UserEntity;
import pl.edu.bogdan.training.invoice.database.entities.UserTypeEntity;

public class PopulateDatabase {
	@Test
	public void populate() throws NoSuchAlgorithmException {
		UserTypeEntity type = new UserTypeEntity();
		type.setName("USER");
		
		UserEntity user = new UserEntity();
		user.setUsername("pawel");
		user.setAddress("Jeleniewo");
		user.setName("Paweł Bogdan");
		user.setUserType(type);
		
		MessageDigest md = MessageDigest.getInstance("MD5");
		String pass = "pawel";
		md.update(pass.getBytes());
		Base64.Encoder encoder = Base64.getEncoder();
		user.setPassword(encoder.encodeToString(md.digest()));
		ProductionDatabaseConnector connector = new ProductionDatabaseConnector(); 
		UserTypeDAOImpl typeDAO = new UserTypeDAOImpl();
		typeDAO.setDatabaseConnector(connector);
		UserDAOImpl userDAO = new UserDAOImpl();
		userDAO.setDatabaseConnector(connector);
		typeDAO.persist(type);
		userDAO.persist(user);
	}
}
