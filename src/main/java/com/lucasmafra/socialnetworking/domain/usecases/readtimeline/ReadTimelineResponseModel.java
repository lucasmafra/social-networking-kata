package com.lucasmafra.socialnetworking.domain.usecases.readtimeline;

import java.util.Date;
import java.util.List;

public class ReadTimelineResponseModel {

    private List<PostResponse> posts;

    public ReadTimelineResponseModel(List<PostResponse> posts) {
        this.posts = posts;
    }

    public List<PostResponse> getPosts() {
        return posts;
    }

    public static class PostResponse {

        private String message;
        private Date creationDate;

        public PostResponse(String message, Date creationDate) {
            this.message = message;
            this.creationDate = creationDate;
        }

        public String getMessage() {
            return message;
        }

        public Date getCreationDate() {
            return creationDate;
        }
    }
}
