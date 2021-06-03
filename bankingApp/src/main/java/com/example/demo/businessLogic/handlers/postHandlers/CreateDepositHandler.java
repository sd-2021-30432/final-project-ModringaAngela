package com.example.demo.businessLogic.handlers.postHandlers;

import com.example.demo.businessLogic.events.commands.CreateDeposit;
import com.example.demo.businessLogic.handlers.EventHandlerInterface;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class CreateDepositHandler implements EventHandlerInterface<CreateDeposit> {

    @Override
    public ResponseEntity handle(CreateDeposit event) {
        return null;
    }
}
