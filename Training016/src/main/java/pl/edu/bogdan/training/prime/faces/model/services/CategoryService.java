package pl.edu.bogdan.training.prime.faces.model.services;

import java.util.List;

import pl.edu.bogdan.training.prime.faces.model.objects.Category;

public interface CategoryService {
	List<Category> findAll();
	Category findById(int id);
}
