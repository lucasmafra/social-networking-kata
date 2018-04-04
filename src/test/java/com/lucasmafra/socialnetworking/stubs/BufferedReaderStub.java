package com.lucasmafra.socialnetworking.stubs;

import com.lucasmafra.socialnetworking.utilities.BufferedReader;

import java.io.IOException;

public class BufferedReaderStub implements BufferedReader {

    private String nextLine;

    @Override
    public String readNextLine() throws IOException {
        return nextLine;
    }

    public void setNextLine(String nextLine) {
        this.nextLine = nextLine;
    }
}
