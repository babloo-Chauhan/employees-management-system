package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Dependent;

public interface DependentRepository extends JpaRepository<Dependent, Integer> {

}
