package com.example.demo.dataAccess.repositories;

import com.example.demo.dataAccess.entities.Account;
import com.example.demo.dataAccess.entities.Card;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CardRepository extends JpaRepository<Card, Long> {

    List<Card> findCardsByAccount(Account account);
}
