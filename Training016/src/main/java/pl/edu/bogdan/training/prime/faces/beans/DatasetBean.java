package pl.edu.bogdan.training.prime.faces.beans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import pl.edu.bogdan.training.prime.faces.model.objects.Author;
import pl.edu.bogdan.training.prime.faces.model.objects.Book;
import pl.edu.bogdan.training.prime.faces.model.objects.Category;
import pl.edu.bogdan.training.prime.faces.model.objects.Publisher;
import pl.edu.bogdan.training.prime.faces.model.services.AuthorService;
import pl.edu.bogdan.training.prime.faces.model.services.BookService;
import pl.edu.bogdan.training.prime.faces.model.services.CategoryService;
import pl.edu.bogdan.training.prime.faces.model.services.PublisherService;

@ManagedBean(name="dataset")
@SessionScoped
public class DatasetBean {
	
	@ManagedProperty(value="#{bookService}")
	private BookService bookService;
	
	@ManagedProperty(value="#{categoryService}")
	private CategoryService categoryService;
	
	@ManagedProperty(value="#{authorService}")
	private AuthorService authorService;
	
	@ManagedProperty(value="#{publisherService}")
	private PublisherService publisherService;
	
	
	private List<Book> allBooks;
	private List<Category> allCategories;
	private List<Author> allAuthors;
	private List<Publisher> allPublishers;

	public List<Book> getAllBooks() {
		if (allBooks == null) {
			allBooks = bookService.findAll();
		}
		return allBooks;
	}
	
	public List<Category> getAllCategories() {
		if (allCategories == null) {
			allCategories = categoryService.findAll();
		}
		return allCategories;
	}

	public List<Author> getAllAuthors() {
		if (allAuthors == null) {
			allAuthors = authorService.findAll();
		}
		return allAuthors;
	}

	public List<Publisher> getAllPublishers() {
		if (allPublishers == null) {
			allPublishers = publisherService.findAll();
		}
		return allPublishers;
	}

	public String startEditing(Book book) {
		book.setEditable(true);
		return null;
	}
	
	public String stopEditing(Book book) {
		book.setEditable(false);
		return null;
	}

	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}

	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	public void setAuthorService(AuthorService authorService) {
		this.authorService = authorService;
	}

	public void setPublisherService(PublisherService publisherService) {
		this.publisherService = publisherService;
	}
	
	
}
