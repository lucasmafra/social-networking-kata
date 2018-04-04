package com.lucasmafra.socialnetworking.domain.entities;

public class Post {

    private String message;
    private String userId;
    private String createdDate;

    public Post(String message, String userId, String createdDate) {
        this.message = message;
        this.userId = userId;
        this.createdDate = createdDate;
    }

    public String getMessage() {
        return message;
    }

    public String getUserId() {
        return userId;
    }

    public String getCreatedDate() {
        return createdDate;
    }
}
