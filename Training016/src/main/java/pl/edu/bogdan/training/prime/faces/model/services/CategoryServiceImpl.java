package pl.edu.bogdan.training.prime.faces.model.services;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import pl.edu.bogdan.training.prime.faces.db.dao.CategoryDAO;
import pl.edu.bogdan.training.prime.faces.db.entities.CategoryEntity;
import pl.edu.bogdan.training.prime.faces.model.objects.Category;

@ManagedBean(name="categoryService", eager=true)
@SessionScoped
public class CategoryServiceImpl implements CategoryService {

	@ManagedProperty(value="#{categoryDAO}")
	private CategoryDAO categoryDAO;
	
	public List<Category> findAll() {
		List<Category> result = new ArrayList<>();
		for (CategoryEntity entity: categoryDAO.findAll()) {
			result.add(fromEntity(entity));
		}
		return result;
	}

	public Category findById(int id) {
		List<CategoryEntity> entities = categoryDAO.findById(id);
		if (entities.size() == 1) {
			return fromEntity(entities.get(0));
		}
		return null;
	}
	
	public static Category fromEntity(CategoryEntity entity) {
		return new Category(entity.getId(), entity.getName());
	}
	
	public static CategoryEntity toEntity(Category category) {
		return new CategoryEntity(category.getId(), category.getName());
	}

	public void setCategoryDAO(CategoryDAO categoryDAO) {
		this.categoryDAO = categoryDAO;
	}
}
