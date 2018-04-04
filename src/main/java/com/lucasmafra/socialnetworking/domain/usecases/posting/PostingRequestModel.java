package com.lucasmafra.socialnetworking.domain.usecases.posting;

public class PostingRequestModel {

    private String userId;
    private String message;

    public PostingRequestModel(String userId, String message) {
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
