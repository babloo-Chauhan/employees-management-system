package com.example.demo.model;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Department {
	@Id
	private int departmentId;
	private String departmentName;
	private String departmentLocation;
	

}
