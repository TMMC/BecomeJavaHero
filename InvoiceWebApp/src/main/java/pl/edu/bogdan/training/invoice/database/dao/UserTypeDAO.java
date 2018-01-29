package pl.edu.bogdan.training.invoice.database.dao;

import java.util.List;

import pl.edu.bogdan.training.invoice.database.entities.UserTypeEntity;

public interface UserTypeDAO {
	List<UserTypeEntity> findAll();
	List<UserTypeEntity> findById(int id);
}
