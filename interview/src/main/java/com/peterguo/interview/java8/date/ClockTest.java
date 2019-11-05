package com.peterguo.interview.java8.date;

import java.time.Clock;
import java.time.Instant;
import java.util.Date;

public class ClockTest {

    public static void main(String[] args) {
        Clock clock = Clock.systemDefaultZone(); //获取默认时区
        long millis = clock.millis();
        System.out.println(millis);

        Instant instant = clock.instant();
        System.out.println(instant);

        Date legacyDate = Date.from(instant);
        System.out.println(legacyDate);

    }
}
