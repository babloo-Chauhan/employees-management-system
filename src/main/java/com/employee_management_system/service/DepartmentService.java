package com.employee_management_system.service;

import java.util.List;

import com.employee_management_system.model.DepartmentDTO;

public interface DepartmentService {
	List<DepartmentDTO> getAllDepartment();

	DepartmentDTO saveDepartment(DepartmentDTO departmentDTO);

	DepartmentDTO getDepartmentById(long id);

	void deleteDepartmentById(long id);

	DepartmentDTO updateDepartmentById(long id, DepartmentDTO departmentDTO);

}
