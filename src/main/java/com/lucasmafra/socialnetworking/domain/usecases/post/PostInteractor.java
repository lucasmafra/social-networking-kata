package com.lucasmafra.socialnetworking.domain.usecases.post;

import com.lucasmafra.socialnetworking.domain.gateways.PostGateway;

public class PostInteractor implements PostInputBoundary {

    private PostGateway postGateway;

    public PostInteractor(PostGateway postGateway) {
        this.postGateway = postGateway;
    }

    @Override
    public void post(PostRequestModel request) {
        postGateway.savePost(request.getUserId(), request.getMessage());
    }
}
