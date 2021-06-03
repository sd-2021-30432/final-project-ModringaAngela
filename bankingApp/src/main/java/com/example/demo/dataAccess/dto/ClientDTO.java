package com.example.demo.dataAccess.dto;
import com.example.demo.dataAccess.entities.Client;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ClientDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private Date dob;
    private String username;
    private String password;
    private List<AccountDTO> accounts;

    public static ClientDTO fromEntity(Client client){
        return ClientDTO.builder()
                .id(client.getId())
                .firstName(client.getFirstName())
                .lastName(client.getLastName())
                .dob(client.getDob())
                .username(client.getUsername())
                .password(client.getPassword())
                .accounts(AccountDTO.fromEntities(client.getAccounts()))
                .build();

    }
}
