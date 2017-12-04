package pl.edu.bogdan.training.db;

import java.util.List;

import pl.edu.bogdan.training.db.entity.Author;

public interface IAuthorService {
	List<Author> getAllAuthors();
}
