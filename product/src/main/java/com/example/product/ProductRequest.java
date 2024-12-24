package com.example.product;

public record ProductRequest (
         String id,
         String sku,
         String barcode,
         String name,
         double price
){

}