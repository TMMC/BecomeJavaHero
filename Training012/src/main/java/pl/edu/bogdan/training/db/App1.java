package pl.edu.bogdan.training.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class App1  {
    public static void main( String[] args ) {
    	String url = "jdbc:sqlite:../Wiki/Databases/test2.sqlite3";
    	try (Connection conn = DriverManager.getConnection(url)) {
    		
    	} catch (SQLException e) {
    		e.printStackTrace();
    	}
    }
}
