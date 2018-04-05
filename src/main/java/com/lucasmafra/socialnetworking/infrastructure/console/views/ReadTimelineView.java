package com.lucasmafra.socialnetworking.infrastructure.console.views;

import com.lucasmafra.socialnetworking.domain.usecases.View;
import com.lucasmafra.socialnetworking.infrastructure.console.io.PrintStream;
import com.lucasmafra.socialnetworking.infrastructure.console.viewmodels.ReadTimelineViewModel;

public class ReadTimelineView implements View<ReadTimelineViewModel> {

    private PrintStream printStream;

    public ReadTimelineView(PrintStream printStream) {
        this.printStream = printStream;
    }

    @Override
    public void generateView(ReadTimelineViewModel readTimelineViewModel) {
        readTimelineViewModel
                .getTimeline()
                .forEach(post -> printPost(post.getMessage(), post.getElapsedTime()));
    }

    private void printPost(String message, String elapsedTime) {
        printStream.print(message + " (" + elapsedTime + ")\n");
    }
}
