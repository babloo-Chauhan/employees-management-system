package com.example.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;


@RestController
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	
	
	//get all employee
	
	@GetMapping("/employee")
	public List<Employee> getAllEmployee(){
		return employeeService.getAllEmployees();
	}
	
	// create employee
	
	@PostMapping("/employee")
   public  ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
	Employee employee2	= employeeService.saveEmployee(employee);
	return new ResponseEntity<>(employee2,HttpStatus.CREATED);
   }
	
	
	// get employee by id 
	
		@GetMapping("/employee/{id}")
		public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
			Employee employee = employeeService.getEmployeeById(id);
					
			return ResponseEntity.ok(employee);
		}

	
		// update employee rest 
		
		@PutMapping("/employee/{id}")
		public ResponseEntity<Employee> updateEmployee(@PathVariable long id,@RequestBody Employee employee) {
			Employee employeeUpdated=employeeService.updateEmployeeById(id, employee);
			return ResponseEntity.ok(employeeUpdated);
					
		}
		
		
		// delete employee 
		
		@DeleteMapping("/employee/{id}")
		public ResponseEntity<?> deleteEmployee(@PathVariable Long id){
			 employeeService.deleteEmployeeById(id);
			 return ResponseEntity.noContent().build();
			 }
}

