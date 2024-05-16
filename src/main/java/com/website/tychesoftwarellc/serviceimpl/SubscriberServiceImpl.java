package com.website.tychesoftwarellc.serviceimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.website.tychesoftwarellc.entity.Subscriber;
import com.website.tychesoftwarellc.exception.ForbiddenOperationException;
import com.website.tychesoftwarellc.exception.SubscriberAlreadyPresent;
import com.website.tychesoftwarellc.repository.SubscriberRepo;
import com.website.tychesoftwarellc.service.SubscriberService;
import com.website.tychesoftwarellc.subsciberdto.SubscriberRequestDTO;
import com.website.tychesoftwarellc.subsciberdto.SubscriberResponseDTO;
import com.website.tychesoftwarellc.util.ResponseStructure;

import jakarta.validation.Valid;

@Service
public class SubscriberServiceImpl implements SubscriberService {
	
	@Autowired
	private SubscriberRepo subscriberRepo;
	
	@Autowired
	JavaMailSender javaMailSender;
	
	@Override
	public ResponseEntity<ResponseStructure<SubscriberResponseDTO>> createSubscriber(@Valid SubscriberRequestDTO subscriberRequestDTO) {
		Optional<Subscriber> findByEmail= subscriberRepo.findByEmail(subscriberRequestDTO.getEmail());

		if(findByEmail.isPresent()) {
			throw new SubscriberAlreadyPresent("You have already subscribed");
		}
		Subscriber subscriber = new Subscriber();
		subscriber.setEmail(subscriberRequestDTO.getEmail());
		subscriberRepo.save(subscriber);
		
		sendAcknowledgmentEmail(subscriber.getEmail());
		
		SubscriberResponseDTO subscriberResponseDTO=new SubscriberResponseDTO();
		subscriberResponseDTO.setEmail(subscriber.getEmail());
		
		ResponseStructure<SubscriberResponseDTO> responseStructure= new ResponseStructure<SubscriberResponseDTO>();
		responseStructure.setData(subscriberResponseDTO);
		responseStructure.setMessage("Subscribed to newsletter successfully");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		
		return new ResponseEntity<ResponseStructure<SubscriberResponseDTO>>(responseStructure,HttpStatus.OK);
	}

	private void sendAcknowledgmentEmail(String email) {
		SimpleMailMessage simpleMailMessage= new SimpleMailMessage();
		simpleMailMessage.setTo(email);
		simpleMailMessage.setSubject("Welcome to Tyche Software");
		simpleMailMessage.setText("Thank you for subscribing to our newsletter!");
		
		javaMailSender.send(simpleMailMessage);
	}


}
