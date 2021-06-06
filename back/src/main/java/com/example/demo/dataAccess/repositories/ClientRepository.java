package com.example.demo.dataAccess.repositories;

import com.example.demo.dataAccess.entities.decorator.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {

    Client findClientByUsernameAndPassword(String username, String password);
}
