package com.example.demo.businessLogic.handlers.postHandlers;

import com.example.demo.businessLogic.events.commands.RegisterNewAccount;
import com.example.demo.businessLogic.handlers.EventHandlerInterface;
import com.example.demo.dataAccess.dto.AccountDTO;
import com.example.demo.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class RegisterNewAccountHandler implements EventHandlerInterface<RegisterNewAccount> {

    @Autowired
    private AccountService accountService;

    @Override
    public ResponseEntity<AccountDTO> handle(RegisterNewAccount event) {

        System.out.println("Handler");

        AccountDTO account = accountService.createNewAccount(event.getAccount());

        if (account == null)
            return ResponseEntity.badRequest().body(null);
        return ResponseEntity.status(HttpStatus.OK).body(account);
    }
}
