package com.springboot.demospringboot;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {
	
	// Get Http method
	@GetMapping("/hello")
	public String helloWorld() {
		return "Hello World";
	}

}
