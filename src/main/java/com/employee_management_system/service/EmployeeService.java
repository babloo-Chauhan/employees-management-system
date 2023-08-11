package com.employee_management_system.service;

import java.util.List;

import com.employee_management_system.model.EmployeeDTO;

public interface EmployeeService {
	List<EmployeeDTO> getAllEmployees();

	EmployeeDTO saveEmployee(EmployeeDTO employeeDTO);

	EmployeeDTO getEmployeeById(long id);

	void deleteEmployeeById(long id);

	EmployeeDTO updateEmployeeById(long id, EmployeeDTO employeeDTO);

}
