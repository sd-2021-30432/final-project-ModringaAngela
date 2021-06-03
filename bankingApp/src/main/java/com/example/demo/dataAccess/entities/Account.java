package com.example.demo.dataAccess.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Account implements IAccountOperations {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Integer counter;

    @ManyToOne
    private Bank bank;

    @Column
    private String type;

    @Column
    private Long balance;

    @ManyToOne
    private Client client;

    @OneToMany(mappedBy = "account")
    private List<Deposit> depositList;

    @OneToMany(mappedBy = "account")
    private List<Card> cardList;

    @Override
    public Long viewBalance() {
        return balance;
    }
}
