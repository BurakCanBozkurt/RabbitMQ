package com.example.demo;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQConsumer {

	@RabbitListener(queues = "Mobile")
	public void getMessage(Person p) {
		System.out.println(p.getName()+" Mobile queue");
	}

	@RabbitListener(queues = "Key")
	public void getMessage2(Person p) {
		System.out.println(p.getName()+ " Key queue");
	}

}
