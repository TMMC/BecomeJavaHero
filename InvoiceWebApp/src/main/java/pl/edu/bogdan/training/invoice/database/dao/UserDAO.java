package pl.edu.bogdan.training.invoice.database.dao;

import java.util.List;

import pl.edu.bogdan.training.invoice.database.entities.UserEntity;

public interface UserDAO {
	List<UserEntity> findAll();
	List<UserEntity> findById(int id);
	List<UserEntity> findByUsername(String username);
	void persist(UserEntity user);
	void delete(UserEntity user);
}
