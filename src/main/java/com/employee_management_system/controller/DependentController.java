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

import com.employee_management_system.model.DependentDTO;
import com.employee_management_system.service.DependentService;

import jakarta.validation.Valid;

@RestController
public class DependentController {
	@Autowired
	private DependentService dependentService;
	
	// get all dependent

		@GetMapping("/dependent")
		public List<DependentDTO> getAllDependent() {
			return dependentService.getAllDependent();
		}

		// create dependent

		@PostMapping("/dependent")
		public ResponseEntity<DependentDTO> createDependent(@Valid @RequestBody DependentDTO dependentDTO) {
			DependentDTO dependent2 = dependentService.saveDependent(dependentDTO);
			return new ResponseEntity<>(dependent2, HttpStatus.CREATED);
		}

		// get dependent by id

		@GetMapping("/dependent/{id}")
		public ResponseEntity<DependentDTO> getDependentById(@PathVariable Long id) {
			DependentDTO dependent = dependentService.getDependentById(id);

			return ResponseEntity.ok(dependent);
		}

		// update dependent rest

		@PutMapping("/dependent/{id}")
		public ResponseEntity<DependentDTO> updateDependent(@Valid @PathVariable long id, @RequestBody DependentDTO dependent) {
			DependentDTO dependentUpdated = dependentService.updateDependentById(id, dependent);
			return ResponseEntity.ok(dependentUpdated);

		}

		// delete dependent

		@DeleteMapping("/dependent/{id}")
		public ResponseEntity<?> deleteDependent(@PathVariable Long id) {
			dependentService.deleteDependentById(id);
			return ResponseEntity.noContent().build();
		}

}
