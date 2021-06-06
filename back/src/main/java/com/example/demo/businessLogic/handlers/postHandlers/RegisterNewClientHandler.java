package com.example.demo.businessLogic.handlers.postHandlers;

import com.example.demo.businessLogic.events.commands.RegisterNewClient;
import com.example.demo.businessLogic.handlers.EventHandlerInterface;
import com.example.demo.dataAccess.dto.ClientDTO;
import com.example.demo.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class RegisterNewClientHandler implements EventHandlerInterface<RegisterNewClient> {

    @Autowired
    private ClientService clientService;

    @Override
    public ResponseEntity handle(RegisterNewClient event) {
       ClientDTO client = clientService.registerClient(event.getClient());
       if(client == null)
           return ResponseEntity.badRequest().body(null);

       return ResponseEntity.status(HttpStatus.OK).body(client);
    }
}
