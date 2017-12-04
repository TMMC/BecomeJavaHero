package pl.edu.bogdan.training.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class App4 {

	public static void main(String[] args) {
		String url = "jdbc:postgresql://localhost:5432/test1";
		try (Connection conn = DriverManager.getConnection(url, "postgres", "postgres");
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * from persons")) {
			
			while (rs.next()) {
				System.out.println(rs.getString("name"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}

}
