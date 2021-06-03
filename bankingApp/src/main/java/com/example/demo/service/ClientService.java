package com.example.demo.service;

import com.example.demo.dataAccess.dto.ClientDTO;
import com.example.demo.dataAccess.entities.Client;
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
            return ClientDTO.fromEntity(clientEntity);
        }
        return null;
    }
}
