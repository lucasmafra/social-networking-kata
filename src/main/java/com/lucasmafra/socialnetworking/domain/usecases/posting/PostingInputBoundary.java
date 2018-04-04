package com.lucasmafra.socialnetworking.domain.usecases.posting;

public interface PostingInputBoundary {

    void publishMessageToPersonalTimeline(PostingRequestModel request);
}
