package com.employee_management_system.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee_management_system.entities.Project;
import com.employee_management_system.exception.ResourceNotFoundException;
import com.employee_management_system.model.ProjectDTO;
import com.employee_management_system.repository.ProjectRepository;
import com.employee_management_system.service.ProjectService;

@Service
public class ProjectServiceImpl implements ProjectService {
	@Autowired
	private ProjectRepository projectRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public List<ProjectDTO> getAllProject() {
		// TODO Auto-generated method stub
		List<Project> projects = this.projectRepository.findAll();
		List<ProjectDTO> projectDTOs = projects.stream().map(e -> this.ProjectToDTO(e)).collect(Collectors.toList());
		return projectDTOs;

	}

	// create Project

	@Override
	public ProjectDTO saveProject(ProjectDTO projectDTO) {
		// TODO Auto-generated method stub
		Project project = this.dtoToProject(projectDTO);
		Project savepProject = projectRepository.save(project);
		return this.ProjectToDTO(savepProject);

	}

	// get project by id

	@Override
	public ProjectDTO getProjectById(long id) {
		// TODO Auto-generated method stub
		Project project = this.projectRepository.findById((int) id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee with id " + id + " not found"));
		return this.ProjectToDTO(project);

	}

	@Override
	public void deleteProjectById(long id) {
		// TODO Auto-generated method stub
		Project project = this.projectRepository.findById((int) id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee with id " + id + " not found"));
		this.projectRepository.delete(project);

	}

	@Override
	public ProjectDTO updateProjectById(long id, ProjectDTO projectDTO) {
		// TODO Auto-generated method stub
		Project project = this.projectRepository.findById((int) id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee with id " + id + " not found"));
		project.setProjectNumber(projectDTO.getProjectNumber());
		project.setProjectName(projectDTO.getProjectName());
		project.setProjectLocation(projectDTO.getProjectLocation());
		Project updatedProject = this.projectRepository.save(project);
		ProjectDTO projectDTO2 = this.ProjectToDTO(updatedProject);
		return projectDTO2;
	}

	// Project to DTO Converter

	public Project dtoToProject(ProjectDTO projectDTO) {

		Project project = this.modelMapper.map(projectDTO, Project.class);
		return project;
	}

	// DTO to Project converter

	public ProjectDTO ProjectToDTO(Project project) {
		ProjectDTO projectDTO = this.modelMapper.map(project, ProjectDTO.class);
		return projectDTO;
	}

}
