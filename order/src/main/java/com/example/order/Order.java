package com.example.order;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;


@Setter
@Getter
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "order")
public class Order {

    @Id
    private String id;
    private List<String> productIds;
    private String idClient;
    private Double totalPrice;

}
