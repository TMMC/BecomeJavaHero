package pl.edu.bogdan.training.prime.faces.db.dao;

import java.util.List;

import pl.edu.bogdan.training.prime.faces.db.entities.BookEntity;

public interface BookDAO {
	List<BookEntity> findAll();
	List<BookEntity> findById(int id);
}
