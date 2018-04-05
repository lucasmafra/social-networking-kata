package com.lucasmafra.socialnetworking.doubles;

import com.lucasmafra.socialnetworking.infrastructure.console.utilities.PrintStream;

public class PrintStreamStub implements PrintStream {

    private String printedContent = "";

    @Override
    public void print(String content) {
        if (!content.equals("> ")) { // ignore command prefix
            this.printedContent += content;
        }
    }

    public String getPrintedContent() {
        return printedContent;
    }

    public void resetPrinter() {
        printedContent = "";
    }
}
