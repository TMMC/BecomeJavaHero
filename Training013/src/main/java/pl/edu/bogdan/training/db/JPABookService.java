package pl.edu.bogdan.training.db;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Service;

import pl.edu.bogdan.training.db.entity.Author;
import pl.edu.bogdan.training.db.entity.Book;

@Service
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

}
