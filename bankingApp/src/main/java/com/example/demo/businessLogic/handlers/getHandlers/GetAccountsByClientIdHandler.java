package com.example.demo.businessLogic.handlers.getHandlers;

import com.example.demo.businessLogic.events.queries.GetAccountsByClientId;
import com.example.demo.businessLogic.handlers.EventHandlerInterface;
import com.example.demo.dataAccess.dto.AccountDTO;
import com.example.demo.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetAccountsByClientIdHandler implements EventHandlerInterface<GetAccountsByClientId> {

    @Autowired
    private AccountService accountService;

    @Override
    public ResponseEntity handle(GetAccountsByClientId event) {
        List<AccountDTO> accounts = accountService.getAccountsByClientId(event.getClientId());
        return new ResponseEntity(accounts, HttpStatus.OK);
    }
}
