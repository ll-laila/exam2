package com.example.order.clientGraphql;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.Map;

@Service
public class ClientGraphQLClient {

    private final WebClient webClient;

    public ClientGraphQLClient(@Value("${application.config.users-url}") String clientServiceUrl) {
        this.webClient = WebClient.builder()
                .baseUrl(clientServiceUrl)
                .build();
    }

    public ClientResponse getClientById(Long id) {
        String query = """
            query ($id: ID!) {
                client(id: $id) {
                    id
                    name
                    email
                }
            }
        """;

        return (ClientResponse) this.webClient.post()
                .bodyValue(new GraphQLRequest(query, Map.of("id", id)))
                .retrieve()
                .bodyToMono(GraphQLResponse.class)
                .map(response -> response.getData().get("client"))
                .block();
    }

    public List<ClientResponse> getAllClients() {
        String query = """
            query {
                allClients {
                    id
                    name
                    email
                }
            }
        """;

        return (List<ClientResponse>) this.webClient.post()
                .bodyValue(new GraphQLRequest(query, null))
                .retrieve()
                .bodyToMono(GraphQLResponse.class)
                .map(response -> response.getData().get("allClients"))
                .block();
    }
}
