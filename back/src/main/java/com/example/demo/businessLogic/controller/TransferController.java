package com.example.demo.businessLogic.controller;


import com.example.demo.businessLogic.events.commands.TransferMoney;
import com.example.demo.businessLogic.handlers.Mediator;
import com.example.demo.dataAccess.dto.TransferDTO;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@NoArgsConstructor
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class TransferController {

    @Autowired
    private Mediator mediator;

    @PutMapping("/make-transfer-internal")
    public ResponseEntity<String> makeTransferInternal(@RequestBody TransferDTO transfer){

        TransferMoney event = new TransferMoney(transfer);
        return mediator.handle(event);
    }

    @PutMapping("/make-transfer-external")
    public ResponseEntity<String> makeTransferExternal(@RequestBody TransferDTO transfer){

        TransferMoney event = new TransferMoney(transfer);
        return mediator.handle(event);
    }
}
