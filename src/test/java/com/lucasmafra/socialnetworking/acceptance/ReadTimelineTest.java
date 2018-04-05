package com.lucasmafra.socialnetworking.acceptance;

import com.lucasmafra.socialnetworking.infrastructure.console.main.App;
import com.lucasmafra.socialnetworking.doubles.AppContextStub;
import org.junit.Before;
import org.junit.Test;

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
    user_can_view_users_timeline() {

        // Given
        context.getClock().setNow(getMinutesAgo(5)); // set clock to 5 minutes back
        context.getPostGateway().savePost("Alice", "I love the weather today"); // create post to test
        context.getBufferedReader().setNextLine("Alice");
        context.getClock().setNow(new Date()); // update clock time

        // When
        app.processInput();

        // Then
        String printedContent = context.getPrintStream().getPrintedContent();
        String expected = "I love the weather today (5 minutes ago)\n";
        assertThat("the timeline was printed correctly for one post", printedContent, is(expected));

        // And
        context.getPrintStream().resetPrinter();

        // Given
        context.getClock().setNow(getMinutesAgo(2)); // set clock to 2 minutes back
        context.getPostGateway().savePost("Bob", "Damn! We lost!"); // create post to test
        context.getClock().setNow(getMinutesAgo(1)); // set clock to 1 minute back
        context.getPostGateway().savePost("Bob", "Good game though."); // create post to test
        context.getBufferedReader().setNextLine("Bob");
        context.getClock().setNow(new Date()); // update clock time


        // When
        app.processInput();

        // Then
        printedContent = context.getPrintStream().getPrintedContent();
        expected = "Good game though. (1 minute ago)\n" + "Damn! We lost! (2 minutes ago)\n";
        assertThat("the timeline was printed correctly for multiple posts", printedContent, is(expected));
    }

    private Date getMinutesAgo(int minutes) {
        Calendar date = Calendar.getInstance();
        date.add(Calendar.MINUTE, -minutes);
        return date.getTime();
    }

}
