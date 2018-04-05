package com.lucasmafra.socialnetworking.acceptance;

import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ReadTimelineTest extends BaseAcceptanceTest {

    @Test public void
    user_can_view_users_timeline() {

        // Given
        createPost("Alice", "I love the weather today", 5);
        updateClock();

        // When
        command("Alice");

        // Then
        String printedContent = getPrintedContent();
        String expected = "I love the weather today (5 minutes ago)\n";
        assertThat("the timeline was printed correctly", printedContent, is(expected));

        // And Given
        resetPrinter();
        createPost("Bob", "Damn! We lost!", 2);
        createPost("Bob", "Good game though.", 1);
        updateClock();

        // When
        command("Bob");

        // Then
        printedContent = getPrintedContent();
        expected = "Good game though. (1 minute ago)\n" + "Damn! We lost! (2 minutes ago)\n";
        assertThat("the timeline was printed correctly for multiple posts", printedContent, is(expected));
    }

    private void createPost(String userId, String message, int minutesAgo) {
        context.getClock().setNow(getMinutesAgo(minutesAgo));
        context.getPostGateway().savePost(userId, message);
    }

    private void updateClock() {
        context.getClock().setNow(new Date());
    }

    private Date getMinutesAgo(int minutes) {
        Calendar date = Calendar.getInstance();
        date.add(Calendar.MINUTE, -minutes);
        return date.getTime();
    }

}
