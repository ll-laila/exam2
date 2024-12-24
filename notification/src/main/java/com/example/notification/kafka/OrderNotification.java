package com.example.notification.kafka;

public record OrderNotification(
         Long idClient,
         String name,
         String email,
         Double totalPrice

) {
}
