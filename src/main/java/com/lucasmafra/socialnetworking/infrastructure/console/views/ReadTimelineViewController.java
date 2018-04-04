package com.lucasmafra.socialnetworking.infrastructure.console.views;

import com.lucasmafra.socialnetworking.domain.controller.ViewController;
import com.lucasmafra.socialnetworking.infrastructure.console.viewmodels.ReadTimelineViewModel;
import com.lucasmafra.socialnetworking.infrastructure.console.utilities.PrintStream;

import static com.lucasmafra.socialnetworking.infrastructure.console.viewmodels.ReadTimelineViewModel.*;

public class ReadTimelineViewController implements ViewController<ReadTimelineViewModel> {

    private PrintStream printStream;

    public ReadTimelineViewController(PrintStream printStream) {
        this.printStream = printStream;
    }

    @Override
    public void generateView(ReadTimelineViewModel readTimelineViewModel) {
        for (ViewablePost post : readTimelineViewModel.getTimeline()) {
            printStream.print(post.getMessage() + " (" + post.getElapsedTime() + ")\n");
        }
    }
}
