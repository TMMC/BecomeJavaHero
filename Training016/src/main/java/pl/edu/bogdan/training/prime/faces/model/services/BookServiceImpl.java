package pl.edu.bogdan.training.prime.faces.model.services;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import pl.edu.bogdan.training.prime.faces.db.dao.BookDAO;
import pl.edu.bogdan.training.prime.faces.db.entities.BookEntity;
import pl.edu.bogdan.training.prime.faces.model.objects.Book;

@ManagedBean(name="bookService", eager=true)
@SessionScoped
public class BookServiceImpl implements BookService {

	@ManagedProperty(value="#{bookDAO}")
	private BookDAO bookDAO;
	
	public List<Book> findAll() {
		List<Book> result = new ArrayList<Book>();
		for (BookEntity entity : bookDAO.findAll()) {
			result.add(fromEntity(entity));
		}
		return result;
	}

	public Book findById(int id) {
		List<BookEntity> entities = bookDAO.findById(id);
		if (entities.size() == 1) {
			return fromEntity(entities.get(0));
		}
		return null;
	}
	
	public Book fromEntity(BookEntity entity) {
		return new Book(
				entity.getId(),
				entity.getTitle(),
				AuthorServiceImpl.fromEntity(entity.getAuthor()),
				CategoryServiceImpl.fromEntity(entity.getCategory()),
				PublisherServiceImpl.fromEntity(entity.getPublisher()),
				entity.getIsbn(),
				entity.getDescription(),
				entity.getYear());
	}
	
	public BookEntity toEntity(Book book) {
		return new BookEntity(
				book.getId(),
				book.getTitle(),
				AuthorServiceImpl.toEntity(book.getAuthor()),
				CategoryServiceImpl.toEntity(book.getCategory()),
				PublisherServiceImpl.toEntity(book.getPublisher()),
				book.getIsbn(),
				book.getDescription(),
				book.getYear());
	}

	public void setBookDAO(BookDAO bookDAO) {
		this.bookDAO = bookDAO;
	}
	
	

}
