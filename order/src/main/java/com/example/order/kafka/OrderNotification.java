package com.example.order.kafka;

public record OrderNotification(
         Long idClient,
         String name,
         String email,
         Double totalPrice

) {
}
