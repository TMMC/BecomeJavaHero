package pl.edu.bogdan.training.jsf.db.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Table(name="kategorie", schema="public")
@Entity
public class Category {
	@Id
	@Column(name="id_kategoria")
	private int id;
	
	@Column(name="nazwa")
	private String name;
	
	@OneToMany(targetEntity = Book.class, mappedBy="category", fetch=FetchType.LAZY)
	private List<Book> books;

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

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public Category(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public Category() {}
	
}
