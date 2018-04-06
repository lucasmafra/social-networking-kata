package com.lucasmafra.socialnetworking.domain.usecases.readwall;

import java.util.Date;
import java.util.List;

public class ReadWallResponseModel {

    private List<PostResponse> posts;

    public ReadWallResponseModel(List<PostResponse> posts) {
        this.posts = posts;
    }

    public List<PostResponse> getPosts() {
        return posts;
    }

    public static class PostResponse {

        private String author;
        private String message;
        private Date creationDate;

        public PostResponse(String author, String message, Date creationDate) {
            this.author = author;
            this.message = message;
            this.creationDate = creationDate;
        }

        public String getAuthor() {
            return author;
        }

        public String getMessage() {
            return message;
        }

        public Date getCreationDate() {
            return creationDate;
        }
    }
}
