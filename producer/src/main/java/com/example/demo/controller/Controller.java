package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFutureCallback;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.model.Customer;

@RestController
@RequestMapping("${spring.application.version}")
public class Controller {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(Controller.class);
	
	@Value("${kafka.topic.name}")
	private String topicName;
	
	@Autowired
	KafkaTemplate<String, Customer> kafkaTemplate;
	
	@PostMapping("/send")
	public String sendData(@RequestBody Customer customer) {
		kafkaTemplate.send(topicName,customer).addCallback(new ListenableFutureCallback<SendResult<String, Customer>>() {

			@Override
			public void onSuccess(SendResult<String, Customer> result) {
				LOGGER.info("customer: " + customer.getName() + " sent");
				
			}

			@Override
			public void onFailure(Throwable ex) {
				System.out.println("Failure");
				
			}
		});
		return "ok";
	}

}
