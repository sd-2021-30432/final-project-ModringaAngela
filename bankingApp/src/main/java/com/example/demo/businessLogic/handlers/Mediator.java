package com.example.demo.businessLogic.handlers;

import com.example.demo.businessLogic.events.commands.*;
import com.example.demo.businessLogic.events.queries.GetAccountsByClientId;
import com.example.demo.businessLogic.events.queries.GetCardsByAccountId;
import com.example.demo.businessLogic.events.queries.GetDepositsByAccountId;
import com.example.demo.businessLogic.handlers.getHandlers.GetAccountsByClientIdHandler;
import com.example.demo.businessLogic.handlers.getHandlers.GetCardsByAccountIdHandler;
import com.example.demo.businessLogic.handlers.getHandlers.GetDepositsByAccountIdHandler;
import com.example.demo.businessLogic.handlers.postHandlers.*;
import com.example.demo.businessLogic.handlers.putHandlers.DestroyDepositHandler;
import com.example.demo.businessLogic.handlers.putHandlers.PayBillHandler;
import com.example.demo.businessLogic.handlers.putHandlers.TransferMoneyHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class Mediator {

    private HashMap<Class, Class> _handlerMap = new HashMap<>();

    @Autowired
    private ApplicationContext context;

    public Mediator(){
        _handlerMap.put(Login.class, LoginHandler.class);
        _handlerMap.put(GetAccountsByClientId.class, GetAccountsByClientIdHandler.class);
        _handlerMap.put(GetCardsByAccountId.class, GetCardsByAccountIdHandler.class);
        _handlerMap.put(GetDepositsByAccountId.class, GetDepositsByAccountIdHandler.class);
        _handlerMap.put(CreateDeposit.class, CreateDepositHandler.class);
        _handlerMap.put(DestroyDeposit.class, DestroyDepositHandler.class);
        _handlerMap.put(PayBill.class, PayBillHandler.class);
        _handlerMap.put(RegisterNewAccount.class, RegisterNewAccountHandler.class);
        _handlerMap.put(RegisterNewClient.class, RegisterNewClientHandler.class);
        _handlerMap.put(TransferMoney.class, TransferMoneyHandler.class);
    }

    public <T> ResponseEntity handle(T event){

        Class handlerType = _handlerMap.get(event.getClass());
        try {
            EventHandlerInterface<T> handler = (EventHandlerInterface<T>) context.getBean(handlerType);
            return handler.handle(event);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return null;
    }
}
