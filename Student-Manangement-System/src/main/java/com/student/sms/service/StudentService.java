package com.student.sms.service;

import java.util.List;

import com.student.sms.model.Student;

public interface StudentService {

	List<Student> getAllStudents();
	Student store(Student student);
	Student getStudentById(Long id);
	Student update(Student student);
	void destroy(Long id);
}
