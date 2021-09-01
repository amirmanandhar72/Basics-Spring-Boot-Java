package com.springboot.demospringboot;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
	@GetMapping("/student")
	public Student getStudent() {
		return new Student("Amir","Manandhar");
	}
	@GetMapping("/lists")
	public List<Student> getStudents(){
		
		List<Student> students =new ArrayList<>();
		students.add(new Student("hari","bahadur"));
		System.out.println(students);
		students.add(new Student("ram","bahadur"));
		students.add(new Student("kisan","bahadur"));
		students.add(new Student("nonu","mina"));
		students.add(new Student("lila","ras"));
		return students;
		
		
	}
	@GetMapping("{firstName}/{lastName}")
	public Student studentinfo(@PathVariable("firstName") String firstName ,@PathVariable("lastName")String lastName) {
		return new Student(firstName,lastName);
	}
	
	//build  rest API to handle query parameters 
	@GetMapping("/students")
	public Student studentQueryParam(@RequestParam(name="firstName1") String firstName, @RequestParam(name="lastName") String lastName) {
		return new Student(firstName,lastName);
		
	}
	

}
