package com.mastercode.rabbitmq;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Random;
import java.util.UUID;
import java.util.random.RandomGenerator;

@Log4j2
@Component
@RequiredArgsConstructor
public class MessagePublisher {

    private final AmqpTemplate template;

    public <T> void publishMessage(String queue, T data) {
        template.convertAndSend(queue, data);
        log.info("publishMessage.END.SUCCESS");
    }
}
