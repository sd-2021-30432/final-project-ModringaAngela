package com.example.demo.businessLogic.events.queries;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GetAccountsByClientId {

    Long clientId;
}
