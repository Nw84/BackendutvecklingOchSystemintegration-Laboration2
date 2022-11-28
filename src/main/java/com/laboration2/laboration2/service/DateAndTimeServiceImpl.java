package com.laboration2.laboration2.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

@Service
public class DateAndTimeServiceImpl implements DateAndTimeService {


    @Override
    public Boolean isInFuture(LocalDateTime stoptid) {
        LocalDateTime now = LocalDateTime.now();
        Boolean isAfter = stoptid.isAfter(now);
        return isAfter;
    }
}
