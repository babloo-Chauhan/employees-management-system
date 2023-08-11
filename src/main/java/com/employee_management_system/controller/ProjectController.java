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

import com.employee_management_system.model.ProjectDTO;
import com.employee_management_system.service.ProjectService;

import jakarta.validation.Valid;

@RestController
public class ProjectController {
	
	@Autowired
	private ProjectService projectService;
	
	// get all project

		@GetMapping("/project")
		public List<ProjectDTO> getAllProject() {
			return projectService.getAllProject();
		}

		// create project

		@PostMapping("/project")
		public ResponseEntity<ProjectDTO> createProject(@Valid @RequestBody ProjectDTO projectDTO) {
			ProjectDTO project2 = projectService.saveProject(projectDTO);
			return new ResponseEntity<>(project2, HttpStatus.CREATED);
		}

		// get project by id

		@GetMapping("/project/{id}")
		public ResponseEntity<ProjectDTO> getProjectById(@PathVariable Long id) {
			ProjectDTO project = projectService.getProjectById(id);

			return ResponseEntity.ok(project);
		}

		// update project rest

		@PutMapping("/project/{id}")
		public ResponseEntity<ProjectDTO> updateProject(@Valid @PathVariable long id, @RequestBody ProjectDTO project) {
			ProjectDTO projectUpdated = projectService.updateProjectById(id, project);
			return ResponseEntity.ok(projectUpdated);

		}

		// delete project

		@DeleteMapping("/project/{id}")
		public ResponseEntity<?> deleteProject(@PathVariable Long id) {
			projectService.deleteProjectById(id);
			return ResponseEntity.noContent().build();
		}

}
