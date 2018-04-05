package com.lucasmafra.socialnetworking.domain.usecases.readtimeline;

public interface ReadTimelineInputBoundary {
    void readTimeline(ReadTimelineRequestModel request, ReadTimelineOutputBoundary presenter);
}
