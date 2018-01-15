package pl.edu.bogdan.training.prime.faces.model.services;

import java.util.List;

import pl.edu.bogdan.training.prime.faces.model.objects.Book;

public interface BookService {
	List<Book> findAll();
	Book findById(int id);
}
