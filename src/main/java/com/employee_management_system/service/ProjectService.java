package com.employee_management_system.service;

import java.util.List;

import com.employee_management_system.model.ProjectDTO;

public interface ProjectService {
	List<ProjectDTO> getAllProject();

	ProjectDTO saveProject(ProjectDTO projectDTO);

	ProjectDTO getProjectById(long id);

	void deleteProjectById(long id);

	ProjectDTO updateProjectById(long id, ProjectDTO projectDTO);

}
