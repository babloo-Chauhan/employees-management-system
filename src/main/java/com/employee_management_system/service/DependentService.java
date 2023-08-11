package com.employee_management_system.service;

import java.util.List;

import com.employee_management_system.model.DependentDTO;

public interface DependentService {
	List<DependentDTO> getAllDependent();

	DependentDTO saveDependent(DependentDTO dependentDTO);

	DependentDTO getDependentById(long id);

	void deleteDependentById(long id);

	DependentDTO updateDependentById(long id, DependentDTO dependentDTO);

}
