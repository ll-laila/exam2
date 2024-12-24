package com.example.product;


import org.springframework.stereotype.Component;

@Component
public class ProductMapper {
    public static Product toProduct(ProductRequest request) {
        if (request == null) {
            return null;
        }

        return Product.builder()
                .id(request.id())
                .sku(request.sku())
                .barcode(request.barcode())
                .name(request.name())
                .price(request.price())
                .price(request.price())
                .build();
    }

    public static ProductResponse fromProduct(Product Product) {

        return new ProductResponse(
                Product.getId(),
                Product.getSku(),
                Product.getBarcode(),
                Product.getName(),
                Product.getPrice()
        );
    }


}

