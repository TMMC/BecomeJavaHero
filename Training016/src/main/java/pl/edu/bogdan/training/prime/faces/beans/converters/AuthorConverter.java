package pl.edu.bogdan.training.prime.faces.beans.converters;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import pl.edu.bogdan.training.prime.faces.model.objects.Author;
import pl.edu.bogdan.training.prime.faces.model.services.AuthorService;


@ManagedBean(name="authorConverter")
@SessionScoped
public class AuthorConverter implements Converter {

	@ManagedProperty(value="#{authorService}")
	private AuthorService authorService;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		int id = Integer.parseInt(value);
		Author category = authorService.findById(id);
		return category;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		int id = ((Author)value).getId();
		return String.valueOf(id);
	}

	public void setAuthorService(AuthorService authorService) {
		this.authorService = authorService;
	}
}
