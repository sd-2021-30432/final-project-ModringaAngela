package com.example.demo.dataAccess.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String cardHolderName;

    @Column
    private Long cardNumber;

    @Column
    private Date expirationDate;

    @Column
    private Long cvv;

    @ManyToOne
    private Account account;

}
