package com.example.demo.service;

import com.example.demo.dataAccess.dto.DepositDTO;
import com.example.demo.dataAccess.entities.Account;
import com.example.demo.dataAccess.entities.Deposit;
import com.example.demo.dataAccess.repositories.AccountRepository;
import com.example.demo.dataAccess.repositories.DepositRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepositService {

    @Autowired
    private DepositRepository depositRepository;

    @Autowired
    private AccountRepository accountRepository;

    public List<DepositDTO> getDepositsByAccountId(Long accountId){

        Account account = accountRepository.findById(accountId).get();

        List<Deposit> deposits = depositRepository.findDepositsByAccount(account);
        List<DepositDTO> depositsDto = DepositDTO.fromEntities(deposits);
        return depositsDto;
    }
}
