package pl.edu.bogdan.training.invoice.database.entities;

import java.time.LocalDateTime;

public class InvoiceEntity {
	private int id;
	private UserEntity client;
	private UserEntity seller;
	private LocalDateTime date;
	private String number;
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
	@Override
	public String toString() {
		return "Invoice [id=" + id + ", client=" + client + ", seller=" + seller + ", date=" + date + ", number="
				+ number + "]";
	}
}
