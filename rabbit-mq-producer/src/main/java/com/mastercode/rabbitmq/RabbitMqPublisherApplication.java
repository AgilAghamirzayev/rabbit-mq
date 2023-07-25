package com.mastercode.rabbitmq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class RabbitMqPublisherApplication {

	public static void main(String[] args) {
		SpringApplication.run(RabbitMqPublisherApplication.class, args);
	}

}
