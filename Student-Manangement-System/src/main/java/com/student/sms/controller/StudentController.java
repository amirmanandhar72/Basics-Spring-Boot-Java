package com.student.sms.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.student.sms.model.Student;
import com.student.sms.service.StudentService;

@Controller
public class StudentController {
	
	private StudentService studentService;

	public StudentController(StudentService studentService) {
		super();
		this.studentService = studentService;
	}
	@GetMapping("/students")
	public String studentList(Model model) {
		List<Student> students=studentService.getAllStudents();
		model.addAttribute("students",students);
		return "students";
		
	}
	@GetMapping("/students/create")
	public String create(Model model) {
		Student student = new Student();
		model.addAttribute("student",student);
		return "create";
	}
	
	@PostMapping("/students")
	public String store(@ModelAttribute("student") Student student) {
		studentService.store(student);
		return "redirect:/students";
		
	}
	@GetMapping("/students/edit/{id}")
	public String edit(@PathVariable Long id, Model model) {
		model.addAttribute("student",studentService.getStudentById(id));
		return "edit";
		
	}
	@PostMapping("/students/edit/{id}")
		public String update(@PathVariable Long id,@ModelAttribute("student") Student student, Model model) {
		
		Student existing = studentService.getStudentById(id);
		existing.setId(id);
		existing.setFirstName(student.getFirstName());
		existing.setLastName(student.getLastName());
		existing.setEmail(student.getEmail());
		
		studentService.update(existing);
		return "redirect:/students";
		
	}
	@GetMapping("/students/delete/{id}")
	public String destroy(@PathVariable Long id) {
		studentService.destroy(id);
		return "redirect:/students";
		
	}
	

}
