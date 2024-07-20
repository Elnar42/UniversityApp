package com.example.university.enums;

import lombok.Getter;

import java.time.Period;

@Getter
public enum Semester {
    FALL(Period.ofMonths(4)), SPRING(Period.ofMonths(4)), SUMMER(Period.ofMonths(1).plusDays(15));

    private final Period period;

     Semester(Period period){
        this.period = period;
    }
}
