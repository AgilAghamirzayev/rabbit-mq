package com.mastercode.rabbitmq;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class SenderService {

    @Value("${rabbitmq.queue.name}")
    private String masterCodeQ;

    private final MessagePublisher messagePublisher;

    @Scheduled(fixedDelay = 5000)
    public void sendMessageToQueue() {
        CustomMessage customMessage =
                CustomMessage.builder()
                        .messageId(new Random().doubles().toString())
                        .message("This is a test message")
                        .messageDate(LocalDateTime.now())
                        .build();

        messagePublisher.publishMessage(masterCodeQ, customMessage);
    }
}
