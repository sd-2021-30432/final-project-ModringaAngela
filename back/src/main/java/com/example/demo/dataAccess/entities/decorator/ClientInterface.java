package com.example.demo.dataAccess.entities.decorator;

import com.example.demo.dataAccess.entities.Account;

import java.util.Date;
import java.util.List;

public interface ClientInterface {

    Long getId();

    String getFirstName();

    String getLastName();

    String getUsername();

    String getPassword();

    Date getDob();

    Integer getAge();

    List<Account> getAccounts();

}
