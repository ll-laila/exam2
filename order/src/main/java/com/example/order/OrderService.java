package com.example.order;

import com.example.order.clientGraphql.ClientGraphQLClient;
import com.example.order.clientGraphql.ClientResponse;
import com.example.order.productGraphQL.ProductResponse;
import com.example.order.productGraphQL.ProductGraphQLClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class OrderService {


    @Autowired
    private OrderRepository orderRepository;



    @Autowired
    private  ProductGraphQLClient productGraphQLClient;


    @Autowired
    private  ClientGraphQLClient clientGraphQLClient;



    public com.example.order.clientGraphql.ClientResponse fetchClient(Long id) {
        return clientGraphQLClient.getClientById(id);
    }

    public List<com.example.order.clientGraphql.ClientResponse> fetchAllClients() {
        return clientGraphQLClient.getAllClients();
    }
    public com.example.order.productGraphQL.ProductResponse fetchProduct(String id) {
        return productGraphQLClient.getProductById(id);
    }

    public List<com.example.order.productGraphQL.ProductResponse> fetchAllProducts() {
        return productGraphQLClient.getAllProducts();
    }


    public OrderResponse addOrder(OrderRequest request) {

        ClientResponse client = fetchClient(Long.valueOf(request.idClient()));

        if(client == null){
            return null;
        }

        List<ProductResponse> products = new ArrayList<>();
        for (int i = 0; i < request.productIds().size(); i++) {
            products.add(fetchProduct(request.productIds().get(i)));
        }

        double totalPrice = 0;
        for (ProductResponse product : products) {
            totalPrice = totalPrice + product.price();
        }

        Order order = OrderMapper.toOrder(request);
        order.setProductIds(request.productIds());
        order.setIdClient(String.valueOf(client.id()));
        order.setTotalPrice(totalPrice);
        Order savedOrder = orderRepository.save(order);

        return OrderMapper.fromOrder(savedOrder);

    }



    public List<OrderResponse> getAllOrders() {

        List<Order> ordersList = orderRepository.findAll();

        return ordersList.stream()
                .map(OrderMapper::fromOrder)
                .collect(Collectors.toList());
    }


    public OrderResponse getOrderById(String id) {
        Order order = orderRepository.findById(id).orElseThrow(() -> new RuntimeException("Order not found"));
        return OrderMapper.fromOrder(order);
    }



    public void deleteOrder(String id) {
        orderRepository.deleteById(id);
    }



}
