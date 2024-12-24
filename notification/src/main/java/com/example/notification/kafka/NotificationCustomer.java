package com.example.notification.kafka;
import com.example.notification.email.EmailService;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import static java.lang.String.format;


@Service
@Slf4j
@RequiredArgsConstructor
public class NotificationCustomer {

    private final EmailService emailService;

    @KafkaListener(topics = "order-topic")
    public void consumeBorrowNotifications(OrderNotification orderNotification) throws MessagingException {

        log.info(format("Consuming the message from order-topic Topic:: %s", orderNotification));

        emailService.sendOrderConfirmationEmail(
                orderNotification.idClient(),
                orderNotification.name(),
                orderNotification.email(),
                orderNotification.totalPrice()
        );
    }




}
