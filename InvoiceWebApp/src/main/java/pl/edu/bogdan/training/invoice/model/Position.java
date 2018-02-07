package pl.edu.bogdan.training.invoice.model;

public class Position {
	private int id;
	private int amount;
	private Service service;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public Service getService() {
		return service;
	}
	public void setService(Service service) {
		this.service = service;
	}
	public Position() {}
	public Position(int id, int amount, Service service) {
		super();
		this.id = id;
		this.amount = amount;
		this.service = service;
	}
	@Override
	public String toString() {
		return "Position [id=" + id + ", amount=" + amount + ", service=" + service + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + amount;
		result = prime * result + id;
		result = prime * result + ((service == null) ? 0 : service.hashCode());
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
		Position other = (Position) obj;
		if (amount != other.amount)
			return false;
		if (id != other.id)
			return false;
		if (service == null) {
			if (other.service != null)
				return false;
		} else if (!service.equals(other.service))
			return false;
		return true;
	}
}
