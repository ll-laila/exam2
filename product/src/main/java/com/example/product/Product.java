package com.example.product;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Document(collection = "product")
public class Product {

    @Id
    private String id;
    private String sku;
    private String barcode;
    private String name;
    private double price;


}

