package com.example.demo.businessLogic.handlers.putHandlers;

import com.example.demo.businessLogic.events.commands.DestroyDeposit;
import com.example.demo.businessLogic.handlers.EventHandlerInterface;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class DestroyDepositHandler implements EventHandlerInterface<DestroyDeposit> {

    @Override
    public ResponseEntity handle(DestroyDeposit event) {
        return null;
    }
}
