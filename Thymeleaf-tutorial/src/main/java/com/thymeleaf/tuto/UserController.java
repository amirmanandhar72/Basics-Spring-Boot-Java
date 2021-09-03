package com.thymeleaf.tuto;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class UserController {
	
	@GetMapping("/if")
	public String users(Model model) {
		List<User> users=new ArrayList<>();
		users.add(new User("amir","amir@gmail.com","Admin"));
		users.add(new User("amir","aamir@gmail.com","user"));
		users.add(new User("amir","samir@gmail.com","user"));
		model.addAttribute("users",users);
		return "if-unless";
	}
@GetMapping("/switchhai")
public String switchexample(Model model){
	User user= new User("amir","manandhar","manager");
	model.addAttribute("user",user);
	return "switch";
	
}

	
}
