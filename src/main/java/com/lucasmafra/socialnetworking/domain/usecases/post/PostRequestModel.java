package com.lucasmafra.socialnetworking.domain.usecases.post;

public class PostRequestModel {

    private String userId;
    private String message;

    public PostRequestModel(String userId, String message) {
        this.userId = userId;
        this.message = message;
    }

    public String getUserId() {
        return userId;
    }

    public String getMessage() {
        return message;
    }
}
