package pl.edu.bogdan.training.springmvc.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Greeter {
	@RequestMapping("/greeting")
	public String greeting(
			@RequestParam(value = "name", required = false, defaultValue = "World") 
			String name, 
			Model model) {
		model.addAttribute("name", name);
		return "greeting";
	}
	
	@RequestMapping("/hello/{foo}/{bar}")
	public String hello(
			@PathVariable(name="foo") String foo,
			@PathVariable(name="bar") int bar,
			Model model) {
		model.addAttribute("foo", foo.toUpperCase());
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i <= bar; i++) {
			list.add(i);
		}
		model.addAttribute("bar", list);
		
		return "hello" ;
	}
}
