package pl.edu.bogdan.training.jsf.converters;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import pl.edu.bogdan.training.jsf.db.JPAAuthorService;
import pl.edu.bogdan.training.jsf.db.JPACategoryService;
import pl.edu.bogdan.training.jsf.db.entity.Author;
import pl.edu.bogdan.training.jsf.db.entity.Category;

@ManagedBean(name="authorConverter")
@SessionScoped
public class AuthorConverter implements Converter {

	@ManagedProperty(value="#{authorService}")
	private JPAAuthorService authorService;

	public JPAAuthorService getAuthorService() {
		return authorService;
	}

	public void setAuthorService(JPAAuthorService authorService) {
		this.authorService = authorService;
	}

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		int id = Integer.parseInt(value);
		Author category = authorService.getAuthorById(id);
		return category;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		int id = ((Author)value).getId();
		return String.valueOf(id);
	}
}
