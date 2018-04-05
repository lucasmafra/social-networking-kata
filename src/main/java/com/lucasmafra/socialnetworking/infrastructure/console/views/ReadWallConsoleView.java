package com.lucasmafra.socialnetworking.infrastructure.console.views;

import com.lucasmafra.socialnetworking.domain.usecases.readwall.ReadWallView;
import com.lucasmafra.socialnetworking.domain.usecases.readwall.ReadWallViewModel;
import com.lucasmafra.socialnetworking.infrastructure.console.io.PrintStream;

public class ReadWallConsoleView implements ReadWallView {

    PrintStream printStream;

    public ReadWallConsoleView(PrintStream printStream) {
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
