package com.website.tychesoftwarellc.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.website.tychesoftwarellc.entity.Subscriber;

public interface SubscriberRepo extends JpaRepository<Subscriber, Long>{

	public Optional<Subscriber> findByEmail(String email);
}
