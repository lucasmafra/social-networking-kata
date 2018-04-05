package com.lucasmafra.socialnetworking.infrastructure.console.views;

import com.lucasmafra.socialnetworking.domain.usecases.View;
import com.lucasmafra.socialnetworking.infrastructure.console.utilities.PrintStream;
import com.lucasmafra.socialnetworking.infrastructure.console.viewmodels.ReadWallViewModel;

import static com.lucasmafra.socialnetworking.infrastructure.console.viewmodels.ReadWallViewModel.*;

public class ReadWallView implements View<ReadWallViewModel> {

    PrintStream printStream;

    public ReadWallView(PrintStream printStream) {
        this.printStream = printStream;
    }

    @Override
    public void generateView(ReadWallViewModel readWallViewModel) {
        for (ViewablePost post : readWallViewModel.getWall()) {
            printStream.print(post.getAuthor() + " - " + post.getMessage() + " (" + post.getElapsedTime() + ")\n");
        }
    }

}
