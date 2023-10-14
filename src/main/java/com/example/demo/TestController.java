package com.example.demo;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class TestController {
	@Autowired
	RabbitTemplate rabbitTemplate;
	@GetMapping("/test/{name}")
	public String testAPI(@PathVariable("name") String name) {
		Person p = new Person(1L, name);
//		rabbitTemplate.convertAndSend("Mobile", p);
		rabbitTemplate.convertAndSend("Burak", "345", p);
		rabbitTemplate.convertAndSend("Burak", "456", p);
		rabbitTemplate.convertAndSend("Fanout", "", p);

		
		return "Success";
	}

}
