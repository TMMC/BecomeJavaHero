package pl.edu.bogdan.training.jsf.db;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;


import pl.edu.bogdan.training.jsf.db.entity.Author;
import pl.edu.bogdan.training.jsf.db.entity.Book;
import pl.edu.bogdan.training.jsf.db.entity.Category;

@ManagedBean(name="bookService", eager=true)
public class JPABookService implements IBookService {

	@Override
	public List<Book> getAllBooks() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pl.edu.bogdan.training.db.entity");
		EntityManager em = entityManagerFactory.createEntityManager();
		
		// begining of transaction
		em.getTransaction().begin();
		Query query = em.createQuery("Select b from Book b");
		return query.getResultList();
	}

	@Override
	public List<Book> getBooksOfAuthorWithId(int id) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pl.edu.bogdan.training.db.entity");
		EntityManager em = entityManagerFactory.createEntityManager();
		
		// begining of transaction
		em.getTransaction().begin();
		Author author = em.find(Author.class, id);
		System.out.println(author.toString());
		for (Book b : author.getBooks()) {
			System.out.println(b.toString());
		}
		return author == null ? new ArrayList<Book>() : author.getBooks();
	}


	private String categoryId;
	
	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public List<Book> getBooksByCategory() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pl.edu.bogdan.training.db.entity");
		EntityManager em = entityManagerFactory.createEntityManager();
		
		// begining of transaction
		em.getTransaction().begin();
		Category category = em.find(Category.class, Integer.parseInt(categoryId));
		return category.getBooks();
	}

}
