package com.website.tychesoftwarellc.service;

import org.springframework.http.ResponseEntity;

import com.website.tychesoftwarellc.entity.User;
import com.website.tychesoftwarellc.userdto.UserRequestDTO;
import com.website.tychesoftwarellc.userdto.UserResponseDTO;
import com.website.tychesoftwarellc.util.ResponseStructure;

public interface UserService {
	public ResponseEntity<ResponseStructure<UserResponseDTO>> createUser(UserRequestDTO user);
}
