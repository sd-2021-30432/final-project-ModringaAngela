package com.example.demo.businessLogic.controller;

import com.example.demo.businessLogic.events.commands.CreateDeposit;
import com.example.demo.businessLogic.events.commands.Login;
import com.example.demo.businessLogic.events.queries.GetDepositsByAccountId;
import com.example.demo.businessLogic.handlers.Mediator;
import com.example.demo.dataAccess.dto.ClientDTO;
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
public class DepositController {

    @Autowired
    private Mediator mediator;

    @PostMapping("/create-deposit")
    public ResponseEntity<DepositDTO> createDeposit(@RequestBody() DepositDTO deposit){

        CreateDeposit event = new CreateDeposit(deposit);
        return mediator.handle(event);
    }

    @GetMapping("/account/{accountId}/deposits")
    public ResponseEntity<List<DepositDTO>> getDepositsByAccountId(@PathVariable Long accountId){

        GetDepositsByAccountId event = new GetDepositsByAccountId(accountId);
        return mediator.handle(event);
    }
}
