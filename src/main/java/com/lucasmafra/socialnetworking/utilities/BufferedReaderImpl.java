package com.lucasmafra.socialnetworking.utilities;

import java.io.IOException;
import java.io.InputStreamReader;

public class BufferedReaderImpl implements BufferedReader {

    java.io.BufferedReader bufferedReader = new java.io.BufferedReader(new InputStreamReader(System.in));

    @Override
    public String readNextLine() throws IOException {
        return bufferedReader.readLine();
    }
}
