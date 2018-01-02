package pl.edu.bogdan.training.jsf.converters;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import pl.edu.bogdan.training.jsf.db.JPACategoryService;
import pl.edu.bogdan.training.jsf.db.JPAPublisherService;
import pl.edu.bogdan.training.jsf.db.entity.Category;
import pl.edu.bogdan.training.jsf.db.entity.Publisher;

@ManagedBean(name="publisherConverter")
@SessionScoped
public class PublisherConverter implements Converter {

	@ManagedProperty(value="#{publisherService}")
	private JPAPublisherService publisherService;
	

	public JPAPublisherService getPublisherService() {
		return publisherService;
	}

	public void setPublisherService(JPAPublisherService publisherService) {
		this.publisherService = publisherService;
	}

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		int id = Integer.parseInt(value);
		Publisher publisher = publisherService.getPublisherById(id);
		return publisher;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		int id = ((Publisher)value).getId();
		return String.valueOf(id);
	}
}
