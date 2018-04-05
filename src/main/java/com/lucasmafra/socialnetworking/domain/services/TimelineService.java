package com.lucasmafra.socialnetworking.domain.services;

import com.lucasmafra.socialnetworking.domain.entities.Post;

import java.util.List;

public interface TimelineService {
    void postToTimeline(String user, String message);

    List<Post> getTimelineFor(String user);
}
