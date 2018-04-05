package com.lucasmafra.socialnetworking.domain.usecases.readtimeline;

public class ReadTimelineRequestModel {

    private String user;

    public ReadTimelineRequestModel(String user) {
        this.user = user;
    }

    public String getUser() {
        return user;
    }
}
