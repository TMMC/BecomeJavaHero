package pl.edu.bogdan.training.jsf.db;

import java.util.List;

import pl.edu.bogdan.training.jsf.db.entity.Author;

public interface IAuthorService {
	List<Author> getAllAuthors();
	void addAuthor(Author author);
	Author getAuthorById(int id);
}
