package com.example.demo.dataAccess.dto;

import com.example.demo.dataAccess.entities.Account;
import com.example.demo.dataAccess.entities.Deposit;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DepositDTO {

    private Long id;
    private Long accountId;
    private Integer period;
    private Integer amountOfMoney;

    public static DepositDTO fromEntity(Deposit deposit){
        return DepositDTO.builder()
                .id(deposit.getId())
                .period(deposit.getPeriod())
                .amountOfMoney(deposit.getAmount())
                .accountId(deposit.getAccount().getId())
                .build();
    }

    public static List<DepositDTO> fromEntities(List<Deposit> deposits){
        return deposits.stream()
                .map(DepositDTO::fromEntity)
                .collect(Collectors.toList());
    }

}
