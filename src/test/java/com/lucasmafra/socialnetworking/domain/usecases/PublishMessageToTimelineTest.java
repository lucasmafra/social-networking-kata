package com.lucasmafra.socialnetworking.domain.usecases;

import com.lucasmafra.socialnetworking.data.Clock;
import com.lucasmafra.socialnetworking.domain.entities.Post;
import com.lucasmafra.socialnetworking.data.InMemoryPostGateway;
import com.lucasmafra.socialnetworking.domain.gateways.PostGateway;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static com.lucasmafra.socialnetworking.domain.usecases.PublishMessageToTimelineUseCase.*;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class PublishMessageToTimelineTest {

    private static final String USER_ID = "Alice";
    private static final Date SYSTEM_DATE = mockDate(2018, Calendar.APRIL, 5, 20, 22, 0);

    @Mock
    private Clock clock;

    private PostGateway postGateway;
    private PublishMessageToTimelineUseCase publishMessageToTimelineUseCase;

    @Before public void
    initialize() {
        postGateway = new InMemoryPostGateway(clock);
        publishMessageToTimelineUseCase = new PublishMessageToTimelineUseCase(postGateway);
    }

    @Test public void
    user_can_publish_message_to_personal_timeline() {

        // Given
        given(clock.now()).willReturn(SYSTEM_DATE);
        String message = "I love the weather today";

        // When
        publishMessageToTimelineUseCase.execute(new RequestModel(USER_ID, message));

        // Then
        List<Post> userPosts = postGateway.getPostsInReverseChronologicalOrder(USER_ID);
        assertThat("expect that 1 post was created", userPosts.size(), is(1));
        Post post = userPosts.get(0);
        assertThat("expect that the created post has correct message", post.getMessage(), is(message));
        assertThat("expect that the created post has correct user id", post.getUserId(), is(USER_ID));
        assertThat("expect that the created post has correct created date", post.getCreatedDate(), is(SYSTEM_DATE));
    }

    private static Date mockDate(int year, int month, int day, int hour, int minute, int second) {
        Calendar date = Calendar.getInstance();
        date.set(year, month, day, hour, minute, second);
        return date.getTime();
    }
}
