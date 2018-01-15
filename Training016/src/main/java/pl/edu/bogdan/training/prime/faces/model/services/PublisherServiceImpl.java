package pl.edu.bogdan.training.prime.faces.model.services;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import pl.edu.bogdan.training.prime.faces.db.dao.PublisherDAO;
import pl.edu.bogdan.training.prime.faces.db.entities.PublisherEntity;
import pl.edu.bogdan.training.prime.faces.model.objects.Publisher;

@ManagedBean(name="publisherService", eager=true)
@SessionScoped
public class PublisherServiceImpl implements PublisherService {

	@ManagedProperty(value="#{publisherDAO}")
	private PublisherDAO publisherDAO;
	
	public List<Publisher> findAll() {
		List<Publisher> result = new ArrayList<>();
		for (PublisherEntity entity: publisherDAO.findAll()) {
			result.add(fromEntity(entity));
		}
		return result;
	}

	public Publisher findById(int id) {
		List<PublisherEntity> entities = publisherDAO.findById(id);
		if (entities.size() == 1) {
			return fromEntity(entities.get(0));
		}
		return null;
	}

	public static Publisher fromEntity(PublisherEntity entity) {
		return new Publisher(entity.getId(), entity.getName());
	}
	
	public static PublisherEntity toEntity(Publisher publisher) {
		return new PublisherEntity(publisher.getId(), publisher.getName());
	}

	public void setPublisherDAO(PublisherDAO publisherDAO) {
		this.publisherDAO = publisherDAO;
	}
}
