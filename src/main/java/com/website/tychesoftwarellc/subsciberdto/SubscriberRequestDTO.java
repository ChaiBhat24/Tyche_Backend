package com.website.tychesoftwarellc.subsciberdto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class SubscriberRequestDTO {
	
	@NotBlank(message = "email required")
	@Email(message = "email not correct")
	private String email;
}
