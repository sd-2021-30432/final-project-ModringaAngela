package com.example.demo.service;

import com.example.demo.dataAccess.dto.AccountDTO;
import com.example.demo.dataAccess.entities.Client;
import com.example.demo.dataAccess.repositories.AccountRepository;
import com.example.demo.dataAccess.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.http.ResponseEntity;

import java.util.List;
@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private ClientRepository clientRepository;

    public List<AccountDTO> getAccountsByClientId(Long clientId){
        Client c = clientRepository.findById(clientId).get();
        List<AccountDTO> accounts = AccountDTO.fromEntities(accountRepository.findAccountsByClient(c));
        return accounts;
    }
}
