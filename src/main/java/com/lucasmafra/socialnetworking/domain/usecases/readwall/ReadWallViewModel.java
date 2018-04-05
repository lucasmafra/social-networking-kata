package com.lucasmafra.socialnetworking.domain.usecases.readwall;

import java.util.List;

public class ReadWallViewModel {

    List<ViewablePost> wall;

    public ReadWallViewModel(List<ViewablePost> wall) {
        this.wall = wall;
    }

    public List<ViewablePost> getWall() {
        return wall;
    }

    public static class ViewablePost {

        private String author;
        private String message;
        private String elapsedTime;

        public ViewablePost(String author, String message, String elapsedTime) {
            this.author = author;
            this.message = message;
            this.elapsedTime = elapsedTime;
        }

        public String getAuthor() {
            return author;
        }

        public String getMessage() {
            return message;
        }

        public String getElapsedTime() {
            return elapsedTime;
        }
    }
}
