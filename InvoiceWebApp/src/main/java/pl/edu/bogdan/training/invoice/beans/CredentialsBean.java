package pl.edu.bogdan.training.invoice.beans;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import pl.edu.bogdan.training.invoice.service.LoginService;

@ManagedBean(name="credential")
@SessionScoped
public class CredentialsBean {
	private String username;
	private String password;
	
	@ManagedProperty(value="#{loginService}")
	private LoginService loginService;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public LoginService getLoginService() {
		return loginService;
	}
	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}
	public String login() throws NoSuchAlgorithmException {
		System.out.println("JESTEM TUTAJ");
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(password.getBytes());
		Base64.Encoder encoder = Base64.getEncoder();
		password = encoder.encodeToString(md.digest());
		
		return "";
	}
}
