package com.employee_management_system.model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class DepartmentDTO {

	private int departmentId;
	@NotEmpty
	@Size(min = 3,max = 25,message = "department name should be min 3 max 25 characters")
	private String departmentName;
	@NotEmpty
	@Size(min = 5,max = 25,message = "department location should be min 5 max 25 characters")
	private String departmentLocation;

}
