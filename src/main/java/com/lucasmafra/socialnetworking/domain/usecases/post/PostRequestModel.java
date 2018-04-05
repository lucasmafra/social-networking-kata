package com.lucasmafra.socialnetworking.domain.usecases.post;

public class PostRequestModel {

    private String user;
    private String message;

    public PostRequestModel(String user, String message) {
        this.user = user;
        this.message = message;
    }

    public String getUser() {
        return user;
    }

    public String getMessage() {
        return message;
    }
}
