package com.employee_management_system.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee_management_system.entities.Department;
import com.employee_management_system.exception.ResourceNotFoundException;
import com.employee_management_system.repository.DepartmentRepository;
import com.employee_management_system.model.DepartmentDTO;
import com.employee_management_system.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private DepartmentRepository departmentRepository;

	// get all department

	@Override
	public List<DepartmentDTO> getAllDepartment() {
		List<Department> departments = this.departmentRepository.findAll();
		List<DepartmentDTO> departmentDTOs = departments.stream().map(e -> this.departmentToDTO(e))
				.collect(Collectors.toList());
		return departmentDTOs;

	}

	// create department

	@Override
	public DepartmentDTO saveDepartment(DepartmentDTO departmentDTO) {
		Department department = this.dtoToDepartment(departmentDTO);
		Department saveDepartment = departmentRepository.save(department);
		return this.departmentToDTO(saveDepartment);

	}

	// get department by id

	@Override
	public DepartmentDTO getDepartmentById(long id) {
		Department department = this.departmentRepository.findById((int) id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee with id " + id + " not found"));
		return this.departmentToDTO(department);

	}

	// delete department by id

	@Override
	public void deleteDepartmentById(long id) {
		Department department = this.departmentRepository.findById((int) id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee with id " + id + " not found"));
		this.departmentRepository.delete(department);

	}

	// update employee

	@Override
	public DepartmentDTO updateDepartmentById(long id, DepartmentDTO departmentDTO) {

		Department department = this.departmentRepository.findById((int) id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee with id " + id + " not found"));
		department.setDepartmentId(departmentDTO.getDepartmentId());
		department.setDepartmentName(departmentDTO.getDepartmentName());
		department.setDepartmentLocation(departmentDTO.getDepartmentLocation());
		Department updatedDepartment = this.departmentRepository.save(department);
		DepartmentDTO departmentDTO2 = this.departmentToDTO(updatedDepartment);
		return departmentDTO2;
	}

	// Department to DTO Converter

	public Department dtoToDepartment(DepartmentDTO departmentDTO) {

		Department department = this.modelMapper.map(departmentDTO, Department.class);
		return department;
	}

	// DTO to Department converter

	public DepartmentDTO departmentToDTO(Department department) {
		DepartmentDTO departmentDTO = this.modelMapper.map(department, DepartmentDTO.class);
		return departmentDTO;
	}

}
