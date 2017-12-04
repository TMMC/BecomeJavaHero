package pl.edu.bogdan.training.db;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.springframework.stereotype.Service;

@Service
public class Database {
	private final String username;
	private final String password;
	private final String hostname;
	private final String port;
	private final String database;
	
	public Database() throws FileNotFoundException, IOException {
		Properties properties = new Properties();
		properties.load(new FileInputStream("src/main/resources/database.properties"));
		username = properties.getProperty("username");
		password = properties.getProperty("password");
		hostname = properties.getProperty("url");
		database = properties.getProperty("name");
		port = properties.getProperty("port");
	}
	
	public Connection createConnection() throws SQLException {
		return DriverManager.getConnection(String.format("jdbc:postgresql://%s:%s/%s", hostname, port, database), username, password);
	}
}
