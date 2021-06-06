package com.example.demo.service;

import com.example.demo.dataAccess.dto.AccountDTO;
import com.example.demo.dataAccess.entities.Account;
import com.example.demo.dataAccess.entities.Bank;
import com.example.demo.dataAccess.entities.decorator.Client;
import com.example.demo.dataAccess.repositories.AccountRepository;
import com.example.demo.dataAccess.repositories.BankRepository;
import com.example.demo.dataAccess.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private BankRepository bankRepository;

    public List<AccountDTO> getAccountsByClientId(Long clientId){
        Client c = clientRepository.findById(clientId).get();
        List<AccountDTO> accounts = AccountDTO.fromEntities(accountRepository.findAccountsByClient(c));
        return accounts;
    }

    public AccountDTO getAccountById(Long id){
        return  AccountDTO.fromEntity(accountRepository.findAccountById(id));
    }

    private boolean goodData(String type, Bank bank){
        if(!(type.equals("checking") || type.equals("savings"))){
            return false;
        }
        if(bank == null){
            return false;
        }
        return true;
    }

    public AccountDTO createNewAccount(AccountDTO account){

        Long clientId = account.getClientId();
        Client client = clientRepository.findById(clientId).get();

        Bank bank = bankRepository.findByName(account.getBankName());

        if(goodData(account.getType(), bank)){

            Account accountEntity = Account.builder()
                    .balance(account.getBalance())
                    .iban(account.getIban())
                    .bank(bank)
                    .client(client)
                    .type(account.getType())
                    .build();

            Account _Account = accountRepository.save(accountEntity);
            return account;
        }
        return null;
    }
}
