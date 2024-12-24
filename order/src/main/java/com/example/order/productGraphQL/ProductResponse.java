package com.example.order.productGraphQL;


public record ProductResponse(
        String id,
        String sku,
        String barcode,
        String name,
        double price
) {

}
