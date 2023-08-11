package com.employee_management_system.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class EmployeeDTO {

	private long id;
	@NotNull
	@Size(min = 3, max = 30, message = "Firstname should be minimum 3 characters")
	private String firstName;
	@NotNull
	@Size(min = 3, max = 15, message = "Lastname should be minimum 3 characters")
	private String lastName;
	@jakarta.validation.constraints.Email(message = "Email addresss not valid")
	private String emailId;

}
