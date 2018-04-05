package com.lucasmafra.socialnetworking.domain.usecases.readwall;

import java.util.Date;
import java.util.List;

public class ReadWallResponseModel {

    private List<PostItem> wall;

    public ReadWallResponseModel(List<PostItem> wall) {
        this.wall = wall;
    }

    public List<PostItem> getWall() {
        return wall;
    }

    public static class PostItem {

        private String author;
        private String message;
        private Date creationDate;

        public PostItem(String author, String message, Date creationDate) {
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
