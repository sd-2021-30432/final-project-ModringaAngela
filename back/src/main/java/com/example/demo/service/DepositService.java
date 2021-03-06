package com.example.demo.service;

import com.example.demo.dataAccess.dto.DepositDTO;
import com.example.demo.dataAccess.entities.Account;
import com.example.demo.dataAccess.entities.Deposit;
import com.example.demo.dataAccess.repositories.AccountRepository;
import com.example.demo.dataAccess.repositories.DepositRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    private Deposit transformDTOToEntity(DepositDTO depositDTO, Account account){
        return new Deposit.DepositBuilder(depositDTO.getId())
                .setAccount(account)
                .setPeriod(depositDTO.getPeriod())
                .setAmount(depositDTO.getAmountOfMoney())
                .calculateIncome()
                .buildDeposit();
    }

    public ResponseEntity<DepositDTO> createDeposit(DepositDTO deposit){

        Account account = accountRepository.findAccountById(deposit.getAccountId());

        if(account.getBalance() >= deposit.getAmountOfMoney()){

            Deposit depositEntity = transformDTOToEntity(deposit, account);

            Deposit _Deposit = depositRepository.save(depositEntity);

            account.setBalance(account.getBalance() - deposit.getAmountOfMoney());
            Account _Account = accountRepository.save(account);

            return ResponseEntity.status(HttpStatus.OK).body(deposit);
        }

        return ResponseEntity.badRequest().body(null);
    }

    public ResponseEntity<String> destroyDeposit(Long depositId){

        Deposit deposit = depositRepository.findById(depositId).get();
        Account account = accountRepository.findAccountById(deposit.getAccount().getId());

        account.setBalance(account.getBalance() + deposit.getAmount());

        Account _Account = accountRepository.save(account);

        depositRepository.deleteById(deposit.getId());
        return ResponseEntity.status(HttpStatus.OK).body("Done");
    }

}
