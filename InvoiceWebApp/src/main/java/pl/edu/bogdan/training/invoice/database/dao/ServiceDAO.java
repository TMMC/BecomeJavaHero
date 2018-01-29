package pl.edu.bogdan.training.invoice.database.dao;

import java.util.List;

import pl.edu.bogdan.training.invoice.database.entities.ServiceEntity;

public interface ServiceDAO {
	List<ServiceEntity> findAll();
	List<ServiceEntity> findById(int id);
}
