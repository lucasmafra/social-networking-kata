package com.lucasmafra.socialnetworking.domain.usecases.readtimeline;

import java.util.Date;
import java.util.List;

public class ReadTimelineResponseModel {

    private List<PostItem> timeline;

    public ReadTimelineResponseModel(List<PostItem> timeline) {
        this.timeline = timeline;
    }

    public List<PostItem> getTimeline() {
        return timeline;
    }

    public static class PostItem {

        private String message;
        private Date creationDate;

        public PostItem(String message, Date creationDate) {
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
