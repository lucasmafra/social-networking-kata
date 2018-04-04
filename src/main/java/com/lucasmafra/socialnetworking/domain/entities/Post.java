package com.lucasmafra.socialnetworking.domain.entities;

import java.util.Date;

public class Post {

    private String userId;
    private String message;
    private Date createdDate;

    public Post(String userId, String message, Date createdDate) {
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

    public Date getCreatedDate() {
        return createdDate;
    }
}
