package com.lucasmafra.socialnetworking.infrastructure.console.utilities;

public class PrintStreamImpl implements PrintStream {

    @Override
    public void print(String content) {
        System.out.print(content);
    }
}
