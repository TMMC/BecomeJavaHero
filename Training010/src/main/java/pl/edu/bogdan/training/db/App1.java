package pl.edu.bogdan.training.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class App1 {

	public static void main(String[] args) {
		String url = "jdbc:sqlite:../Wiki/Databases/test.sqlite3";
		try (Connection conn = DriverManager.getConnection(url);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from users")) {
			
			while (rs.next()) {
				
				System.out.println(rs.getString(2));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}

}
