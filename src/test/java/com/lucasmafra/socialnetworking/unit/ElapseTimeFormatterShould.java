package com.lucasmafra.socialnetworking.unit;

import com.lucasmafra.socialnetworking.infrastructure.console.utilities.ElapsedTimeFormatter;
import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ElapseTimeFormatterShould {

    private ElapsedTimeFormatter formatter;
    private Date initialDate;
    private Date endDate;

    @Before public void
    initialize() {
        formatter = new ElapsedTimeFormatter();
        initialDate = new Date();
    }

    @Test public void
    return_the_elapsed_seconds_for_intervals_less_than_one_minute() {
        endDate = createDateFrom(initialDate, Calendar.SECOND, 1);
        assertThat(formatter.format(initialDate, endDate), is("1 second ago"));

        endDate = createDateFrom(initialDate, Calendar.SECOND, 59);
        assertThat(formatter.format(initialDate, endDate), is("59 seconds ago"));
    }

    @Test public void
    return_the_elapsed_minutes_for_intervals_greater_than_one_minute_but_less_than_hour() {
        endDate = createDateFrom(initialDate, Calendar.MINUTE, 1);
        assertThat(formatter.format(initialDate, endDate), is("1 minute ago"));

        endDate = createDateFrom(initialDate, Calendar.MINUTE, 59);
        assertThat(formatter.format(initialDate, endDate), is("59 minutes ago"));
    }

    @Test public void
    return_the_elapsed_hours_for_intervals_greater_than_one_hour_but_less_than_one_day() {
        endDate = createDateFrom(initialDate, Calendar.HOUR, 1);
        assertThat(formatter.format(initialDate, endDate), is("1 hour ago"));

        endDate = createDateFrom(initialDate, Calendar.HOUR, 23);
        assertThat(formatter.format(initialDate, endDate), is("23 hours ago"));
    }

    @Test public void
    return_the_elapsed_days_for_intervals_greater_than_one_day() {
        endDate = createDateFrom(initialDate, Calendar.DATE, 1);
        assertThat(formatter.format(initialDate, endDate), is("1 day ago"));

        endDate = createDateFrom(initialDate, Calendar.DATE, 6);
        assertThat(formatter.format(initialDate, endDate), is("6 days ago"));
    }

    private Date createDateFrom(Date initialDate, int calendarUnit, int amount) {
        Calendar initial = Calendar.getInstance();
        initial.setTime(initialDate);
        initial.add(calendarUnit, amount);
        return initial.getTime();
    }
}
