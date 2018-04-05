package com.lucasmafra.socialnetworking.infrastructure.console.io;

public class PrintStreamImpl implements PrintStream {

    @Override
    public void print(String content) {
        System.out.print(content);
    }
}
