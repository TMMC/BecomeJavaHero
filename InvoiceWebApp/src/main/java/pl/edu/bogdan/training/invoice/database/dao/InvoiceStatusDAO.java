package pl.edu.bogdan.training.invoice.database.dao;

import java.util.List;

import pl.edu.bogdan.training.invoice.database.entities.InvoiceStatusEntity;

public interface InvoiceStatusDAO {
	List<InvoiceStatusEntity> findAll();
	List<InvoiceStatusEntity> findById(int id);
}
