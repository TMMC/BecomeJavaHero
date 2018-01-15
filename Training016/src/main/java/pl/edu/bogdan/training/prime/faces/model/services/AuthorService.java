package pl.edu.bogdan.training.prime.faces.model.services;

import java.util.List;

import pl.edu.bogdan.training.prime.faces.model.objects.Author;

public interface AuthorService {
	List<Author> findAll();
	Author findById(int id);
}
