package com.example.demo.businessLogic.events.commands;

import com.example.demo.dataAccess.dto.CardDTO;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RegisterNewCard {

    CardDTO card;
}
