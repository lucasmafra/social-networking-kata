package com.lucasmafra.socialnetworking.infrastructure.console.views;

import com.lucasmafra.socialnetworking.domain.usecases.readtimeline.ReadTimelineView;
import com.lucasmafra.socialnetworking.domain.usecases.readtimeline.ReadTimelineViewModel;
import com.lucasmafra.socialnetworking.infrastructure.console.io.PrintStream;

public class ReadTimelineConsoleView implements ReadTimelineView {

    private PrintStream printStream;

    public ReadTimelineConsoleView(PrintStream printStream) {
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
