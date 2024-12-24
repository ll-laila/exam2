package com.example.order.productGraphQL;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import java.util.List;
import java.util.Map;

@Service
public class ProductGraphQLClient {

    private final WebClient webClient;

    public ProductGraphQLClient(@Value("${application.config.products-url}") String productServiceUrl) {
        this.webClient = WebClient.builder()
                .baseUrl(productServiceUrl)
                .build();
    }

    public ProductResponse getProductById(String id) {
        String query = """
            query ($id: ID!) {
                product(id: $id) {
                    id
                    sku
                    barcode
                    name
                    price
                }
            }
        """;

        return (ProductResponse) this.webClient.post()
                .bodyValue(new GraphQLRequest(query, Map.of("id", id)))
                .retrieve()
                .bodyToMono(GraphQLResponse.class)
                .map(response -> response.getData().get("product"))
                .block();
    }

    public List<ProductResponse> getAllProducts() {
        String query = """
            query {
                allProducts {
                   id
                    sku
                    barcode
                    name
                    price
                }
            }
        """;

        return (List<ProductResponse>) this.webClient.post()
                .bodyValue(new GraphQLRequest(query, null))
                .retrieve()
                .bodyToMono(GraphQLResponse.class)
                .map(response -> response.getData().get("allProducts"))
                .block();
    }
}

