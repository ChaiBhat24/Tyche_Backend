package com.website.tychesoftwarellc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.website.tychesoftwarellc.entity.Subscriber;
import com.website.tychesoftwarellc.service.SubscriberService;
import com.website.tychesoftwarellc.subsciberdto.SubscriberRequestDTO;
import com.website.tychesoftwarellc.subsciberdto.SubscriberResponseDTO;
import com.website.tychesoftwarellc.util.ResponseStructure;

@CrossOrigin
@RestController
@Validated
public class SubscriberController {
	
	@Autowired
	SubscriberService subscriberService;
	
	@PostMapping("/subscriber/create")
	public ResponseEntity<ResponseStructure<SubscriberResponseDTO>> createSubscriber(@RequestBody @Validated SubscriberRequestDTO subscriberRequestDTO){
		return subscriberService.createSubscriber(subscriberRequestDTO);
	}
}
