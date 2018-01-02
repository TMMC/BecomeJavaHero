package pl.edu.bogdan.training.jsf.db;

import java.util.List;

import pl.edu.bogdan.training.jsf.db.entity.Category;
import pl.edu.bogdan.training.jsf.db.entity.Publisher;

public interface IPublisherService {
	List<Publisher> getAllPublishers();
	Publisher getPublisherById(int id);
}
