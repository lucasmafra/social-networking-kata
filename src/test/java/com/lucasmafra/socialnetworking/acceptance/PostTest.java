package com.lucasmafra.socialnetworking.acceptance;

import com.lucasmafra.socialnetworking.domain.entities.Post;
import com.lucasmafra.socialnetworking.doubles.AppContextStub;
import com.lucasmafra.socialnetworking.infrastructure.console.main.App;
import org.junit.Before;
import org.junit.Test;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class PostTest extends BaseAcceptanceTest {

    @Before public void
    initialize() {
        context = new AppContextStub();
        app = new App(context);
    }

    @Test public void
    user_can_publish_message_to_personal_timeline() {

        // Given
        Date now = setClock(2018, Calendar.APRIL, 6, 8, 4, 0);

        // When
        command("Alice -> I love the weather today");

        // Then
        List<Post> posts = getPosts("Alice");
        assertThat("1 post was created", posts.size(), is(1));
        Post post = posts.get(0);
        assertThat("the post has correct user id", post.getUser(), is("Alice"));
        assertThat("the post has correct message", post.getMessage(), is("I love the weather today"));
        assertThat("the post has correct created date", post.getCreatedDate(), is(now));
    }

    @Test public void
    user_can_publish_multiple_messages_to_personal_timeline() {

        // When
        command("Bob -> Damn! We lost!");
        command("Bob -> Good game though.");

        // Then
        List<Post> posts = getPosts("Bob");
        assertThat("2 posts were created", posts.size(), is(2));

    }

}