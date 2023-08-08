package com.example.demo.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.EmployeeService;


@Service
public  class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;

	  //get all employee
	
	@Override
	public List<Employee> getAllEmployees() {
		
		return this.employeeRepository.findAll();
	}

	//save employee
	
	@Override
	public Employee saveEmployee(Employee employee) {
		return this.employeeRepository.save(employee);
		
	}
	
	//get employee by id

	@Override
	public Employee getEmployeeById(long id) {
		Optional<Employee> optional=employeeRepository.findById(id);
		Employee employee=null;
		if(optional.isPresent()) {
			employee=optional.get();
		}else {
			throw new ResourceNotFoundException("employee not found for id ::"+id);
		}
		return employee;
	}
	
	
	
	//delete employee

	@Override
	public void deleteEmployeeById(long id) {
		if(!employeeRepository.existsById(id)) {
			throw new ResourceNotFoundException("Employee with id "+id+" not found");
		}
		this.employeeRepository.deleteById(id);
		
		
	}
	
	//update employee

	@Override
	public Employee updateEmployeeById(long id , Employee employee) {
		Employee employee2=employeeRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Employee with id "+id+" not found"));
		employee2.setFirstName(employee.getFirstName());
		employee2.setLastName(employee.getLastName());
		employee2.setEmailId(employee.getEmailId());
		
		return employeeRepository.save(employee2);
	}
	


	
	}

	
	
	

