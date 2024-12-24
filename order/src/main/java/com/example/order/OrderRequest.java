package com.example.order;

import java.util.List;

public record OrderRequest (

        String id,
        List<String> productIds,
        String idClient,
        Double totalPrice
){

}

