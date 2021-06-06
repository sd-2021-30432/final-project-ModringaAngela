package com.example.demo.businessLogic.controller;


import com.example.demo.businessLogic.events.commands.RegisterNewAccount;
import com.example.demo.businessLogic.events.queries.GetAccountById;
import com.example.demo.businessLogic.events.queries.GetAccountsByClientId;
import com.example.demo.businessLogic.handlers.Mediator;
import com.example.demo.businessLogic.handlers.getHandlers.GetAccountByIdHandler;
import com.example.demo.dataAccess.dto.AccountDTO;
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
public class AccountController {

    @Autowired
    private Mediator mediator;

    @GetMapping(value = "/client/{clientId}/accounts")
    public ResponseEntity<List<AccountDTO>> getAccountsByClient(@PathVariable Long clientId){

        GetAccountsByClientId event = new GetAccountsByClientId(clientId);
        return mediator.handle(event);
    }

    @GetMapping(value = "/account/{id}")
    public ResponseEntity<AccountDTO> getAccountById(@PathVariable Long id){

        GetAccountById event = new GetAccountById(id);
        return mediator.handle(event);
    }


    @PostMapping("/accounts/add-account")
    public ResponseEntity<AccountDTO> createAccount(@RequestBody() AccountDTO account){

        RegisterNewAccount event = new RegisterNewAccount(account);
        return mediator.handle(event);
    }
}
