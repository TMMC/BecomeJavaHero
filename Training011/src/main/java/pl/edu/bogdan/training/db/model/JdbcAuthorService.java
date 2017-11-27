package pl.edu.bogdan.training.db.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.edu.bogdan.training.db.Database;

@Service
public class JdbcAuthorService implements IAuthorService {

	private Database database;
	
	@Autowired
	public void setDatabase(Database database) {
		this.database = database;
	}
	
	
	@Override
	public List<Author> getAllAuthors() {
		List<Author> result = new ArrayList<>();
		try (Connection connection = database.createConnection();
			Statement stmt = connection.createStatement();
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
