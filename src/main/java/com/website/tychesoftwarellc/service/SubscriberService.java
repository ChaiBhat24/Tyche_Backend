package com.website.tychesoftwarellc.service;

import org.springframework.http.ResponseEntity;

import com.website.tychesoftwarellc.entity.Subscriber;
import com.website.tychesoftwarellc.subsciberdto.SubscriberRequestDTO;
import com.website.tychesoftwarellc.subsciberdto.SubscriberResponseDTO;
import com.website.tychesoftwarellc.util.ResponseStructure;

public interface SubscriberService {
	public ResponseEntity<ResponseStructure<SubscriberResponseDTO>> createSubscriber(SubscriberRequestDTO subscriberRequestDTO);

}
