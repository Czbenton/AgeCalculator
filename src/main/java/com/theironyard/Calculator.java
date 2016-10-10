package com.theironyard;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;

/**
 * Created by Zach on 10/7/16.
 */

public class Calculator {

    public static Period calculateAge(String birthday) {

        CharSequence charSequence = birthday;

        LocalDate start = LocalDate.parse(charSequence);
        LocalDate end = LocalDate.now();

        Period p = Period.between(start, end);

        return p;

    }
}
