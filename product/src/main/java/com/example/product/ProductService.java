package com.example.product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public ProductResponse addProduct(ProductRequest request) {

        Product product = ProductMapper.toProduct(request);
        product.setSku(request.sku());
        product.setBarcode(request.barcode());
        product.setName(request.name());
        product.setPrice(request.price());
        Product savedProduct = productRepository.save(product);

        return ProductMapper.fromProduct(savedProduct);
    }

    public List<ProductResponse> getAllProducts() {

        List<Product> productsList = productRepository.findAll();

        return productsList.stream()
                .map(ProductMapper::fromProduct)
                .collect(Collectors.toList());
    }

    public ProductResponse getProductById(String id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
        return ProductMapper.fromProduct(product);
    }

    public void deleteProduct(String id) {
        productRepository.deleteById(id);
    }
}
