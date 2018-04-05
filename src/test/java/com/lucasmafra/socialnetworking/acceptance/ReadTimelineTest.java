package com.lucasmafra.socialnetworking.acceptance;

import com.lucasmafra.socialnetworking.infrastructure.console.main.App;
import com.lucasmafra.socialnetworking.doubles.AppContextStub;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ReadTimelineTest {

    private AppContextStub context;

    private App app;

    @Before public void
    initialize() {
        context = new AppContextStub();
        app = new App(context);
    }

    @Test public void
    user_can_view_users_timeline() throws IOException {

        // Given
        context.getClock().setNow(getDateFiveMinutesAgo()); // set clock to five minutes back
        context.getPostGateway().savePost("Alice", "I love the weather today");
        context.getBufferedReader().setNextLine("Alice");
        context.getClock().setNow(new Date()); // update clock time

        // When
        app.processInput();

        // Then
        String printedContent = context.getPrintStream().getPrintedContent();
        assertThat(printedContent, is("I love the weather today (5 minutes ago)\n"));

    }

    private Date getDateFiveMinutesAgo() {
        Calendar date = Calendar.getInstance();
        date.add(Calendar.MINUTE, -5);
        return date.getTime();
    }

}
