package pl.edu.bogdan.training.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pl.edu.bogdan.training.db.IAuthorService;
import pl.edu.bogdan.training.db.IBookService;
import pl.edu.bogdan.training.db.entity.Author;
import pl.edu.bogdan.training.db.entity.Book;


@Controller
public class Greeter {
	
	IAuthorService authorService;
	IBookService bookService;
	
	@Autowired
	public void setAuthorService(IAuthorService authorService) {
		this.authorService = authorService;
	}
	
	@Autowired
	public void setBookService(IBookService bookService) {
		this.bookService = bookService;
	}

	@RequestMapping("/greeting")
	public String greeting(@RequestParam(value = "name", required = false, defaultValue = "World") String name, Model model) {
		model.addAttribute("name", name);
		return "greeting";
	}
	
	@RequestMapping("/authors/all")
	public String getAllAuthors(Model model) {
		List<Author> authors = authorService.getAllAuthors();
		model.addAttribute("authors", authors);
		return "all_authors";
	}
	
	@RequestMapping("/books/all")
	public String getAllBooks(Model model) {
		List<Book> books = bookService.getAllBooks();
		model.addAttribute("books", books);
		return "all_books";
	}
	
	@RequestMapping("/books/{authorId}")
	public String getAllBooks(@PathVariable(name="authorId") int authorId, Model model) {
		List<Book> books = bookService.getBooksOfAuthorWithId(authorId);
		model.addAttribute("books", books);
		return "all_books";
	}
	
	@RequestMapping("/author/add")
	public String addUser(@RequestParam(name="firstName")String firstName, 
						  @RequestParam(name="lastName") String lastName, Model model) {
		Author author = new Author();
		author.setFirstName(firstName);
		author.setLastName(lastName);
		authorService.addAuthor(author);
		model.addAttribute("author", author);
		return "author_added";
	}
}
