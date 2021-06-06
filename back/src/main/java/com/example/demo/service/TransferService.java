package com.example.demo.service;

import com.example.demo.dataAccess.dto.TransferDTO;
import com.example.demo.dataAccess.entities.Account;
import com.example.demo.dataAccess.entities.Transfer;
import com.example.demo.dataAccess.repositories.AccountRepository;
import com.example.demo.dataAccess.repositories.TransferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class TransferService {

    @Autowired
    private TransferRepository transferRepository;

    @Autowired
    private AccountRepository accountRepository;

    public ResponseEntity<TransferDTO> createTransfer(TransferDTO transferDTO) {

        Account accountToSearch = new Account();

        if(transferDTO.getAccountToId() == null){ //dai iban
            System.out.println("external");
            accountToSearch = accountRepository.findAccountByIban(transferDTO.getIban());
        }
        else{ //dai id
            System.out.println("internal");
            accountToSearch = accountRepository.findAccountById(transferDTO.getAccountToId());
            transferDTO.setIban(accountToSearch.getIban());
        }
        Account accountFromSearch = accountRepository.findAccountById(transferDTO.getAccountFromId());

        if (accountFromSearch != null && accountToSearch != null) {
            if (accountFromSearch.getBalance() >= transferDTO.getAmountOfMoney()) {
                Transfer transferEntity = Transfer.builder()
                        .fromAccount(accountFromSearch)
                        .toAccount(accountToSearch)
                        .amountOfMoney(transferDTO.getAmountOfMoney())
                        .id(transferDTO.getId())
                        .iban(transferDTO.getIban())
                        .build();

                Transfer _Transfer = transferRepository.save(transferEntity);

                accountFromSearch.setBalance(accountFromSearch.getBalance() - transferDTO.getAmountOfMoney());
                accountRepository.save(accountFromSearch);

                accountToSearch.setBalance(accountToSearch.getBalance() + transferDTO.getAmountOfMoney());
                accountRepository.save(accountToSearch);

                return ResponseEntity.status(HttpStatus.OK).body(transferDTO);
            }
        }
        return ResponseEntity.badRequest().body(transferDTO);
    }
}
