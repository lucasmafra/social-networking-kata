package com.lucasmafra.socialnetworking.infrastructure.console.io;

import java.io.IOException;

public interface BufferedReader {
    String readNextLine() throws IOException;
}
