package com.lucasmafra.socialnetworking.domain.usecases;

import com.lucasmafra.socialnetworking.domain.gateways.PostGateway;
import com.lucasmafra.socialnetworking.domain.usecases.PublishMessageToTimelineUseCase.RequestModel;

public class PublishMessageToTimelineUseCase implements UseCase<RequestModel, Void> {

    private PostGateway postGateway;

    public PublishMessageToTimelineUseCase(PostGateway postGateway) {
        this.postGateway = postGateway;
    }

    public Void execute(RequestModel request) {
        postGateway.savePost(request.userId, request.message);
    }

    public static class RequestModel {

        private String userId;
        private String message;

        public RequestModel(String userId, String message) {
            this.userId = userId;
            this.message = message;
        }

    }
}
