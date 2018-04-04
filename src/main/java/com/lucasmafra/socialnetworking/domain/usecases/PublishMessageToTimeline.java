package com.lucasmafra.socialnetworking.domain.usecases;

import com.lucasmafra.socialnetworking.domain.gateways.PostGateway;

public class PublishMessageToTimeline {

    private PostGateway postGateway;

    public PublishMessageToTimeline(PostGateway postGateway) {
        this.postGateway = postGateway;
    }

    public void execute(String userId, String message) {

    }
}
