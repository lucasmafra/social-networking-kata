package com.lucasmafra.socialnetworking.domain.entities;

import java.util.Date;

public class Post {

    private String user;
    private String message;
    private Date createdDate;

    public Post(String user, String message, Date createdDate) {
        this.message = message;
        this.user = user;
        this.createdDate = createdDate;
    }

    public String getMessage() {
        return message;
    }

    public String getUser() {
        return user;
    }

    public Date getCreatedDate() {
        return createdDate;
    }
}
