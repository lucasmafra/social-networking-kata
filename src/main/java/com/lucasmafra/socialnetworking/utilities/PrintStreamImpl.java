package com.lucasmafra.socialnetworking.utilities;

public class PrintStreamImpl implements PrintStream {

    @Override
    public void print(String content) {
        System.out.print(content);
    }
}
