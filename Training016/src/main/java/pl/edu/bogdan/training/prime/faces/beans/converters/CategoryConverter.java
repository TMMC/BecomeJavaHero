package pl.edu.bogdan.training.prime.faces.beans.converters;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import pl.edu.bogdan.training.prime.faces.model.objects.Category;
import pl.edu.bogdan.training.prime.faces.model.services.CategoryService;


@ManagedBean(name="categoryConverter")
@SessionScoped
public class CategoryConverter implements Converter {

	@ManagedProperty(value="#{categoryService}")
	private CategoryService categoryService;
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		int id = Integer.parseInt(value);
		Category category = categoryService.findById(id); 
		return category;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		int id = ((Category)value).getId();
		return String.valueOf(id);
	}

	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	
	
}
