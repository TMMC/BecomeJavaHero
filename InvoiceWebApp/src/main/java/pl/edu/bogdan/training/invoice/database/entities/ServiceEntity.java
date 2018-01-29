package pl.edu.bogdan.training.invoice.database.entities;

public class ServiceEntity {
	private int id;
	private String name;
	private String unit;
	private double priceForUnit;
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
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public double getPriceForUnit() {
		return priceForUnit;
	}
	public void setPriceForUnit(double priceForUnit) {
		this.priceForUnit = priceForUnit;
	}
	@Override
	public String toString() {
		return "Service [id=" + id + ", name=" + name + ", unit=" + unit + ", priceForUnit=" + priceForUnit + "]";
	}
}
