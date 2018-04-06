package com.lucasmafra.socialnetworking.acceptance;

import com.lucasmafra.socialnetworking.doubles.AppContextStub;
import com.lucasmafra.socialnetworking.infrastructure.console.main.App;
import org.junit.Before;
import org.junit.Test;

import static java.util.Calendar.MINUTE;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ReadTimelineTest extends BaseAcceptanceTest {

    @Before
    public void
    initialize() {
        context = new AppContextStub();
        app = new App(context);
    }

    @Test
    public void
    user_can_view_users_timeline() {

        // Given
        createPost("Alice", "I love the weather today", 5, MINUTE);
        updateClock();

        // When
        command("Alice");

        // Then
        String printedContent = getPrintedContent();
        String expected = "I love the weather today (5 minutes ago)\n";
        assertThat("the timeline was printed correctly", printedContent, is(expected));

        // And Given
        resetPrinter();
        createPost("Bob", "Damn! We lost!", 2, MINUTE);
        createPost("Bob", "Good game though.", 1, MINUTE);
        updateClock();

        // When
        command("Bob");

        // Then
        printedContent = getPrintedContent();
        expected = "Good game though. (1 minute ago)\n" +
                   "Damn! We lost! (2 minutes ago)\n";
        assertThat("the timeline was printed correctly for multiple posts", printedContent, is(expected));
    }


}
