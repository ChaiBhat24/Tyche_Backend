package com.website.tychesoftwarellc.entity;

import java.math.BigInteger;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Entity
public class Subscriber {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long subscriberId;
	
	private String email;
	
//	private Boolean alreadyPresent= false;
	
}
