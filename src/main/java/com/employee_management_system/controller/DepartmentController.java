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

import com.employee_management_system.model.DepartmentDTO;
import com.employee_management_system.service.DepartmentService;
import jakarta.validation.Valid;

@RestController
public class DepartmentController {
	@Autowired
	private DepartmentService departmentService;

	// get all department

	@GetMapping("/department")
	public List<DepartmentDTO> getAllDepartment() {
		return departmentService.getAllDepartment();
	}

	// create department

	@PostMapping("/department")
	public ResponseEntity<DepartmentDTO> createDepartment(@Valid @RequestBody DepartmentDTO departmentDTO) {
		DepartmentDTO department2 = departmentService.saveDepartment(departmentDTO);
		return new ResponseEntity<>(department2, HttpStatus.CREATED);
	}

	// get department by id

	@GetMapping("/department/{id}")
	public ResponseEntity<DepartmentDTO> getDepartmentById(@PathVariable Long id) {
		DepartmentDTO department = departmentService.getDepartmentById(id);

		return ResponseEntity.ok(department);
	}

	// update department rest

	@PutMapping("/department/{id}")
	public ResponseEntity<DepartmentDTO> updateDepartment(@Valid @PathVariable long id,
			@RequestBody DepartmentDTO department) {
		DepartmentDTO departmentUpdated = departmentService.updateDepartmentById(id, department);
		return ResponseEntity.ok(departmentUpdated);

	}

	// delete department

	@DeleteMapping("/department/{id}")
	public ResponseEntity<?> deleteDepartment(@PathVariable Long id) {
		departmentService.deleteDepartmentById(id);
		return ResponseEntity.noContent().build();
	}

}
