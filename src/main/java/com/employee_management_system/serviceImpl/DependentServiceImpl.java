package com.employee_management_system.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee_management_system.entities.Dependent;
import com.employee_management_system.exception.ResourceNotFoundException;
import com.employee_management_system.model.DependentDTO;
import com.employee_management_system.repository.DependentRepository;
import com.employee_management_system.service.DependentService;

@Service
public class DependentServiceImpl implements DependentService {

	@Autowired
	private DependentRepository dependentRepository;

	@Autowired
	private ModelMapper modelMapper;

	// get all dependent

	@Override
	public List<DependentDTO> getAllDependent() {

		List<Dependent> dependents = this.dependentRepository.findAll();
		List<DependentDTO> dependentDTOs = dependents.stream().map(e -> this.dependentToDTO(e))
				.collect(Collectors.toList());
		return dependentDTOs;

	}

	// create dependent

	@Override
	public DependentDTO saveDependent(DependentDTO dependentDTO) {

		Dependent dependent = this.dtoToDependent(dependentDTO);
		Dependent saveDependent = dependentRepository.save(dependent);
		return this.dependentToDTO(saveDependent);

	}

	// get dependent by id

	@Override
	public DependentDTO getDependentById(long id) {

		Dependent dependent = this.dependentRepository.findById((int) id)
				.orElseThrow(() -> new ResourceNotFoundException("Dependent with id " + id + " not found"));
		return this.dependentToDTO(dependent);

	}

	// delete dependent

	@Override
	public void deleteDependentById(long id) {

		Dependent dependent = this.dependentRepository.findById((int) id)
				.orElseThrow(() -> new ResourceNotFoundException("Dependent with id " + id + " not found"));
		this.dependentRepository.delete(dependent);

	}

	// update dependent

	@Override
	public DependentDTO updateDependentById(long id, DependentDTO dependentDTO) {

		Dependent dependent = this.dependentRepository.findById((int) id)
				.orElseThrow(() -> new ResourceNotFoundException("Dependent with id " + id + " not found"));
		dependent.setD_no(dependentDTO.getD_no());
		dependent.setD_name(dependentDTO.getD_name());
		dependent.setGender(dependentDTO.getGender());
		dependent.setRelationship(dependentDTO.getRelationship());
		Dependent updateDependent = this.dependentRepository.save(dependent);
		DependentDTO dependentDTO2 = this.dependentToDTO(updateDependent);
		return dependentDTO2;

	}

	// Dependent to DTO Converter

	public Dependent dtoToDependent(DependentDTO dependentDTO) {

		Dependent dependent = this.modelMapper.map(dependentDTO, Dependent.class);
		return dependent;
	}

	// DTO to Dependent converter

	public DependentDTO dependentToDTO(Dependent dependent) {
		DependentDTO dependentDTO = this.modelMapper.map(dependent, DependentDTO.class);
		return dependentDTO;
	}

}
