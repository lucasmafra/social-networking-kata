package com.lucasmafra.socialnetworking.domain.usecases.post;

public interface PostInputBoundary {
    void publishMessageToPersonalTimeline(PostRequestModel request);
}
