package com.example.demo.dataAccess.repositories;

import com.example.demo.dataAccess.entities.Bank;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankRepository extends JpaRepository<Bank, Long> {

    Bank findByName(String name);
}
