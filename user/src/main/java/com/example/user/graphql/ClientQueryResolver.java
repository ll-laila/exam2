package com.example.user.graphql;


import com.example.user.ClientResponse;
import com.example.user.ClientService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClientQueryResolver {
    private final ClientService clientService;

    public ClientQueryResolver(ClientService clientService) {
        this.clientService = clientService;
    }

    public ClientResponse getClient(Long id) {
        return clientService.getClientById(id);
    }

    public List<ClientResponse> getAllClients() {
        return clientService.getAllClients();
    }
}
