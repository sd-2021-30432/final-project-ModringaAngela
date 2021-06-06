package com.example.demo.dataAccess.dto;

import com.example.demo.dataAccess.entities.Card;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CardDTO {

    private Long id;
    private String cardHolderName;
    private Long cardNumber;
    private Date expirationDate;
    private Long cvv;

    public static List<CardDTO> fromEntities(List<Card> cards){
        return cards.stream()
                .map(CardDTO::fromEntity)
                .collect(Collectors.toList());
    }

    public static CardDTO fromEntity(Card card){
        return CardDTO.builder()
                .id(card.getId())
                .cardHolderName(card.getCardHolderName())
                .cardNumber(card.getCardNumber())
                .expirationDate(card.getExpirationDate())
                .cvv(card.getCvv())
                .build();
    }


}
