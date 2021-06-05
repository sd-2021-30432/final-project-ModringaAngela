package com.example.demo.service;

import com.example.demo.dataAccess.dto.CardDTO;
import com.example.demo.dataAccess.dto.DepositDTO;
import com.example.demo.dataAccess.entities.Account;
import com.example.demo.dataAccess.entities.Card;
import com.example.demo.dataAccess.entities.Deposit;
import com.example.demo.dataAccess.repositories.AccountRepository;
import com.example.demo.dataAccess.repositories.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardService {

    @Autowired
    private CardRepository cardRepository;

    @Autowired
    private AccountRepository accountRepository;

    public List<CardDTO> getCardsByAccountId(Long accountId){

        Account account = accountRepository.findById(accountId).get();

        List<Card> cards = cardRepository.findCardsByAccount(account);
        List<CardDTO> cardsDto = CardDTO.fromEntities(cards);

        return cardsDto;
    }

}
