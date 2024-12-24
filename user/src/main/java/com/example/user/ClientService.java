package com.example.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientService {


    @Autowired
    private ClientRepository clientRepository;

    public ClientResponse addClient(ClientRequest request) {

        Client Client = ClientMapper.toClient(request);
        Client.setName(request.name());
        Client.setEmail(request.email());
        Client savedClient = clientRepository.save(Client);

        return ClientMapper.fromClient(savedClient);
    }

    public List<ClientResponse> getAllClients() {

        List<Client> ClientsList = clientRepository.findAll();

        return ClientsList.stream()
                .map(ClientMapper::fromClient)
                .collect(Collectors.toList());
    }

    public ClientResponse getClientById(Long id) {
        Client Client = clientRepository.findById(id).orElseThrow(() -> new RuntimeException("Client not found"));
        return ClientMapper.fromClient(Client);
    }

    public void deleteClient(Long id) {
        clientRepository.deleteById(Long.valueOf(id));
    }
}