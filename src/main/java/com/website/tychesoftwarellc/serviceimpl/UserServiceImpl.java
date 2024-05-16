package com.website.tychesoftwarellc.serviceimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.website.tychesoftwarellc.entity.User;
import com.website.tychesoftwarellc.exception.UserAlreadyPresent;
import com.website.tychesoftwarellc.repository.UserRepo;
import com.website.tychesoftwarellc.service.UserService;
import com.website.tychesoftwarellc.userdto.UserRequestDTO;
import com.website.tychesoftwarellc.userdto.UserResponseDTO;
import com.website.tychesoftwarellc.util.ResponseStructure;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepo userRepo;

	@Override
	public ResponseEntity<ResponseStructure<UserResponseDTO>> createUser(UserRequestDTO userDTO) {

		Optional<User> findByphone = userRepo.findByphone(userDTO.getPhone());
		if(findByphone.isPresent()) {
			throw new UserAlreadyPresent("User already present");
		}
		
		User user= new User();
		user.setFirstName(userDTO.getFirstName());
		user.setLastName(userDTO.getLastName());
		user.setEmail(userDTO.getEmail());
		user.setPhone(userDTO.getPhone());
		user.setMessage(userDTO.getMessage());
		
		User saveUser = userRepo.save(user);

		UserResponseDTO userResponseDTO= new UserResponseDTO();
//		userResponseDTO.setUserId(saveUser.getUserId());
		userResponseDTO.setFirstName(saveUser.getFirstName());
		userResponseDTO.setLastName(saveUser.getLastName());
		userResponseDTO.setEmail(saveUser.getEmail());
		userResponseDTO.setPhone(saveUser.getPhone());
		userResponseDTO.setMessage(saveUser.getMessage());
		
		ResponseStructure<UserResponseDTO> responseStructure = new ResponseStructure<UserResponseDTO>();
		responseStructure.setData(userResponseDTO);
		responseStructure.setMessage("User Added Successfully");
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		
		return new ResponseEntity<ResponseStructure<UserResponseDTO>>(responseStructure,HttpStatus.CREATED);
	}

}
