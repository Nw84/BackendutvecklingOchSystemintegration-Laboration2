package com.laboration2.laboration2.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

@Service
public interface DateAndTimeService {
    
    Boolean isInFuture(LocalDateTime stoptid);
}