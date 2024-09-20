package com.luv2code.springcoredemo.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach {

    public CricketCoach() {
        System.out.println("Inside constructor: " + getClass().getName());
    }

    @PostConstruct
    public void init() {
        System.out.println("Inside init method: " + getClass().getName());
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Inside destroy method: " + getClass().getName());
    }

    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling for 15 minutes!";
    }
}
