package com.example.demo.businessLogic.handlers.putHandlers;

import com.example.demo.businessLogic.events.commands.TransferMoney;
import com.example.demo.businessLogic.handlers.EventHandlerInterface;
import com.example.demo.service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class TransferMoneyHandler implements EventHandlerInterface<TransferMoney> {

    @Autowired
    private TransferService transferService;

    @Override
    public ResponseEntity handle(TransferMoney event) {
        return transferService.createTransfer(event.getTransfer());
    }
}
