package pl.edu.bogdan.training.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pl.edu.bogdan.training.db.IAuthorService;
import pl.edu.bogdan.training.db.entity.Author;


@Controller
public class Greeter {
	
	IAuthorService authorService;
	
	@Autowired
	public void setAuthorService(IAuthorService authorService) {
		this.authorService = authorService;
	}

	@RequestMapping("/greeting")
	public String greeting(@RequestParam(value = "name", required = false, defaultValue = "World") String name, Model model) {
		model.addAttribute("name", name);
		return "greeting";
	}
	
	@RequestMapping("/authors/all")
	public String getAllAuthors(Model model) {
		List<Author> authors = authorService.getAllAuthors();
		model.addAttribute("authors", authors);
		return "all_authors";
	}
}
