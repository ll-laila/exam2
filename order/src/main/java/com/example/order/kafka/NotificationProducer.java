package com.example.order.kafka;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import static org.springframework.kafka.support.KafkaHeaders.TOPIC;


@Service
@RequiredArgsConstructor
@Slf4j
public class NotificationProducer {

    private final KafkaTemplate<String, OrderNotification> kafkaTemplate;


    public void sendOrderNotification(OrderNotification orderNotification) {
        log.info("Sending order notification");
        Message<OrderNotification> message = MessageBuilder
                .withPayload(orderNotification)
                .setHeader(TOPIC, "order-topic")
                .build();

        kafkaTemplate.send(message);
    }




}
