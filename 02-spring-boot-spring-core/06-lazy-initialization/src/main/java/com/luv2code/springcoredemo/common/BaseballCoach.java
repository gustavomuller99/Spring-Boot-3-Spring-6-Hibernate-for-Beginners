package com.luv2code.springcoredemo.common;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class BaseballCoach implements Coach {

    public BaseballCoach() {
        System.out.println("Inside constructor: " + getClass().getName());
    }

    @Override
    public String getDailyWorkout() {
        return "BaseballCoach";
    }
}
