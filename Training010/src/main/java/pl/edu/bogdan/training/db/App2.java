package pl.edu.bogdan.training.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class App2 {

	public static void main(String[] args) {
		String url = "jdbc:derby:../Wiki/Databases/derby_test_1;create=true";
		try (Connection conn = DriverManager.getConnection(url);
			Statement stmt = conn.createStatement()) {
			
			stmt.executeUpdate("CREATE TABLE persons ("
					+ "ID integer PRIMARY KEY, "
					+ "first_name VARCHAR(50), "
					+ "last_name VARCHAR(50))");
			
			stmt.executeUpdate("INSERT INTO persons VALUES (1, 'Pawel', 'Bogdan')");
			stmt.executeUpdate("INSERT INTO persons VALUES (2,'Adam', 'Mickiewicz')");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}
}
