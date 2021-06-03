package com.example.demo.businessLogic.handlers.postHandlers;

import com.example.demo.businessLogic.events.commands.RegisterNewClient;
import com.example.demo.businessLogic.handlers.EventHandlerInterface;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class RegisterNewClientHandler implements EventHandlerInterface<RegisterNewClient> {

    @Override
    public ResponseEntity handle(RegisterNewClient event) {
        return null;
    }
}
