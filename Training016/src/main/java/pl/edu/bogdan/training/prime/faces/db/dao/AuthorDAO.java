package pl.edu.bogdan.training.prime.faces.db.dao;

import java.util.List;

import pl.edu.bogdan.training.prime.faces.db.entities.AuthorEntity;

public interface AuthorDAO {
	List<AuthorEntity> findAll();
	List<AuthorEntity> findById(int id);
}
