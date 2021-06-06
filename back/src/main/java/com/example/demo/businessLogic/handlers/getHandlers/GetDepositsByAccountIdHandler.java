package com.example.demo.businessLogic.handlers.getHandlers;

import com.example.demo.businessLogic.events.queries.GetDepositsByAccountId;
import com.example.demo.businessLogic.handlers.EventHandlerInterface;
import com.example.demo.dataAccess.dto.DepositDTO;
import com.example.demo.service.DepositService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetDepositsByAccountIdHandler implements EventHandlerInterface<GetDepositsByAccountId> {

    @Autowired
    private DepositService depositService;

    @Override
    public ResponseEntity handle(GetDepositsByAccountId event){

        List<DepositDTO> deposits = depositService.getDepositsByAccountId(event.getAccountId());

        return new ResponseEntity(deposits, HttpStatus.OK);
    }
}
