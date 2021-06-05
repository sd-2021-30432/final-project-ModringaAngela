package com.example.demo.dataAccess.repositories;

import com.example.demo.dataAccess.entities.Client;
import com.example.demo.dataAccess.entities.Transfer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransferRepository extends JpaRepository<Transfer, Long> {
}
