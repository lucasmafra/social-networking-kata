package com.lucasmafra.socialnetworking.domain.usecases.readtimeline;

import com.lucasmafra.socialnetworking.domain.entities.Post;
import com.lucasmafra.socialnetworking.domain.gateways.PostGateway;

import java.util.List;

import static com.lucasmafra.socialnetworking.domain.usecases.readtimeline.ReadTimelineResponseModel.*;
import static java.util.stream.Collectors.*;

public class ReadTimelineInteractor implements ReadTimelineInputBoundary {

    private PostGateway postGateway;

    public ReadTimelineInteractor(PostGateway postGateway) {
        this.postGateway = postGateway;
    }

    @Override
    public void readTimeline(ReadTimelineRequestModel request, ReadTimelineOutputBoundary presenter) {
        List<Post> posts = this.postGateway.getPostsInReverseChronologicalOrder(request.getUserId());
        ReadTimelineResponseModel response = new ReadTimelineResponseModel(
                posts.stream()
                .map(post -> new PostItem(post.getMessage(), post.getCreatedDate()))
                .collect(toList())
        );
        presenter.present(response);
    }
}
