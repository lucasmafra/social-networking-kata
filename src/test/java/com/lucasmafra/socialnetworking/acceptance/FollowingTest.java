package com.lucasmafra.socialnetworking.acceptance;

import com.lucasmafra.socialnetworking.doubles.AppContextStub;
import com.lucasmafra.socialnetworking.infrastructure.console.main.App;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.is;

import static org.junit.Assert.assertThat;

public class FollowingTest extends BaseAcceptanceTest {

    @Test
    public void
    user_can_subscribe_to_other_users_timeline() {

        // When
        command("Charlie follows Alice");

        // And
        command("Charlie follows Bob");

        // Then
        List<String> following = getFollowingUsersFor("Charlie");
        assertThat("the user is following the correct users", following, is(asList("Alice", "Bob")));
    }

    private List<String> getFollowingUsersFor(String userId) {
        return context.getFollowGateway().getFollowingUsersFor(userId);
    }
}
