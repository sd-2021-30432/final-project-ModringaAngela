package com.example.demo.businessLogic.events.commands;

import com.example.demo.dataAccess.dto.AccountDTO;
import com.example.demo.dataAccess.dto.TransferDTO;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TransferMoney {

    TransferDTO transfer;
}
