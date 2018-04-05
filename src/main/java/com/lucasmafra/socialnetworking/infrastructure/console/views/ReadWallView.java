package com.lucasmafra.socialnetworking.infrastructure.console.views;

import com.lucasmafra.socialnetworking.domain.usecases.View;
import com.lucasmafra.socialnetworking.infrastructure.console.io.PrintStream;
import com.lucasmafra.socialnetworking.infrastructure.console.viewmodels.ReadWallViewModel;

public class ReadWallView implements View<ReadWallViewModel> {

    PrintStream printStream;

    public ReadWallView(PrintStream printStream) {
        this.printStream = printStream;
    }

    @Override
    public void generateView(ReadWallViewModel readWallViewModel) {
        readWallViewModel
                .getWall()
                .forEach(post -> printPost(post.getAuthor(), post.getMessage(), post.getElapsedTime()));
    }

    private void printPost(String author, String message, String elapsedTime) {
        printStream.print(author + " - " + message + " (" + elapsedTime + ")\n");
    }

}
