package pl.edu.bogdan.training.prime.faces.model.services;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import pl.edu.bogdan.training.prime.faces.db.dao.AuthorDAO;
import pl.edu.bogdan.training.prime.faces.db.entities.AuthorEntity;
import pl.edu.bogdan.training.prime.faces.model.objects.Author;

@ManagedBean(name="authorService", eager=true)
@SessionScoped
public class AuthorServiceImpl implements AuthorService {
	
	@ManagedProperty(value="#{authorDAO}")
	private AuthorDAO authorDAO;
	
	public List<Author> findAll() {
		List<Author> result = new ArrayList<>();
		for (AuthorEntity entity: authorDAO.findAll()) {
			result.add(fromEntity(entity));
		}
		return result;
	}

	public Author findById(int id) {
		List<AuthorEntity> entities = authorDAO.findById(id);
		if (entities.size() == 1) {
			return fromEntity(entities.get(0));
		}
		return null;
	}

	public static Author fromEntity(AuthorEntity entity) {
		return new Author(entity.getId(), entity.getFirstName(), entity.getLastName());
	}
	
	public static AuthorEntity toEntity(Author author) {
		return new AuthorEntity(author.getId(), author.getFirstName(), author.getLastName());
	}
	
	public void setAuthorDAO(AuthorDAO authorDAO) {
		this.authorDAO = authorDAO;
	}
	
	

}
