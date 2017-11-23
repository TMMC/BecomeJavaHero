package pl.edu.bogdan.training.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class App3 {

	public static void main(String[] args) {
		String url = "jdbc:sqlite:../Wiki/Databases/derby_test_1";
		try (Connection conn = DriverManager.getConnection(url);
			Statement stmt = conn.createStatement()) {
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}

}
