package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Dependent {
	@Id
	private int d_no;
	private String d_name;
	private String gender;
	private String relationship;

}
