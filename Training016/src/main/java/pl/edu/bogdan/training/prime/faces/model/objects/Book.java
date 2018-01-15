package pl.edu.bogdan.training.prime.faces.model.objects;

public class Book {
	private int id;
	private String title;
	private Author author;
	private Category category;
	private Publisher publisher;
	private String isbn;
	private String description;
	private int year;
	private boolean editable = false;
	public Book() {}
	public Book(int id, String title, Author author, Category category, Publisher publisher, String isbn,
			String description, int year) {
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
	public boolean isEditable() {
		return editable;
	}
	public void setEditable(boolean editable) {
		this.editable = editable;
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", author=" + author + ", category=" + category + ", publisher="
				+ publisher + ", isbn=" + isbn + ", description=" + description + ", year=" + year + ", editable="
				+ editable + "]";
	}
}
