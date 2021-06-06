package com.example.demo.dataAccess.entities.decorator;

import com.example.demo.dataAccess.entities.Account;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientDecorator implements ClientInterface  {

    private ClientInterface client;

    @Override
    public Long getId() {
        return client.getId();
    }

    @Override
    public String getFirstName() {
        return client.getFirstName();
    }

    @Override
    public String getLastName() {
        return client.getLastName();
    }

    @Override
    public String getUsername() {
        return client.getUsername();
    }

    @Override
    public String getPassword() {
        return client.getPassword();
    }

    @Override
    public Date getDob() {
        return client.getDob();
    }

    @Override
    public Integer getAge() {
        return client.getAge();
    }

    @Override
    public List<Account> getAccounts() {
       return client.getAccounts();
    }
}
