package com.lucasmafra.socialnetworking.domain.usecases.postontimeline;

import com.lucasmafra.socialnetworking.domain.services.TimelineService;

public class PostOnTimelineInteractor implements PostOnTimelineInputBoundary {

    private TimelineService timelineService;

    public PostOnTimelineInteractor(TimelineService timelineService) {
        this.timelineService = timelineService;
    }

    @Override
    public void post(PostOnTimelineRequestModel request) {
        timelineService.postToTimeline(request.getUser(), request.getMessage());
    }
}
