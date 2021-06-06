package com.example.demo.businessLogic.handlers.getHandlers;

import com.example.demo.businessLogic.events.queries.GetCardsByAccountId;
import com.example.demo.businessLogic.handlers.EventHandlerInterface;
import com.example.demo.dataAccess.dto.CardDTO;
import com.example.demo.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetCardsByAccountIdHandler implements EventHandlerInterface<GetCardsByAccountId> {

    @Autowired
    private CardService cardService;

    @Override
    public ResponseEntity handle(GetCardsByAccountId event) {

        List<CardDTO> cards = cardService.getCardsByAccountId(event.getAccountId());

        return new ResponseEntity(cards, HttpStatus.OK);
    }
}
