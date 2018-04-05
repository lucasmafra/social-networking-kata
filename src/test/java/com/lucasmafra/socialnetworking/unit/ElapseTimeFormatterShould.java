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
    return_a_moment_ago_for_two_dates_between_less_than_one_minute() {
        endDate = createDateFrom(initialDate, Calendar.SECOND, 0);
        assertThat(formatter.format(initialDate, endDate), is("a moment ago"));

        endDate = createDateFrom(initialDate, Calendar.SECOND, 59);
        assertThat(formatter.format(initialDate, endDate), is("a moment ago"));
    }

    private Date createDateFrom(Date initialDate, int calendarUnit, int amount) {
        Calendar initial = Calendar.getInstance();
        initial.setTime(initialDate);
        initial.add(calendarUnit, amount);
        return initial.getTime();
    }
}
