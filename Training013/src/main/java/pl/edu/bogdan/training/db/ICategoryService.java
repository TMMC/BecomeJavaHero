package pl.edu.bogdan.training.db;

import java.util.List;

import pl.edu.bogdan.training.db.entity.Category;

public interface ICategoryService {
	List<Category> getAllCategories();
	Category getCategoryById(int id);
}
