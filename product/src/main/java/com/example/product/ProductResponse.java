package com.example.product;


public record ProductResponse (
        String id,
        String sku,
        String barcode,
        String name,
        double price
) {

}