package com.example.demo.businessLogic.events.commands;

import com.example.demo.dataAccess.dto.AccountDTO;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RegisterNewAccount {

    private AccountDTO account;
}
