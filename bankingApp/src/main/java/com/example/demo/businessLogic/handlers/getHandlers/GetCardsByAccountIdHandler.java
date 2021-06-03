package com.example.demo.businessLogic.handlers.getHandlers;

import com.example.demo.businessLogic.events.queries.GetCardsByAccountId;
import com.example.demo.businessLogic.handlers.EventHandlerInterface;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class GetCardsByAccountIdHandler implements EventHandlerInterface<GetCardsByAccountId> {

    @Override
    public ResponseEntity handle(GetCardsByAccountId event) {
        return null;
    }
}
