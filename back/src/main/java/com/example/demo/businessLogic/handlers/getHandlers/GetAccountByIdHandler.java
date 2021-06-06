package com.example.demo.businessLogic.handlers.getHandlers;

import com.example.demo.businessLogic.events.queries.GetAccountById;
import com.example.demo.businessLogic.handlers.EventHandlerInterface;
import com.example.demo.dataAccess.dto.AccountDTO;
import com.example.demo.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class GetAccountByIdHandler implements EventHandlerInterface<GetAccountById> {

    @Autowired
    private AccountService accountService;

    @Override
    public ResponseEntity<AccountDTO> handle(GetAccountById event) {

        AccountDTO account = accountService.getAccountById(event.getId());
        return ResponseEntity.status(HttpStatus.OK).body(account);
    }
}
