package pl.edu.bogdan.training.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pl.edu.bogdan.training.db.model.IAuthorService;

@Controller
public class Greeter {
	
	IAuthorService authorService;
	
	@RequestMapping("/greeting")
	public String greeting(@RequestParam(value = "name", required = false, defaultValue = "World") String name, Model model) {
		model.addAttribute("name", name);
		return "greeting";
	}
	
	@RequestMapping("/authors/all")
	public String getAllAuthors(Model model) {
		model.addAttribute("authors", authorService.getAllAuthors());
		return "all_authors";
	}
}
