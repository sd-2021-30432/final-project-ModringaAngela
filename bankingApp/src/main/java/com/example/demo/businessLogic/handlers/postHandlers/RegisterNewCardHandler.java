package com.example.demo.businessLogic.handlers.postHandlers;

import com.example.demo.businessLogic.events.commands.RegisterNewCard;
import com.example.demo.businessLogic.handlers.EventHandlerInterface;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class RegisterNewCardHandler implements EventHandlerInterface<RegisterNewCard> {

    @Override
    public ResponseEntity handle(RegisterNewCard event) {
        return null;
    }
}
