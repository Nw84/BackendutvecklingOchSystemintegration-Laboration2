package com.laboration2.laboration2.service;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

@Service
public class DateAndTimeService {
    

    public boolean isInFuture(int stoptid) {
        LocalDate date = LocalDate.now();
        return stoptid > date.getYear(); 
    }
}
