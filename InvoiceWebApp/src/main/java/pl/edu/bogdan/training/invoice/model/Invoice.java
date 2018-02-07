package pl.edu.bogdan.training.invoice.model;

import java.time.LocalDateTime;
import java.util.List;

public class Invoice {
	private int id;
	private User client;
	private User seller;
	private LocalDateTime date;
	private String number;
	private InvoiceStatus status;
	private List<Position> positions;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public User getClient() {
		return client;
	}
	public void setClient(User client) {
		this.client = client;
	}
	public User getSeller() {
		return seller;
	}
	public void setSeller(User seller) {
		this.seller = seller;
	}
	public LocalDateTime getDate() {
		return date;
	}
	public void setDate(LocalDateTime date) {
		this.date = date;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public InvoiceStatus getStatus() {
		return status;
	}
	public void setStatus(InvoiceStatus status) {
		this.status = status;
	}
	public List<Position> getPositions() {
		return positions;
	}
	public void setPositions(List<Position> positions) {
		this.positions = positions;
	}
	public Invoice() {}
	public Invoice(int id, User client, User seller, LocalDateTime date, String number, InvoiceStatus status,
			List<Position> positions) {
		super();
		this.id = id;
		this.client = client;
		this.seller = seller;
		this.date = date;
		this.number = number;
		this.status = status;
		this.positions = positions;
	}
	@Override
	public String toString() {
		return "Invoice [id=" + id + ", client=" + client + ", seller=" + seller + ", date=" + date + ", number="
				+ number + ", status=" + status + ", positions=" + positions + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((client == null) ? 0 : client.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + id;
		result = prime * result + ((number == null) ? 0 : number.hashCode());
		result = prime * result + ((positions == null) ? 0 : positions.hashCode());
		result = prime * result + ((seller == null) ? 0 : seller.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
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
		Invoice other = (Invoice) obj;
		if (client == null) {
			if (other.client != null)
				return false;
		} else if (!client.equals(other.client))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (id != other.id)
			return false;
		if (number == null) {
			if (other.number != null)
				return false;
		} else if (!number.equals(other.number))
			return false;
		if (positions == null) {
			if (other.positions != null)
				return false;
		} else if (!positions.equals(other.positions))
			return false;
		if (seller == null) {
			if (other.seller != null)
				return false;
		} else if (!seller.equals(other.seller))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}
}
