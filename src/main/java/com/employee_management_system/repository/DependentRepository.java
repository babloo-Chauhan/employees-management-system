package com.employee_management_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employee_management_system.entities.Dependent;

public interface DependentRepository extends JpaRepository<Dependent, Integer> {

}
