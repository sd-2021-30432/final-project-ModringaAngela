package com.example.demo.businessLogic.handlers.putHandlers;

import com.example.demo.businessLogic.events.commands.DestroyDeposit;
import com.example.demo.businessLogic.handlers.EventHandlerInterface;
import com.example.demo.service.DepositService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class DestroyDepositHandler implements EventHandlerInterface<DestroyDeposit> {

    @Autowired
    private DepositService depositService;

    @Override
    public ResponseEntity handle(DestroyDeposit event) {
        return depositService.destroyDeposit(event.getDepositId());
    }
}
