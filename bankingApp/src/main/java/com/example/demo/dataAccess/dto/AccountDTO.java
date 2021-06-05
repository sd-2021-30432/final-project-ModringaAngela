package com.example.demo.dataAccess.dto;

import com.example.demo.dataAccess.entities.Account;
import com.example.demo.dataAccess.entities.Bank;
import com.example.demo.dataAccess.entities.Client;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AccountDTO {
    private Long id;
    private Integer counter;
    private String bankName;
    private String type;
    private Long balance;
    private String iban;

    public static List<AccountDTO> fromEntities(List<Account> accounts){
        return accounts.stream()
                .map(AccountDTO::fromEntity)
                .collect(Collectors.toList());
    }

    public static AccountDTO fromEntity(Account account){
        return AccountDTO.builder()
                .id(account.getId())
                .iban(account.getIban())
                .counter(account.getCounter())
                .bankName(account.getBank().getName())
                .type(account.getType())
                .balance(account.getBalance())
                .build();
    }
}
