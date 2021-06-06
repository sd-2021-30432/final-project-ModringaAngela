package com.example.demo.dataAccess.dto;


import com.example.demo.dataAccess.entities.Transfer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TransferDTO {

    private Long id;
    private String iban;
    private Integer amountOfMoney;
    private Long accountFromId;
    private Long accountToId;

    public static TransferDTO fromEntity(Transfer transfer){
        return TransferDTO.builder()
                .id(transfer.getId())
                .iban(transfer.getIban())
                .amountOfMoney(transfer.getAmountOfMoney())
                .accountFromId(transfer.getFromAccount().getId())
                .accountToId(transfer.getToAccount().getId())
                .build();
    }

    public static List<TransferDTO> fromEntities(List<Transfer> transfers){
        return transfers.stream()
                .map(TransferDTO::fromEntity)
                .collect(Collectors.toList());
    }

}
