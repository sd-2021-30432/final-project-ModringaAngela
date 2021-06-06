package com.example.demo.dataAccess.entities.decorator;

import lombok.Data;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;

@Data
public class ClientAgeDecorator extends ClientDecorator{

    public Integer age;

    public ClientAgeDecorator(ClientInterface client){
        super(client);
        this.age = findAge(client);
    }

    public Integer findAge(ClientInterface client){

        ZoneId defaultZoneId = ZoneId.systemDefault();
        LocalDate nowLocal = LocalDate.now();

        Date now = Date.from(nowLocal.atStartOfDay(defaultZoneId).toInstant());
        Date dob = client.getDob();

        Instant dobInstant = dob.toInstant();
        Instant nowInstant = now.toInstant();

        int age_month = (int) ChronoUnit.DAYS.between(dobInstant, nowInstant);
        int age = age_month / 365;
        return Integer.valueOf(age);
    }
}
