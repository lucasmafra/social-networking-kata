package com.lucasmafra.socialnetworking.doubles;

import com.lucasmafra.socialnetworking.infrastructure.console.utilities.BufferedReader;

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
