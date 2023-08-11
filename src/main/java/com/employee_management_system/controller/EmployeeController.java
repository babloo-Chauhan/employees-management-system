package com.employee_management_system.controller;

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

import com.employee_management_system.model.EmployeeDTO;
import com.employee_management_system.service.EmployeeService;

import jakarta.validation.Valid;

@RestController
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;

	// get all employee

	@GetMapping("/employee")
	public List<EmployeeDTO> getAllEmployee() {
		return employeeService.getAllEmployees();
	}

	// create employee

	@PostMapping("/employee")
	public ResponseEntity<EmployeeDTO> createEmployee(@Valid @RequestBody EmployeeDTO employeeDTO) {
		EmployeeDTO employee2 = employeeService.saveEmployee(employeeDTO);
		return new ResponseEntity<>(employee2, HttpStatus.CREATED);
	}

	// get employee by id

	@GetMapping("/employee/{id}")
	public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable Long id) {
		EmployeeDTO employee = employeeService.getEmployeeById(id);

		return ResponseEntity.ok(employee);
	}

	// update employee rest

	@PutMapping("/employee/{id}")
	public ResponseEntity<EmployeeDTO> updateEmployee(@Valid @PathVariable long id, @RequestBody EmployeeDTO employee) {
		EmployeeDTO employeeUpdated = employeeService.updateEmployeeById(id, employee);
		return ResponseEntity.ok(employeeUpdated);

	}

	// delete employee

	@DeleteMapping("/employee/{id}")
	public ResponseEntity<?> deleteEmployee(@PathVariable Long id) {
		employeeService.deleteEmployeeById(id);
		return ResponseEntity.noContent().build();
	}
}
