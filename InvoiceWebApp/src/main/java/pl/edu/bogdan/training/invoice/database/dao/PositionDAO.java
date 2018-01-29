package pl.edu.bogdan.training.invoice.database.dao;

import java.util.List;

import pl.edu.bogdan.training.invoice.database.entities.PositionEntity;

public interface PositionDAO {
	List<PositionEntity> findAll();
	List<PositionEntity> findById(int id);
}
