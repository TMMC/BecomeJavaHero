package pl.edu.bogdan.training.invoice.database.entities;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "invoices", uniqueConstraints = { @UniqueConstraint(columnNames = { "number" }) })
public class InvoiceEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@ManyToOne(targetEntity = UserEntity.class, fetch = FetchType.EAGER, optional = false)
	@JoinColumn
	private UserEntity client;

	@ManyToOne(targetEntity = UserEntity.class, fetch = FetchType.EAGER, optional = false)
	@JoinColumn
	private UserEntity seller;

	@NotNull
	private LocalDateTime date;

	@NotNull
	private String number;

	@ManyToOne(targetEntity = InvoiceStatusEntity.class, fetch = FetchType.EAGER, optional = false)
	@JoinColumn
	private InvoiceStatusEntity status;

	@OneToMany(targetEntity = PositionEntity.class, fetch = FetchType.LAZY, mappedBy = "invoice", cascade = CascadeType.REMOVE)
	private List<PositionEntity> positions;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public UserEntity getClient() {
		return client;
	}

	public void setClient(UserEntity client) {
		this.client = client;
	}

	public UserEntity getSeller() {
		return seller;
	}

	public void setSeller(UserEntity seller) {
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

	public InvoiceStatusEntity getStatus() {
		return status;
	}

	public void setStatus(InvoiceStatusEntity status) {
		this.status = status;
	}

	public List<PositionEntity> getPositions() {
		return positions;
	}

	public void setPositions(List<PositionEntity> positions) {
		this.positions = positions;
	}

	@Override
	public String toString() {
		return "Invoice [id=" + id + ", client=" + client + ", seller=" + seller + ", date=" + date + ", number="
				+ number + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((client == null) ? 0 : client.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + id;
		result = prime * result + ((number == null) ? 0 : number.hashCode());
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
		InvoiceEntity other = (InvoiceEntity) obj;
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
