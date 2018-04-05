package com.lucasmafra.socialnetworking.acceptance;

import com.lucasmafra.socialnetworking.doubles.AppContextStub;
import com.lucasmafra.socialnetworking.infrastructure.console.main.App;
import org.junit.Before;
import org.junit.Test;

import static java.util.Calendar.*;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ReadWallTest extends BaseAcceptanceTest {

    @Before public void initialize() {
        context = new AppContextStub();
        app = new App(context);
    }

    @Test public void
    user_can_view_an_aggregated_list_of_all_subscriptions() {

        // Given
        createPost("Alice", "I love the weather today", 5, MINUTE);
        createPost("Charlie", "I'm in New York today! Anyone want to have a coffee?", 2, SECOND);
        createFollow("Charlie", "Alice");
        updateClock();

        // When
        command("Charlie wall");

        // Then
        String printedContent = getPrintedContent();
        String expected = "Charlie - I'm in New York today! Anyone want to have a coffee? (2 seconds ago)\n" +
                          "Alice - I love the weather today (5 minutes ago)\n";
        assertThat("the timeline was printed correctly", printedContent, is(expected));

        // And Given
        resetPrinter();
        createPost("Bob", "Good game though.", 1, MINUTE);
        createPost("Bob", "Damn! We lost!", 2, MINUTE);
        createFollow("Charlie", "Bob");
        updateClock();

        // When
        command("Charlie wall");

        // Then
        printedContent = getPrintedContent();
        expected = "Charlie - I'm in New York today! Anyone want to have a coffee? (2 seconds ago)\n" +
                   "Bob - Good game though. (1 minute ago)\n" +
                   "Bob - Damn! We lost! (2 minutes ago)\n" +
                   "Alice - I love the weather today (5 minutes ago)\n";
        assertThat("the timeline was printed correctly", printedContent, is(expected));

    }

}
