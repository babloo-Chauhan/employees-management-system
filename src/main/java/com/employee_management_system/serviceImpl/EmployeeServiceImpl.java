package com.employee_management_system.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee_management_system.entities.Employee;
import com.employee_management_system.exception.ResourceNotFoundException;
import com.employee_management_system.model.EmployeeDTO;
import com.employee_management_system.repository.EmployeeRepository;
import com.employee_management_system.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;
	@Autowired
	private ModelMapper modelMapper;

	// get all employee

	@Override
	public List<EmployeeDTO> getAllEmployees() {

		List<Employee> employees = this.employeeRepository.findAll();
		List<EmployeeDTO> employeeDTOs = employees.stream().map(e -> this.employeeToDTO(e))
				.collect(Collectors.toList());
		return employeeDTOs;
	}

	// save employee

	@Override
	public EmployeeDTO saveEmployee(EmployeeDTO employeeDTO) {
		Employee employee = this.dtoToEmployee(employeeDTO);
		Employee saveEmployee = employeeRepository.save(employee);
		return this.employeeToDTO(saveEmployee);

	}

	// get employee by id

	@Override
	public EmployeeDTO getEmployeeById(long id) {

		Employee employee = this.employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee with id " + id + " not found"));
		return this.employeeToDTO(employee);
	}

	// delete employee

	@Override
	public void deleteEmployeeById(long id) {

		Employee employee = this.employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee with id " + id + " not found"));
		this.employeeRepository.delete(employee);

	}

	// update employee

	@Override
	public EmployeeDTO updateEmployeeById(long id, EmployeeDTO employeeDTO) {

		Employee employee = this.employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee with id " + id + " not found"));
		employee.setFirstName(employeeDTO.getFirstName());
		employee.setLastName(employeeDTO.getLastName());
		employee.setEmailId(employeeDTO.getEmailId());
		Employee updateEmployee = this.employeeRepository.save(employee);
		EmployeeDTO employeeDTO2 = this.employeeToDTO(updateEmployee);
		return employeeDTO2;
	}

	// Employee to DTO Converter

	public Employee dtoToEmployee(EmployeeDTO employeeDTO) {

		Employee employee = this.modelMapper.map(employeeDTO, Employee.class);
		return employee;
	}

	// DTO to Employee converter

	public EmployeeDTO employeeToDTO(Employee employee) {
		EmployeeDTO employeeDTO = this.modelMapper.map(employee, EmployeeDTO.class);
		return employeeDTO;
	}

}
