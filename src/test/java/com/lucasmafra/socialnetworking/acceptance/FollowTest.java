package com.lucasmafra.socialnetworking.acceptance;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.Assert.assertThat;

public class FollowTest extends BaseAcceptanceTest {

    @Test public void
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
