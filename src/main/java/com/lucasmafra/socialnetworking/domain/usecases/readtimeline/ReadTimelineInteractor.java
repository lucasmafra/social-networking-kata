package com.lucasmafra.socialnetworking.domain.usecases.readtimeline;

import com.lucasmafra.socialnetworking.domain.entities.Post;
import com.lucasmafra.socialnetworking.domain.gateways.PostGateway;
import com.lucasmafra.socialnetworking.domain.services.TimelineService;

import java.util.List;

import static com.lucasmafra.socialnetworking.domain.usecases.readtimeline.ReadTimelineResponseModel.*;
import static java.util.stream.Collectors.*;

public class ReadTimelineInteractor implements ReadTimelineInputBoundary {

    private TimelineService timelineService;

    public ReadTimelineInteractor(TimelineService timelineService) {
        this.timelineService = timelineService;
    }

    @Override
    public void readTimeline(ReadTimelineRequestModel request, ReadTimelineOutputBoundary presenter) {
        List<Post> posts = this.timelineService.getTimelineFor(request.getUser());
        ReadTimelineResponseModel response = new ReadTimelineResponseModel(
                posts.stream()
                .map(post -> new PostItem(post.getMessage(), post.getCreatedDate()))
                .collect(toList())
        );
        presenter.present(response);
    }
}
