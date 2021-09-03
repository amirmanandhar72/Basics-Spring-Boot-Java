package com.spring.crud.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.spring.crud.exception.ResourceNotFoundException;
import com.spring.crud.model.Employee;
import com.spring.crud.repository.EmployeeRepository;
import com.spring.crud.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	private EmployeeRepository employeeRepository;
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}
	@Override
	public Employee saveEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return employeeRepository.save(employee);
	}
	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}
	@Override
	public Employee getEmployeeById(long id) {
		// TODO Auto-generated method stub
//		Optional<Employee> employee =employeeRepository.findById(id);
//		if(employee.isPresent()) {
//			return employee.get();
//		}else {
//			throw new ResourceNotFoundException("employee", "ID", id);
//		}
		return employeeRepository.findById(id).orElseThrow(()-> 
				new ResourceNotFoundException("employee", "ID", id));
	}
	@Override
	public Employee updateEmployee(Employee employee, long id) {
		//check if id exist in db
//		Employee existingEmployee=employeeRepository.findById(id).orElseThrow(()-> 
//		new ResourceNotFoundException("Employee", "ID", id));
//		employeeRepository.deleteById(id);
		return null;
	}
	@Override
	public void deleteEmployee(long id) {
		// TODO Auto-generated method stub
		employeeRepository.findById(id).orElseThrow(()-> 
		new ResourceNotFoundException("Employee", "ID", id));
		employeeRepository.deleteById(id);
		
	}	
	

}
