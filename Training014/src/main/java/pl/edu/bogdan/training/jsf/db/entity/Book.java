package pl.edu.bogdan.training.jsf.db.entity;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="ksiazki", schema="public")
@ManagedBean(name="book", eager=true)
@RequestScoped
public class Book {
	@Id
	@Column(name="id_ksiazka")
	private int id;
	
	@Column(name="tytul")
	private String title;
	
	@ManyToOne(targetEntity=Author.class)
	@JoinColumn(name="id_autor")
	private Author author;
	
	@ManyToOne(targetEntity=Category.class)
	@JoinColumn(name="id_kategoria")
	private Category category;
	
	@ManyToOne(targetEntity=Publisher.class)
	@JoinColumn(name="id_wydawnictwo")
	private Publisher publisher;
	
	@Column(name="isbn")
	private String isbn;
	
	@Column(name="opis")
	private String description;
	
	@Column(name="rok_wydania")
	private int year;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Author getAuthor() {
		return author;
	}
	public void setAuthor(Author author) {
		this.author = author;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public Publisher getPublisher() {
		return publisher;
	}
	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public Book(int id, String title, Author author) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
	}
	public Book() {}
	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", author=" + author + "]";
	}
	
}
