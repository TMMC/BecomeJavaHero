package pl.edu.bogdan.training.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class App1 {

	public static void main(String[] args) {
		String url = "jdbc:sqlite:../Wiki/Databases/test.sqlite3";
		try (Connection conn = DriverManager.getConnection(url);
			Statement stmt = conn.createStatement()) {
//			stmt.executeUpdate("CREATE VIEW v_users as select id as v_id, name as v_name, age from users");
			ResultSet rs = stmt.executeQuery("select v_id as vvvv_id, v_name, age from v_users");
			ResultSetMetaData meta = rs.getMetaData();
			for (int i = 1; i<=meta.getColumnCount(); i++) {
				System.out.println(meta.getColumnLabel(i));
				System.out.println(meta.getColumnTypeName(i));
			}
			while (rs.next()) {
				System.out.println("===================================");
				System.out.println(rs.getInt(1));
				System.out.println(rs.getString(2));
				System.out.println(rs.getInt(3));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}

}
