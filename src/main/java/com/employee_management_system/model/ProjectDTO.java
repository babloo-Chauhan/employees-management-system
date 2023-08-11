package com.employee_management_system.model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class ProjectDTO {

	private int projectNumber;
	@NotEmpty
	@Size(min = 5,max = 25,message = "project name should be min 5 max 25 characters")
	private String projectName;
	
	@NotEmpty
	@Size(min = 5,max = 25,message = "project location should be min 5 max 25 characters")
	private String projectLocation;

}
