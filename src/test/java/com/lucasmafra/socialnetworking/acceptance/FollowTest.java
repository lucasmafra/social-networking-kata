package com.lucasmafra.socialnetworking.acceptance;

import com.lucasmafra.socialnetworking.doubles.AppContextStub;
import com.lucasmafra.socialnetworking.infrastructure.console.main.App;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.Assert.assertThat;

public class FollowTest extends BaseAcceptanceTest {

    @Before
    public void
    initialize() {
        context = new AppContextStub();
        app = new App(context);
    }

    @Test
    public void
    user_can_subscribe_to_other_users_timeline() {

        // When
        command("Charlie follows Alice");

        // And
        command("Charlie follows Bob");

        // Then
        List<String> followings = getFollowingUsersFor("Charlie");
        assertThat("the user is following the correct users", followings, containsInAnyOrder("Alice", "Bob"));
    }

}
