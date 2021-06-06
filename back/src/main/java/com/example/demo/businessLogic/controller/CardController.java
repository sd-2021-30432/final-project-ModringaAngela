package com.example.demo.businessLogic.controller;

import com.example.demo.businessLogic.events.commands.RegisterNewCard;
import com.example.demo.businessLogic.events.queries.GetCardsByAccountId;
import com.example.demo.businessLogic.handlers.Mediator;
import com.example.demo.dataAccess.dto.CardDTO;
import com.example.demo.dataAccess.dto.DepositDTO;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@NoArgsConstructor
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class CardController {

    @Autowired
    private Mediator mediator;

    @PostMapping("/register-card")
    public ResponseEntity<DepositDTO> registerCard(@RequestBody()CardDTO card){

        RegisterNewCard event = new RegisterNewCard(card);
        return mediator.handle(event);
    }

    @GetMapping("/account/{accountId}/cards")
    public ResponseEntity<List<DepositDTO>> getDepositsByAccountId(@PathVariable Long accountId){

        GetCardsByAccountId event = new GetCardsByAccountId(accountId);
        return mediator.handle(event);
    }
}
