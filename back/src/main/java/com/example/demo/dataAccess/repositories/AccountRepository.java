package com.example.demo.dataAccess.repositories;

import com.example.demo.dataAccess.entities.Account;
import com.example.demo.dataAccess.entities.decorator.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface AccountRepository extends JpaRepository<Account, Long> {

    List<Account> findAccountsByClient(Client client);

    Account findAccountByIban(String iban);

    Account findAccountById(Long accountId);
}
