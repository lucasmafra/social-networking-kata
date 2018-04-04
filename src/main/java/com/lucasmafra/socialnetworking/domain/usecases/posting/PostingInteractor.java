package com.lucasmafra.socialnetworking.domain.usecases.posting;

import com.lucasmafra.socialnetworking.domain.gateways.PostGateway;

public class PostingInteractor implements PostingInputBoundary {

    private PostGateway postGateway;

    public PostingInteractor(PostGateway postGateway) {
        this.postGateway = postGateway;
    }

    @Override
    public void publishMessageToPersonalTimeline(PostingRequestModel request) {
        postGateway.savePost(request.getUserId(), request.getMessage());
    }
}
