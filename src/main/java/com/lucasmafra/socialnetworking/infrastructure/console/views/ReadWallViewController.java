package com.lucasmafra.socialnetworking.infrastructure.console.views;

import com.lucasmafra.socialnetworking.domain.controller.ViewController;
import com.lucasmafra.socialnetworking.infrastructure.console.utilities.PrintStream;
import com.lucasmafra.socialnetworking.infrastructure.console.viewmodels.ReadWallViewModel;

import static com.lucasmafra.socialnetworking.infrastructure.console.viewmodels.ReadWallViewModel.*;

public class ReadWallViewController implements ViewController<ReadWallViewModel> {

    PrintStream printStream;

    public ReadWallViewController(PrintStream printStream) {
        this.printStream = printStream;
    }

    @Override
    public void generateView(ReadWallViewModel readWallViewModel) {
        for (ViewablePost post : readWallViewModel.getWall()) {
            printStream.print(post.getAuthor() + " - " + post.getMessage() + " (" + post.getElapsedTime() + ")\n");
        }
    }

}
