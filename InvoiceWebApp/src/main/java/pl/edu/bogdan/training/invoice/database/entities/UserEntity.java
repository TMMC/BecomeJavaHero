package pl.edu.bogdan.training.invoice.database.entities;

public class UserEntity {
	private int id;
	private String username;
	private String password;
	private String address;
	private String name;
	private UserTypeEntity userType;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public UserTypeEntity getUserType() {
		return userType;
	}
	public void setUserType(UserTypeEntity userType) {
		this.userType = userType;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", address=" + address
				+ ", name=" + name + ", userType=" + userType + "]";
	}
}
