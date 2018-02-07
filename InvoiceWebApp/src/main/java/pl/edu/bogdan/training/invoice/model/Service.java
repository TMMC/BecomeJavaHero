package pl.edu.bogdan.training.invoice.model;

public class Service {
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
	public Service() {}
	public Service(int id, String name, String unit, double priceForUnit) {
		super();
		this.id = id;
		this.name = name;
		this.unit = unit;
		this.priceForUnit = priceForUnit;
	}
	@Override
	public String toString() {
		return "Service [id=" + id + ", name=" + name + ", unit=" + unit + ", priceForUnit=" + priceForUnit + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		long temp;
		temp = Double.doubleToLongBits(priceForUnit);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((unit == null) ? 0 : unit.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Service other = (Service) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (Double.doubleToLongBits(priceForUnit) != Double.doubleToLongBits(other.priceForUnit))
			return false;
		if (unit == null) {
			if (other.unit != null)
				return false;
		} else if (!unit.equals(other.unit))
			return false;
		return true;
	}
}
