package pl.edu.bogdan.training.prime.faces.db.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="ksiazki", schema="public")
public class BookEntity {
	@Id
	@Column(name="id_ksiazka")
	private int id;
	
	@Column(name="tytul")
	private String title;
	
	@ManyToOne(targetEntity=AuthorEntity.class)
	@JoinColumn(name="id_autor")
	private AuthorEntity author;
	
	@ManyToOne(targetEntity=CategoryEntity.class)
	@JoinColumn(name="id_kategoria")
	private CategoryEntity category;
	
	@ManyToOne(targetEntity=PublisherEntity.class)
	@JoinColumn(name="id_wydawnictwo")
	private PublisherEntity publisher;
	
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
	public AuthorEntity getAuthor() {
		return author;
	}
	public void setAuthor(AuthorEntity author) {
		this.author = author;
	}
	public CategoryEntity getCategory() {
		return category;
	}
	public void setCategory(CategoryEntity category) {
		this.category = category;
	}
	public PublisherEntity getPublisher() {
		return publisher;
	}
	public void setPublisher(PublisherEntity publisher) {
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
	public BookEntity(int id, String title, AuthorEntity author, CategoryEntity category, PublisherEntity publisher,
			String isbn, String description, int year) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.category = category;
		this.publisher = publisher;
		this.isbn = isbn;
		this.description = description;
		this.year = year;
	}
	public BookEntity() {}
	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", author=" + author + "]";
	}
	
}
