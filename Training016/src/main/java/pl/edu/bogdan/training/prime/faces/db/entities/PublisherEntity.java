package pl.edu.bogdan.training.prime.faces.db.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="wydawnictwa", schema="public")
public class PublisherEntity {
	@Id
	@Column(name="id_wydawnictwo")
	private int id;
	
	@Column(name="nazwa")
	private String name;
	
	@OneToMany(targetEntity = BookEntity.class, mappedBy="publisher", fetch=FetchType.LAZY)
	private List<BookEntity> books;

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

	public List<BookEntity> getBooks() {
		return books;
	}

	public void setBooks(List<BookEntity> books) {
		this.books = books;
	}

	public PublisherEntity(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public PublisherEntity() {}

	@Override
	public String toString() {
		return "Publisher [id=" + id + ", name=" + name + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		PublisherEntity other = (PublisherEntity) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
}
