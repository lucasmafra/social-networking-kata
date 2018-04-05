package com.lucasmafra.socialnetworking.doubles;

import com.lucasmafra.socialnetworking.infrastructure.console.io.BufferedReader;

public class BufferedReaderStub implements BufferedReader {

    private String nextLine;

    @Override
    public String readNextLine() {
        return nextLine;
    }

    public void setNextLine(String nextLine) {
        this.nextLine = nextLine;
    }
}
