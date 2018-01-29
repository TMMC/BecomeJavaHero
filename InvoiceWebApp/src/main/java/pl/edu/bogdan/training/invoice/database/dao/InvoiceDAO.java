package pl.edu.bogdan.training.invoice.database.dao;

import java.util.List;

import pl.edu.bogdan.training.invoice.database.entities.InvoiceEntity;

public interface InvoiceDAO {
	List<InvoiceEntity> findAll();
	List<InvoiceEntity> findById(int id);
}
