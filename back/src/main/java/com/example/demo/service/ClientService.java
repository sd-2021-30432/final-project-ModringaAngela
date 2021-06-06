package com.example.demo.service;

import com.example.demo.dataAccess.dto.ClientDTO;
import com.example.demo.dataAccess.entities.decorator.Client;
import com.example.demo.dataAccess.entities.decorator.ClientInterface;
import com.example.demo.dataAccess.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public ClientDTO getClient(String username, String password){

        Client clientEntity = clientRepository.findClientByUsernameAndPassword(username, password);
        if(clientEntity!= null){
            System.out.println("Decorating with age");

            ClientInterface clientDecorated = ClientDTO.addAge(clientEntity);
            return ClientDTO.fromEntity(clientDecorated);
        }
        return null;
    }

    ////nonexistent client
    public boolean validData(ClientDTO clientDTO){
        Client client = clientRepository.findClientByUsernameAndPassword(clientDTO.getUsername(), clientDTO.getPassword());
        if(client != null)
            return false;
        return true;
    }

    public ClientDTO registerClient(ClientDTO clientDTO){

        if (validData(clientDTO)) {
            Client client = Client.builder()
                    .username(clientDTO.getUsername())
                    .password(clientDTO.getPassword())
                    .firstName(clientDTO.getFirstName())
                    .lastName(clientDTO.getLastName())
                    .dob(clientDTO.getDob())
                    .build();

            Client _Client = clientRepository.save(client);
            return clientDTO;
        }
        return null;

    }
}
