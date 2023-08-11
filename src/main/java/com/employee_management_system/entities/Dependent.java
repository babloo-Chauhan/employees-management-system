package com.employee_management_system.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Dependent {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int d_no;
	private String d_name;
	private String gender;
	private String relationship;

}
