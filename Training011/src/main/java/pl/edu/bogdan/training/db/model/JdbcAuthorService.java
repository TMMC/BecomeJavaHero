package pl.edu.bogdan.training.db.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JdbcAuthorService implements IAuthorService {

	
	private Connection connection;
	
	@Override
	public List<Author> getAllAuthors() {
		List<Author> result = new ArrayList<>();
		try (Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM autorzy")) {
			while (rs.next()) {
				result.add(new Author(
						rs.getInt(1),
						rs.getString(2), 
						rs.getString(3)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

}
