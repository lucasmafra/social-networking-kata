package com.lucasmafra.socialnetworking.domain.usecases.readtimeline;

public class ReadTimelineRequestModel {

    private String userId;

    public ReadTimelineRequestModel(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }
}
