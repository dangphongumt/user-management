package com.test.user.kafka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MessageConsumer {

    @KafkaListener(topics = "${spring.kafka.topic.name}", containerFactory = "kafkaListenerContainerFactory")
    public void listenMessage(String message) {
        System.out.println(
                "Received Message: " + message);
    }
}
