package com.example.demo.businessLogic.events.commands;

import com.example.demo.dataAccess.dto.ClientDTO;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RegisterNewClient {

    private ClientDTO client;
}
