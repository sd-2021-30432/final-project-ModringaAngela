package com.example.demo.dataAccess.repositories;

import com.example.demo.dataAccess.dto.DepositDTO;
import com.example.demo.dataAccess.entities.Account;
import com.example.demo.dataAccess.entities.Deposit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DepositRepository extends JpaRepository<Deposit, Long> {

    List<Deposit> findDepositsByAccount(Account account);
}
