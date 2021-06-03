package com.example.demo.businessLogic.handlers.putHandlers;

import com.example.demo.businessLogic.events.commands.PayBill;
import com.example.demo.businessLogic.handlers.EventHandlerInterface;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class PayBillHandler implements EventHandlerInterface<PayBill> {

    @Override
    public ResponseEntity handle(PayBill event) {
        return null;
    }
}
