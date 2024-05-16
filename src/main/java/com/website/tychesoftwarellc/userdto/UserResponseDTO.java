package com.website.tychesoftwarellc.userdto;

import java.math.BigInteger;

import lombok.Data;

@Data
public class UserResponseDTO {

	private String firstName;
	private String lastName;
	private String email;
	private BigInteger phone;
	private String message;
}
