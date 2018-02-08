package pl.edu.bogdan.training.invoice.beans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import pl.edu.bogdan.training.invoice.database.dao.InvoiceDAO;
import pl.edu.bogdan.training.invoice.database.dao.impl.jpa.InvoiceDAOImpl;
import pl.edu.bogdan.training.invoice.database.entities.InvoiceEntity;

@ManagedBean(name="dataset")
@RequestScoped
public class DatasetBean {
	@ManagedProperty(value="#{invoiceDao}")
	private InvoiceDAO invoiceDao;
	private List<InvoiceEntity> allInvoices;
	public InvoiceDAO getInvoiceDao() {
		return invoiceDao;
	}
	public void setInvoiceDao(InvoiceDAO invoiceDao) {
		this.invoiceDao = invoiceDao;
	}
	public List<InvoiceEntity> getAllInvoices() {
		if (allInvoices == null) {
			allInvoices = invoiceDao.findAll();
		}
		return allInvoices;
	}
	public void setAllInvoices(List<InvoiceEntity> allInvoices) {
		this.allInvoices = allInvoices;
	}
}
