package com.example.demo.businessLogic.handlers.postHandlers;

import com.example.demo.businessLogic.events.commands.RegisterNewAccount;
import com.example.demo.businessLogic.handlers.EventHandlerInterface;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class RegisterNewAccountHandler implements EventHandlerInterface<RegisterNewAccount> {

    @Override
    public ResponseEntity handle(RegisterNewAccount event) {
        return null;
    }
}
