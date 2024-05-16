package com.website.tychesoftwarellc.repository;

import java.math.BigInteger;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.website.tychesoftwarellc.entity.User;

public interface UserRepo extends JpaRepository<User, Integer>{
	
	public Optional<User> findByphone(BigInteger phone);
}
