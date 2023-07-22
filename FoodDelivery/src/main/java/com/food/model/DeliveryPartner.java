package com.food.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Data
public class DeliveryPartner {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer deliveryPartnerId;
	
	@NotBlank(message = "Mandatory Field")
	private String name;
	
	@NotBlank(message = "Mandatory Field")
	private String phoneNumber;
}
