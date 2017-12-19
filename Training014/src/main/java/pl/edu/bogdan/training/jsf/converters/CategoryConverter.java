package pl.edu.bogdan.training.jsf.converters;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import pl.edu.bogdan.training.jsf.db.JPACategoryService;
import pl.edu.bogdan.training.jsf.db.entity.Category;

@ManagedBean(name="categoryConverter")
@SessionScoped
//@FacesConverter("pl.edu.bogdan.training.jsf.converters.CategoryConverter")
public class CategoryConverter implements Converter {

	@ManagedProperty(value="#{categoryService}")
	JPACategoryService categoryService;
	
	public JPACategoryService getCategoryService() {
		return categoryService;
	}

	public void setCategoryService(JPACategoryService categoryService) {
		this.categoryService = categoryService;
	}

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		int id = Integer.parseInt(value);
		Category category = categoryService.getCategoryById(id); 
		System.out.println(category.toString());
		return category;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		int id = ((Category)value).getId();
		System.out.println("------------------------------");
		System.out.println(value);
		System.out.println(id);
		return String.valueOf(id);
	}

}
