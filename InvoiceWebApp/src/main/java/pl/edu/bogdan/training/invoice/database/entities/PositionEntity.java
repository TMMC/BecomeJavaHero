package pl.edu.bogdan.training.invoice.database.entities;

public class PositionEntity {
	private int id;
	private InvoiceEntity invoice;
	private int amount;
	private ServiceEntity service;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public InvoiceEntity getInvoice() {
		return invoice;
	}
	public void setInvoice(InvoiceEntity invoice) {
		this.invoice = invoice;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public ServiceEntity getService() {
		return service;
	}
	public void setService(ServiceEntity service) {
		this.service = service;
	}
	@Override
	public String toString() {
		return "Position [id=" + id + ", invoice=" + invoice + ", amount=" + amount + ", service=" + service + "]";
	}
}
