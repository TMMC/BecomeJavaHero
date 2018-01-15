package pl.edu.bogdan.training.prime.faces.db.dao;

import java.util.List;

import pl.edu.bogdan.training.prime.faces.db.entities.PublisherEntity;

public interface PublisherDAO {
	List<PublisherEntity> findAll();
	List<PublisherEntity> findById(int id);
}
