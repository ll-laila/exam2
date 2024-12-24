package com.example.order;

import org.springframework.stereotype.Component;

@Component
public class OrderMapper {
    public static Order toOrder(OrderRequest request) {
        if (request == null) {
            return null;
        }

        return Order.builder()
                .id(request.id())
                .productIds(request.productIds())
                .idClient(request.idClient())
                .totalPrice(request.totalPrice())
                .build();
    }

    public static OrderResponse fromOrder(Order Order) {

        return new OrderResponse(
                Order.getId(),
                Order.getProductIds(),
                Order.getIdClient(),
                Order.getTotalPrice()
        );
    }


}

