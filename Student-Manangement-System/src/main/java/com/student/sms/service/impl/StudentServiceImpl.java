package com.student.sms.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.student.sms.model.Student;
import com.student.sms.repository.StudentRepository;
import com.student.sms.service.StudentService;
@Service
public class StudentServiceImpl implements StudentService{
	
	private StudentRepository studentRepository;
	
	public StudentServiceImpl(StudentRepository studentRepository) {
		super();
		this.studentRepository = studentRepository;
	}

	@Override
	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}

	@Override
	public Student store(Student student) {
		// TODO Auto-generated method stub
		return studentRepository.save(student);
	}

	@Override
	public Student getStudentById(Long id) {
		return studentRepository.findById(id).get();
	}

	@Override
	public Student update(Student student) {
		
		return studentRepository.save(student);
	}

	@Override
	public void destroy(Long id) {
		studentRepository.deleteById(id);
	
	}

		
	}

