package pl.edu.bogdan.training.jsf.db;

import java.util.List;

import pl.edu.bogdan.training.jsf.db.entity.Book;

public interface IBookService {
	List<Book> getAllBooks();
	List<Book> getBooksOfAuthorWithId(int id);
}
