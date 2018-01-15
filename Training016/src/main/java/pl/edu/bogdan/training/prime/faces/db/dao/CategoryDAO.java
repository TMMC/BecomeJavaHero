package pl.edu.bogdan.training.prime.faces.db.dao;

import java.util.List;

import pl.edu.bogdan.training.prime.faces.db.entities.CategoryEntity;

public interface CategoryDAO {
	List<CategoryEntity> findAll();
	List<CategoryEntity> findById(int id);
}
