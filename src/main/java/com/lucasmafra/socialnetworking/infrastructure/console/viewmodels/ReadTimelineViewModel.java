package com.lucasmafra.socialnetworking.infrastructure.console.viewmodels;

import java.util.List;

public class ReadTimelineViewModel {

    private List<ViewablePost> timeline;

    public ReadTimelineViewModel(List<ViewablePost> timeline) {
        this.timeline = timeline;
    }

    public List<ViewablePost> getTimeline() {
        return timeline;
    }

    public static class ViewablePost {
        private String message;
        private String elapsedTime;

        public ViewablePost(String message, String elapsedTime) {
            this.message = message;
            this.elapsedTime = elapsedTime;
        }

        public String getMessage() {
            return message;
        }

        public String getElapsedTime() {
            return elapsedTime;
        }
    }
}
