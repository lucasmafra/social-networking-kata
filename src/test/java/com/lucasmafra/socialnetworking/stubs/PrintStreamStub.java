package com.lucasmafra.socialnetworking.stubs;

import com.lucasmafra.socialnetworking.utilities.PrintStream;

public class PrintStreamStub implements PrintStream {

    private String printedContent;

    @Override
    public void print(String content) {
        this.printedContent = content;
    }

    public String getPrintedContent() {
        return printedContent;
    }
}
