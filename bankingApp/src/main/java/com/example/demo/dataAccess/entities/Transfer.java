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
public class Transfer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String iban;

    @Column
    private Integer amountOfMoney;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn (name = "from_account", referencedColumnName = "id")
    private Account fromAccount;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn (name = "to_account", referencedColumnName = "id")
    private Account toAccount;
}
