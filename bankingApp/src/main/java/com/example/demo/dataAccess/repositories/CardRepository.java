package com.example.demo.dataAccess.repositories;

import com.example.demo.dataAccess.entities.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<Card, Long> {
}
