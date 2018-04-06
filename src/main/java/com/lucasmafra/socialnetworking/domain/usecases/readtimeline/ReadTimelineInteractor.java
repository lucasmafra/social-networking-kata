package com.lucasmafra.socialnetworking.domain.usecases.readtimeline;

import com.lucasmafra.socialnetworking.domain.entities.Post;
import com.lucasmafra.socialnetworking.domain.services.TimelineService;

import java.util.List;

import static com.lucasmafra.socialnetworking.domain.usecases.readtimeline.ReadTimelineResponseModel.PostResponse;
import static java.util.stream.Collectors.toList;

public class ReadTimelineInteractor implements ReadTimelineInputBoundary {

    private TimelineService timelineService;

    public ReadTimelineInteractor(TimelineService timelineService) {
        this.timelineService = timelineService;
    }

    @Override
    public void readTimeline(ReadTimelineRequestModel request, ReadTimelineOutputBoundary presenter) {
        List<Post> posts = this.timelineService.getTimelineFor(request.getUser());
        ReadTimelineResponseModel response = mapToResponse(posts);
        presenter.present(response);
    }

    private ReadTimelineResponseModel mapToResponse(List<Post> posts) {
        List<PostResponse> postsResponse = posts.stream()
                                                .map(post -> new PostResponse(post.getMessage(), post.getCreatedDate()))
                                                .collect(toList());
        return new ReadTimelineResponseModel(postsResponse);
    }

}
