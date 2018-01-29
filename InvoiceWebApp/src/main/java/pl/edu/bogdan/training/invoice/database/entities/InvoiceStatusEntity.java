package pl.edu.bogdan.training.invoice.database.entities;

public class InvoiceStatusEntity {
	private int id;
	private String name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "InvoiceStatus [id=" + id + ", name=" + name + "]";
	}
}
