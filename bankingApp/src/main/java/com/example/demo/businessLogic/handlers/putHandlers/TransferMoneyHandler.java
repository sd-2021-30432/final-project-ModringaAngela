package com.example.demo.businessLogic.handlers.putHandlers;

import com.example.demo.businessLogic.events.commands.TransferMoney;
import com.example.demo.businessLogic.handlers.EventHandlerInterface;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class TransferMoneyHandler implements EventHandlerInterface<TransferMoney> {

    @Override
    public ResponseEntity handle(TransferMoney event) {
        return null;
    }
}
