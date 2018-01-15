package pl.edu.bogdan.training.prime.faces.beans.converters;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import pl.edu.bogdan.training.prime.faces.model.objects.Publisher;
import pl.edu.bogdan.training.prime.faces.model.services.PublisherService;


@ManagedBean(name="publisherConverter")
@SessionScoped
public class PublisherConverter implements Converter {

	@ManagedProperty(value="#{publisherService}")
	private PublisherService publisherService;
	

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		int id = Integer.parseInt(value);
		Publisher publisher = publisherService.findById(id);
		return publisher;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		int id = ((Publisher)value).getId();
		return String.valueOf(id);
	}

	public void setPublisherService(PublisherService publisherService) {
		this.publisherService = publisherService;
	}
	
	
}
