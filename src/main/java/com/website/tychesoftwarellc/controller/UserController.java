package com.website.tychesoftwarellc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.website.tychesoftwarellc.service.UserService;
import com.website.tychesoftwarellc.userdto.UserRequestDTO;
import com.website.tychesoftwarellc.userdto.UserResponseDTO;
import com.website.tychesoftwarellc.util.ResponseStructure;

@CrossOrigin
@RestController
@Validated
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/user/add")
	public ResponseEntity<ResponseStructure<UserResponseDTO>> createUser(@RequestBody UserRequestDTO userDTO){
		return userService.createUser(userDTO);
	}
}
