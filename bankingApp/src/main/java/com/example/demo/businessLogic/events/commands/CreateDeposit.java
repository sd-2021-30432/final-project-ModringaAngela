package com.example.demo.businessLogic.events.commands;

import com.example.demo.dataAccess.dto.DepositDTO;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateDeposit {

    private DepositDTO deposit;
}
