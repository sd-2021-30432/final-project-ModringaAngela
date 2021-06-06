package com.example.demo.businessLogic.controller;

import com.example.demo.businessLogic.events.commands.Login;
import com.example.demo.businessLogic.events.commands.RegisterNewAccount;
import com.example.demo.businessLogic.events.commands.RegisterNewClient;
import com.example.demo.businessLogic.handlers.Mediator;
import com.example.demo.dataAccess.dto.ClientDTO;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@NoArgsConstructor
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class ClientController {

    @Autowired
    private Mediator mediator;

    @PostMapping("/login-client")
    public ResponseEntity<ClientDTO> login(@RequestBody() ClientDTO client){

        Login event = new Login(client);
        return mediator.handle(event);
    }

    @PostMapping("/new-user")
    public ResponseEntity<ClientDTO> registerClients(@RequestBody ClientDTO client){
        //System.out.println(client.getDob());
        RegisterNewClient event = new RegisterNewClient(client);
        return mediator.handle(event);
    }
}
