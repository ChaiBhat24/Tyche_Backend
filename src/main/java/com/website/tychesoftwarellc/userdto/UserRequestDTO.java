package com.website.tychesoftwarellc.userdto;

import java.math.BigInteger;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserRequestDTO {
	

	@NotBlank(message = "FirstName required")
	private String firstName;
	
	@NotBlank(message = "LastName required")
	private String lastName;
		
	@NotBlank(message = "email required")
	@Email(message = "email not correct")
	private String email;
		
	@Min(value = 6000000000l ,message = "Phone Number cannot start with below `6`!!!")
	@Max(value = 9999999999l,message = "Phone number cannot exceed `10` Digits!!!")
	private BigInteger phone;
	
	private String message;
}
