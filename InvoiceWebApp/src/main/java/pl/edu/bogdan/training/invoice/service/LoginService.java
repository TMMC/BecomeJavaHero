package pl.edu.bogdan.training.invoice.service;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import pl.edu.bogdan.training.invoice.beans.CredentialsBean;
import pl.edu.bogdan.training.invoice.database.dao.UserDAO;
import pl.edu.bogdan.training.invoice.database.entities.UserEntity;

@ManagedBean(name="loginService")
@SessionScoped
public class LoginService {
	
	@ManagedProperty(value="#{userDao}")
	private UserDAO userDAO;
	
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public boolean isCredentialOk(CredentialsBean credential) {
		List<UserEntity> listOfUsers = userDAO.findByUsername(credential.getUsername());
		if (listOfUsers.size() != 1) {
			return false;
		}
		UserEntity user = listOfUsers.get(0);
		System.out.println(user);
		return user.getPassword().equals(credential.getPassword());
	}
}
