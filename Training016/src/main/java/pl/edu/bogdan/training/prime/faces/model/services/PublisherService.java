package pl.edu.bogdan.training.prime.faces.model.services;

import java.util.List;

import pl.edu.bogdan.training.prime.faces.model.objects.Publisher;

public interface PublisherService {
	List<Publisher> findAll();
	Publisher findById(int id);
}
