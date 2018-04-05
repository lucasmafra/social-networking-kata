package com.lucasmafra.socialnetworking.acceptance;

import com.lucasmafra.socialnetworking.domain.entities.Post;
import com.lucasmafra.socialnetworking.domain.gateways.PostGateway;
import com.lucasmafra.socialnetworking.infrastructure.console.main.App;
import com.lucasmafra.socialnetworking.doubles.AppContextStub;
import com.lucasmafra.socialnetworking.doubles.ClockStub;
import org.junit.Before;
import org.junit.Test;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class PostTest {

    private AppContextStub context;

    private Date now;

    private App app;

    @Before public void
    initialize() {
        context = new AppContextStub();
        app = new App(context);
    }

    @Test public void
    user_can_publish_message_to_personal_timeline() {

        // Given
        context.getBufferedReader().setNextLine("Alice -> I love the weather today");
        now = ClockStub.asDate(2018, Calendar.APRIL, 6, 8, 4, 0);
        context.getClock().setNow(now); // adjust clock

        // When
        app.processInput();

        // Then
        PostGateway postGateway = context.getPostGateway();
        List<Post> userPosts = postGateway.getPostsInReverseChronologicalOrder("Alice");
        assertThat("1 post was created", userPosts.size(), is(1));
        Post post = userPosts.get(0);
        assertThat("the post has correct user id", post.getUserId(), is("Alice"));
        assertThat("the post has correct message", post.getMessage(), is("I love the weather today"));
        assertThat("the post has correct created date", post.getCreatedDate(), is(now));
    }

    @Test public void
    user_can_publish_multiple_messages_to_personal_timeline() {

        // Given
        context.getBufferedReader().setNextLine("Bob -> Damn! We lost!"); // First post
        now = ClockStub.asDate(2018, Calendar.APRIL, 6, 8, 0, 0);
        context.getClock().setNow(now); // adjust clock
        app.processInput();

        // And
        context.getBufferedReader().setNextLine("Bob -> Damn! We lost!"); // Second post
        now = ClockStub.asDate(2018, Calendar.APRIL, 10, 9, 0, 0);
        context.getClock().setNow(now); // adjust clock


        // When
        app.processInput();

        // Then
        PostGateway postGateway = context.getPostGateway();
        List<Post> userPosts = postGateway.getPostsInReverseChronologicalOrder("Bob");
        assertThat("2 posts were created", userPosts.size(), is(2));
    }


}