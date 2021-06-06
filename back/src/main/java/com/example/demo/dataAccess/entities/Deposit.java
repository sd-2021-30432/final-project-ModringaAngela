package com.example.demo.dataAccess.entities;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Deposit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Account account;

    @Column
    private Integer period;

    @Column
    private Integer amount;

    @Column
    private Double income;

    private Deposit(DepositBuilder builder){
        this.id = builder.id;
        this.account = builder.account;
        this.period = builder.period;
        this.amount = builder.amount;
        this.income = builder.income;
    }


    public static class DepositBuilder{

        private Long id;
        private Account account;
        private Integer period;
        private Integer amount;
        private Double income;

        public DepositBuilder(Long id){
            this.id = id;
        }

        public DepositBuilder setAccount(Account account){
            this.account = account;
            return this;
        }

        public DepositBuilder setPeriod(Integer period){
            this.period = period;
            return this;
        }

        public DepositBuilder setAmount(Integer amount){
            this.amount = amount;
            return this;
        }

        public DepositBuilder calculateIncome(){
            this.income = Double.valueOf(amount) * period / 100;
            return this;
        }

        public Deposit buildDeposit(){
            Deposit deposit  = new Deposit(this);
            return deposit;
        }
    }
}
