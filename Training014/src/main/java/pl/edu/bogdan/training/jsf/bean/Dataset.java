package pl.edu.bogdan.training.jsf.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "dataset", eager = true)
@SessionScoped
public class Dataset {
	private List<Person> persons;
	
	public Dataset() {
		persons = new ArrayList<>();
		persons.add(new Person("Pawe³", "Bogdan", 28));
		persons.add(new Person("Adam", "Mickiewicz", 44));
		persons.add(new Person("Juliusz", "S³owacki", 33));
	}

	public List<Person> getPersons() {
		return persons;
	}

	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}
	
	
}
