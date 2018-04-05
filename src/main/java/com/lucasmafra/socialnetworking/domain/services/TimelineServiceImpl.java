package com.lucasmafra.socialnetworking.domain.services;

import com.lucasmafra.socialnetworking.domain.entities.Post;
import com.lucasmafra.socialnetworking.domain.gateways.PostGateway;
import com.lucasmafra.socialnetworking.domain.utilities.Clock;

import java.util.List;

public class TimelineServiceImpl implements TimelineService {

    private PostGateway postGateway;
    private Clock clock;

    public TimelineServiceImpl(PostGateway postGateway, Clock clock) {
        this.postGateway = postGateway;
        this.clock = clock;
    }

    @Override
    public void postToTimeline(String user, String message) {
        Post post = createPostFrom(user, message);
        postGateway.savePost(post);
    }

    @Override
    public List<Post> getTimelineFor(String user) {
        return postGateway.getPostsInReverseChronologicalOrderFor(user);
    }

    private Post createPostFrom(String user, String message) {
        return new Post(user, message, clock.now());
    }
}
