package com.example.product.graphql;


import com.example.product.ProductResponse;
import com.example.product.ProductService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductQueryResolver {
    private final ProductService productService;

    public ProductQueryResolver(ProductService productService) {
        this.productService = productService;
    }

    public ProductResponse getProduct(String id) {
        return productService.getProductById(id);
    }

    public List<ProductResponse> getAllProducts() {
        return productService.getAllProducts();
    }
}
