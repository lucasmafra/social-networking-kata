package com.lucasmafra.socialnetworking.doubles;

import com.lucasmafra.socialnetworking.infrastructure.Clock;

import java.util.Calendar;
import java.util.Date;

public class ClockStub implements Clock {

    private Date now;

    @Override
    public Date now() {
        return now;
    }

    public static Date asDate(int year, int month, int day, int hour, int minute, int second) {
        Calendar date = Calendar.getInstance();
        date.set(year, month, day, hour, minute, second);
        return date.getTime();
    }

    public void setNow(Date now) {
        this.now = now;
    }
}
