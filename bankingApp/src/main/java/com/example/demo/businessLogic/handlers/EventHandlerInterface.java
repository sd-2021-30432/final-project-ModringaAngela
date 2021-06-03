package com.example.demo.businessLogic.handlers;

import org.springframework.http.ResponseEntity;

public interface EventHandlerInterface<T> {
    ResponseEntity handle(T event );
}
