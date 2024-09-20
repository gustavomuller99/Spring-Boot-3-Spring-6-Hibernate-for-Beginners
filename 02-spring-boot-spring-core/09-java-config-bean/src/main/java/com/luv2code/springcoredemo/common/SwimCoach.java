package com.luv2code.springcoredemo.common;

public class SwimCoach implements Coach {

    public SwimCoach() {
        System.out.println("Inside constructor: " + getClass().getName());
    }

    @Override
    public String getDailyWorkout() {
        return "Swim Coach";
    }
}
