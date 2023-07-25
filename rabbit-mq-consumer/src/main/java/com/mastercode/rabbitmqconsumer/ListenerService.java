package com.mastercode.rabbitmqconsumer;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.util.Random;

@Log4j2
@Service
@RequiredArgsConstructor
public class ListenerService {

    @RabbitListener(queues = {"${rabbitmq.queue.name}"})
    public void listener(CustomMessage customMessage) {
        log.info("publishMessage.START");

        if (true) {
            log.info("publishMessage.ERROR.START");
            throw new BusinessException("publishMessage.FAIL");
        }

        log.info("CustomMessage: {}", customMessage);
        log.info("publishMessage.END.SUCCESS. Message id: {}", customMessage.getMessageId());
    }

    @RabbitListener(queues = {"${rabbitmq.dlq.name}"})
    public void rePublish(CustomMessage failedMessage) {
        log.info("in DLQ");
        log.info("CustomMessage: {}", failedMessage);
        log.info("publishMessage.END.SUCCESS. Message id: {}", failedMessage.getMessageId());
    }

}
