package pl.edu.bogdan.training.jsf.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import pl.edu.bogdan.training.jsf.db.entity.Category;

@ManagedBean(name = "person", eager = true)
@RequestScoped
public class Person implements Serializable {
	private String firstName;
	private String lastName;
	private int age;
	private int categoryId;
	private Category category;
	private boolean canEdit;
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		System.out.println("Setting firstname: " + firstName);
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		System.out.println("Setting lastname: " + lastName);
		this.lastName = lastName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		System.out.println("Setting age: " + age);
		this.age = age;
	}
	public boolean isCanEdit() {
		return canEdit;
	}
	public void setCanEdit(boolean canEdit) {
		this.canEdit = canEdit;
	}
	
	
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		System.out.println("Setting vategory: " + category);
		this.category = category;
	}
	public String action() {
		firstName = firstName.toUpperCase();
		lastName = lastName.toUpperCase();
		System.out.println(this.toString());
		return "person_page";
	}
	
	@Override
	public String toString() {
		return "Person [firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + ", categoryId="
				+ categoryId + ", category=" + category + ", canEdit=" + canEdit + "]";
	}
	public Person(String firstName, String lastName, int age) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}
	public Person() {}
	
	
}
