package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Project {
	@Id
	private int projectNumber;
	private String projectName;
	private String projectLocation;

}
