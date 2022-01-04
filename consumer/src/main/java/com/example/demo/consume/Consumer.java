package com.example.demo.consume;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.example.model.Customer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class Consumer {
	private static final Logger LOGGER = LoggerFactory.getLogger(Consumer.class);
	
	
	
	@KafkaListener(topics ="${kafka.topic.name}")
	public void listenInfo(Customer customer) {
		LOGGER.info("customer: " + customer.getName() + " recieved");
	}

}
