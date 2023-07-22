package com.food.model;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer customerId;
	
	@NotBlank(message = "Mandatory Field")
	private String name;
	
	@NotBlank(message = "Mandatory Field")
	@Email
	private String email; 
	
	@NotBlank(message = "Mandatory Field")
	private String address;
}
