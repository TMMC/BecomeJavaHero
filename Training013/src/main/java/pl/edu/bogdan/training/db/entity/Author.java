package pl.edu.bogdan.training.db.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Table(name="autorzy", schema="public")
@Entity
public class Author {
	@Id
	@Column(name="id_autor")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	/*
	 * To zadziała jeżeli najpierw zmienimy bazę danych:
	 * CREATE SEQUENCE id_autor_seq;
	 * ALTER TABLE autorzy alter id_autor set default nextval('id_autor_seq');
	 * SELECT setval('id_autor_seq', mx.mx) from (SELECT MAX(id_autor) as mx from autorzy) mx;
	 */
	@Column(name="imie")
	private String firstName;
	@Column(name="nazwisko")
	private String lastName;
	@OneToMany(targetEntity = Book.class, mappedBy="author", fetch=FetchType.LAZY)
	private List<Book> books;
	public Author() {
		
	}
	public Author(int id, String firstName, String lastName) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public List<Book> getBooks() {
		return books;
	}
	public void setBooks(List<Book> books) {
		this.books = books;
	}
	@Override
	public String toString() {
		return "Author [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}
}
