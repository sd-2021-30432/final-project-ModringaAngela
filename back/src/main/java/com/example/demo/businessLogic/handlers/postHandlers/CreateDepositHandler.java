package com.example.demo.businessLogic.handlers.postHandlers;

import com.example.demo.businessLogic.events.commands.CreateDeposit;
import com.example.demo.businessLogic.handlers.EventHandlerInterface;
import com.example.demo.dataAccess.entities.Deposit;
import com.example.demo.service.AccountService;
import com.example.demo.service.DepositService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class CreateDepositHandler implements EventHandlerInterface<CreateDeposit> {

    @Autowired
    private DepositService depositService;

    @Override
    public ResponseEntity handle(CreateDeposit event) {
        return depositService.createDeposit(event.getDeposit());
    }
}
