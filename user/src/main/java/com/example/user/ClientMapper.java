package com.example.user;

import org.springframework.stereotype.Component;

@Component
public class ClientMapper {
    public static Client toClient(ClientRequest request) {
        if (request == null) {
            return null;
        }

        return Client.builder()
                .id(request.id())
                .name(request.name())
                .email(request.email())
                .build();
    }

    public static ClientResponse fromClient(Client Client) {

        return new ClientResponse(
                Client.getId(),
                Client.getName(),
                Client.getEmail()
        );
    }


}

